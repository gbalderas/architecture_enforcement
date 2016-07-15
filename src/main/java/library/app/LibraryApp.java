package library.app;

import de.saxsys.mvvmfx.FluentViewLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.views.MainView;

/**
 * Created by gerardo.balderas on 11.03.2016.
 */
public class LibraryApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String title = "Library App";
        stage.setTitle(title);
        Scene scene = new Scene(FluentViewLoader.fxmlView(MainView.class).load().getView());

        stage.setScene(scene);
        stage.show();

        Foo.getStrings();

//        Rule1Bad.somemethod();
//        Rule1Ok.somemethod();
//        Rule2Bad.somemethod();
//        Rule2Ok.somemethod();
//        Rule3Bad.sayHello();
//        Rule3Ok.sayHello();
//        Rule4Bad.sayHello();
//        Rule4Bad.sayHello2();
//        Rule4Bad.sayHello3();
//        Rule4Ok.sayHello();
//        Rule5Bad.sayHello();
//        Rule5Bad.sayHello2();
//        Rule5Bad.sayHello3();
//        Rule5Bad.sayHello4();
//        Rule5Bad.sayHello5();
//        Rule5Ok.sayHello();
//        Rule5Ok.sayHello2();
//        Rule5Ok.sayHello3();
    }

    public static void main(String[] a){
        launch(a);
    }


}
