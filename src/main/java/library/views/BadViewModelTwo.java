package library.views;

import de.saxsys.mvvmfx.ViewModel;

/**
 * Created by balderas on 21.03.16.
 */
public class BadViewModelTwo implements ViewModel {


    public static void callToViewTest(){
        SecondBadView view = new SecondBadView();
    }


    public String myCall(){
        return "hello";
    }
}
