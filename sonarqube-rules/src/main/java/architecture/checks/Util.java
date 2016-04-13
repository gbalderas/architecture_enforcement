package architecture.checks;

import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.tree.ClassTree;

import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gerardo.balderas on 13.04.2016.
 */
public class Util {
    private Util(){}


    public static boolean matchesPattern(String somePackage, String fqn){
        if(somePackage.equals("*")){
            return true;
        }
        if(somePackage.startsWith("*")){
            return fqn.matches("."+somePackage);
        }

        return fqn.matches(somePackage);
    }


    public static void initClass(ClassTree tree, String packageToMatch, Deque<String> shouldCheck, Deque<Set<String>> issues, Deque<Symbol> currentType){
        Symbol.TypeSymbol symbol = tree.symbol();
        String fullyQualifiedName = symbol.type().fullyQualifiedName();
        boolean foundInterface = symbol.interfaces().stream()
                .anyMatch(i -> i.fullyQualifiedName().equals(packageToMatch));
//                        || i.fullyQualifiedName().equals(fromJavaViewInterface));

        if (foundInterface) {
            shouldCheck.addFirst(fullyQualifiedName);
            issues.addFirst(new HashSet<>());
        } else {
            shouldCheck.addFirst(null);
            issues.addFirst(null);
        }
        currentType.push(tree.symbol());
    }


}
