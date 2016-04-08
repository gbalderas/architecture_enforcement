package architecture;

import architecture.checks.ModelConstraintRule;
import architecture.checks.ViewConstraintRule;
import architecture.checks.ViewModelConstraintRule;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.Arrays;

/**
 * Created by gerardo.balderas on 04.04.2016.
 */
public class MvvmFileCheckRegistrar implements CheckRegistrar {

    /**
     * Register the classes that will be used to instantiate checks during analysis.
     */
    @Override
    public void register(RegistrarContext registrarContext) {
        // Call to registerClassesForRepository to associate the classes with the correct repository key
        registrarContext.registerClassesForRepository(MvvmRulesDefinition.REPOSITORY_KEY, Arrays.asList(checkClasses()), Arrays.asList(testCheckClasses()));
    }

    /**
     * Lists all the checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] checkClasses() {
        return new Class[] {
                ViewModelConstraintRule.class,
                ViewConstraintRule.class,
                ModelConstraintRule.class
        };
    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static Class<? extends JavaCheck>[] testCheckClasses() {
        return new Class[] {};
    }
}