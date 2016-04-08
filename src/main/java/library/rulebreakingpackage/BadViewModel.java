package library.rulebreakingpackage;

import de.saxsys.mvvmfx.ViewModel;
import library.model.BadModel;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
public class BadViewModel implements ViewModel {



    public void test(){


        BadView.test();

        BadViewTwo badView = new BadViewTwo();
        BadView.test();

        Class badViewClass = BadModel.getBadViewClass();
        badViewClass.getSimpleName();

        Object badViewObject = BadModel.getBadView();
        ((BadView)badViewObject).myPublicMethod();

    }
}
