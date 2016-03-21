package library.rulebreakingpackage;

import de.saxsys.mvvmfx.FxmlView;
import library.model.BadModel;

import java.util.Date;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadView implements FxmlView<BadViewModel> {

    public static String testString = "test";

    public static void test(){

        //View should not call model methods!
        BadModel.modelStaticMethod();
        Date date = new Date();

    }

}
