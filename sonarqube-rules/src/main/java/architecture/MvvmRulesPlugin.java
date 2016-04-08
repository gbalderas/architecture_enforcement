package architecture;

import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gerardo.balderas on 04.04.2016.
 */
public class MvvmRulesPlugin extends SonarPlugin{
    @Override
    public List getExtensions() {
        return Arrays.asList(
                // server extensions -> objects are instantiated during server startup
                MvvmRulesDefinition.class,

                // batch extensions -> objects are instantiated during code analysis
                MvvmFileCheckRegistrar.class);
    }
}
