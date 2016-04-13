package architecture.checks;

import com.google.common.collect.ImmutableList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

import java.util.*;

/**
 * Created by gerardo.balderas on 06.04.2016.
 */
@Rule(
        key = "MVVM-ViewConstraint",
        name = "Views should not depend on Model Package",
        description = "This rule detects usage of Model method or Instances inside a View",
        priority = Priority.BLOCKER,
        tags = {"mvvm", "architecture"})
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_RELIABILITY)
@SqaleConstantRemediation("15min")
public class ViewConstraintRule extends IssuableSubscriptionVisitor {

    //    @RuleProperty(description = "FxmlView Interface")
    String fromFxmlViewInterface = "de.saxsys.mvvmfx.FxmlView";
    //    @RuleProperty(description = "JavaView Interface")
//    String fromJavaViewInterface = "de.saxsys.mvvmfx.JavaView";
    @RuleProperty(description = "Model Package")
    String toModelPackage = "*.model.*";


    private Deque<String> shouldCheck = new LinkedList<>();
    private Deque<Set<String>> issues = new LinkedList<>();
    private Deque<Symbol> currentType = new LinkedList<>();

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.CLASS, Tree.Kind.ENUM, Tree.Kind.INTERFACE, Tree.Kind.ANNOTATION_TYPE, Tree.Kind.IDENTIFIER);
    }

    @Override
    public void visitNode(Tree tree) {
        if (tree.is(Tree.Kind.IDENTIFIER)) {
            check((IdentifierTree) tree);
        } else {
            initClass((ClassTree) tree);
        }
    }


    private void initClass(ClassTree tree) {
        Util.initClass(tree, fromFxmlViewInterface, shouldCheck, issues, currentType);
    }


    private void check(IdentifierTree tree) {

        String shouldCheckId = shouldCheck.peekFirst();
        if (shouldCheckId == null) {
            return;
        }

        Symbol symbol = tree.symbol();
        if (!symbol.isUnknown() && !currentType.contains(symbol.owner())) {
            Type type = symbol.type();
            if (!type.isUnknown()) {
                String fullyQualifiedName = type.fullyQualifiedName();
                Set<String> currentIssues = issues.peekFirst();
                if (Util.matchesPattern(toModelPackage, fullyQualifiedName)) {
                    System.out.println("view should not use model!");
                    reportIssue(tree, shouldCheckId + " must not use " + fullyQualifiedName);
                    currentIssues.add(fullyQualifiedName);
                }

            }
        }
    }

    @Override
    public void leaveNode(Tree tree) {
        if (!tree.is(Tree.Kind.IDENTIFIER)) {
            shouldCheck.removeFirst();
            issues.removeFirst();
            currentType.pop();
        }
    }

}
