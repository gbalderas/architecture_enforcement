package architecture;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

/**
 * Created by gerardo.balderas on 04.04.2016.
 */
public class MvvmRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "mvvmfx";

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, "java");
        repository.setName("mvvmfx");

        AnnotationBasedRulesDefinition.load(repository, "java", RulesList.getChecks());
        repository.done();
    }
}
