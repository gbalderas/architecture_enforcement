package architecture;

import architecture.checks.ModelConstraintRule;
import architecture.checks.ViewConstraintRule;
import architecture.checks.ViewModelConstraintRule;
import com.google.common.collect.ImmutableList;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

/**
 * Created by gerardo.balderas on 04.04.2016.
 */
public class RulesList {

    private RulesList(){}

    public static List<Class> getChecks() {
        return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                .add(ViewModelConstraintRule.class)
                .add(ViewConstraintRule.class)
                .add(ModelConstraintRule.class)
                .build();
    }

    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return ImmutableList.<Class<? extends JavaCheck>>builder()
                .build();
    }



}
