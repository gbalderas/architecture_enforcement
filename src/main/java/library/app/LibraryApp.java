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
    }

    public static void main(String[] a){
        launch(a);
    }


}
