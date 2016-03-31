package library.rulebreakingpackage;

import de.saxsys.mvvmfx.ViewModel;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadViewModel implements ViewModel {



    public void test(){
//
        BadView.testString.toString();

        BadViewTwo badView = new BadViewTwo();
        BadView.test();

    }
}
