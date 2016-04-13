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
        key = "MVVM-ModelConstraint",
        name = "Model should not call View Interfaces",
        description = "This rule detects usage of View method or Instances inside a Model",
        priority = Priority.BLOCKER,
        tags = {"mvvm", "architecture"})
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_RELIABILITY)
@SqaleConstantRemediation("15min")
public class ModelConstraintRule extends IssuableSubscriptionVisitor {

    @RuleProperty(description = "Optional. If this property is not defined, all classes should adhere to this constraint. Ex : **.web.**")
    String fromClasses = "*.model.*";

    @RuleProperty(description = "Mandatory. Ex : java.util.Vector, java.util.Hashtable, java.util.Enumeration")
    String toFxmlViewInterface = "de.saxsys.mvvmfx.FxmlView";

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

    private void check(IdentifierTree tree) {
        String shouldCheckId = shouldCheck.peekFirst();
        if (shouldCheckId == null) {
            return;
        }
        Symbol symbol = tree.symbol();
        if (!symbol.isUnknown() && !currentType.contains(symbol.owner())) {
            Type type = symbol.type();
            String fullyQualifiedName = type.fullyQualifiedName();
            boolean matchesToInterface = type.symbol().interfaces().stream()
                    .anyMatch(i -> i.fullyQualifiedName().equals(toFxmlViewInterface));
            Set<String> currentIssues = issues.peekFirst();
            if (!currentIssues.contains(fullyQualifiedName) && matchesToInterface) {
                System.out.println("Model should not call View Interfaces");
                reportIssue(tree, shouldCheckId + " must not use " + fullyQualifiedName);
                currentIssues.add(fullyQualifiedName);
            }
        }
    }

    private void initClass(ClassTree tree) {
        Symbol.TypeSymbol symbol = tree.symbol();
        String fullyQualifiedName = symbol.type().fullyQualifiedName();
        if (Util.matchesPattern(fromClasses, fullyQualifiedName)) {
            shouldCheck.addFirst(fullyQualifiedName);
            issues.addFirst(new HashSet<String>());
        } else {
            shouldCheck.addFirst(null);
            issues.addFirst(null);
        }
        currentType.push(tree.symbol());
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
