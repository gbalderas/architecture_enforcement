package library.rulebreakingpackage;

import de.saxsys.mvvmfx.FxmlView;
import library.model.BadModel;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadView implements FxmlView<BadViewModel> {

    public static final String TESTSTRING = "test";

    private static final Class thisClass = BadView.class;

    private BadView badView;

    public BadView(){
        badView = this;
    }

    public static void test(){

        //View should not call model methods!
        BadModel.modelStaticMethod();
//        Date date = new Date();

    }


    public void myPublicMethod(){
        System.out.println("testing myPublicMethod!");
    }

    public static Class getBadViewClass(){
        return thisClass;
    }

    public Object getBadView(){
        return badView;
    }

}
