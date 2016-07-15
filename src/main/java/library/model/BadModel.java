package library.model;


import library.annotations.Attribute;
import library.views.BadView;

/**
 * Created by gerardo.balderas on 16.03.2016.
 */
@Attribute(info = "HELLO")
public class BadModel {

    public void badMethod(){

        //Model shouldn't have access to the view
        BadView badView = new BadView();
        BadView.test();

        badView.myPublicMethod();

        BadModel2.something();
    }


    public static void modelStaticMethod(){
        System.out.println("nothing");

    }

    public static Object getBadView(){
        BadView badView = new BadView();
        return badView.getBadView();
    }

    public static Class getBadViewClass(){
        return BadView.getBadViewClass();
    }
}
