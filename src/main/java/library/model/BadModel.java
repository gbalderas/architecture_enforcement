package library.model;

import library.rulebreakingpackage.BadView;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadModel {

    public void BadMethod(){

        //Model shouldn't have access to the view
        BadView badView = new BadView();
        badView.test();

    }


    public static void modelStaticMethod(){

    }
}
