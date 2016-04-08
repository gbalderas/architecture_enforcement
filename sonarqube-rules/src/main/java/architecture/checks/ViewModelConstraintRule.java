package architecture.checks;

import com.google.common.collect.ImmutableList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
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
 * Created by gerardo.balderas on 04.04.2016.
 */


@Rule(
        key = "MVVM-ViewModelConstraint",
        name = "ViewModel should not depend on View",
        description = "This rule detects usage of View method or Instances inside a ViewModel",
        priority = Priority.BLOCKER,
        tags = {"mvvm", "architecture"})
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_RELIABILITY)
@SqaleConstantRemediation("15min")
public class ViewModelConstraintRule extends IssuableSubscriptionVisitor {

//    @RuleProperty(description = "ViewModel Interface")
    String fromViewModelInterface = "de.saxsys.mvvmfx.ViewModel";

//    @RuleProperty(description = "FxmlView Interface")
    String toFxmlViewInterface = "de.saxsys.mvvmfx.FxmlView";
//    @RuleProperty(description = "JavaView Interface")
//    String toJavaViewInterface = "de.saxsys.mvvmfx.JavaView";

    private Deque<String> shouldCheck = new LinkedList<>();
    private Deque<Set<String>> issues = new LinkedList<>();
    private Deque<Symbol> currentType = new LinkedList<>();

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.CLASS, Tree.Kind.INTERFACE, Tree.Kind.IDENTIFIER);
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

        Symbol.TypeSymbol symbol = tree.symbol();
        String fullyQualifiedName = symbol.type().fullyQualifiedName();
        boolean foundInterface = symbol.interfaces().stream()
                .anyMatch(i -> i.fullyQualifiedName().equals(fromViewModelInterface));

        if (foundInterface) {
            shouldCheck.addFirst(fullyQualifiedName);
            issues.addFirst(new HashSet<>());
        } else {
            shouldCheck.addFirst(null);
            issues.addFirst(null);
        }
        currentType.push(tree.symbol());
    }


    private void check(IdentifierTree tree) {

        String shouldCheckId = shouldCheck.peekFirst();
        if (shouldCheckId == null) {
            return;
        }

        Symbol symbol = tree.symbol();
        if (!symbol.isUnknown() && !currentType.contains(symbol.owner())) {
            Type type = symbol.type();
            String fqn = type.fullyQualifiedName();

            boolean matchesToInterface = type.symbol().interfaces().stream()
                    .anyMatch(i -> i.fullyQualifiedName().equals(toFxmlViewInterface));
//                            || i.fullyQualifiedName().equals(toJavaViewInterface));
            Set<String> currentIssues = issues.peekFirst();
//            if (!currentIssues.contains(fqn) && matchesToInterface) {
            if (matchesToInterface) {
                System.out.println("ViewModel issue was added :D");
                reportIssue(tree, shouldCheckId + " must not depend on " + fqn);
                currentIssues.add(fqn);
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
