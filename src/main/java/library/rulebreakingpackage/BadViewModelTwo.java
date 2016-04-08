package library.rulebreakingpackage;

import de.saxsys.mvvmfx.ViewModel;

/**
 * Created by balderas on 21.03.16.
 */
public class BadViewModelTwo implements ViewModel {


    public static void callToViewTest(){
        BadViewTwo view = new BadViewTwo();
    }


    public String myCall(){
        return "hello";
    }
}
