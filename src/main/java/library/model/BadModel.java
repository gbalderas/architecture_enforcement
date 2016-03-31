package library.model;


import library.rulebreakingpackage.BadModel2;
import library.rulebreakingpackage.BadView;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadModel {

    public void BadMethod(){

        //Model shouldn't have access to the view
        BadView badView = new BadView();
        badView.test();


        BadModel2.something();
    }


    public static void modelStaticMethod(){

    }
}
