package library.views;

import de.saxsys.mvvmfx.ViewModel;
import library.model.BadModel;
import library.model.RecipeMap;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadViewModel implements ViewModel {

    public static void hello(){

    }

    public void test(){

        RecipeMap.getRecipes().forEach((name, recipe) ->{
            BadView.test();
        });


        BadView.test();

        SecondBadView badView = new SecondBadView();
        BadView.test();

        Class badViewClass = BadModel.getBadViewClass();
        badViewClass.getSimpleName();

        Object badViewObject = BadModel.getBadView();
        ((BadView)badViewObject).myPublicMethod();

    }
}
