package library.aspects;

/**
 * Created by gerardo.balderas on 11.07.2016.
 */
public aspect NoUIElements {

    pointcut setUIElementsOnModel():
                    set(javafx.scene..* library.model.*.*) ||
                    set(java.awt..* library.model.*.*) ||
                    set(javax.swing..* library.model.*.*);

    pointcut setUIElementsOnViewModel():
            set(javafx.scene..* de.saxsys.mvvmfx.ViewModel+.*) ||
                    set(java.awt..* de.saxsys.mvvmfx.ViewModel+.*) ||
                    set(javax.swing..* de.saxsys.mvvmfx.ViewModel+.*);

    pointcut getUIElementsOnModel():
            get(javafx.scene..* library.model.*.*) ||
                    get(java.awt..* library.model.*.*) ||
                    get(javax.swing..* library.model.*.*);

    pointcut getUIElementsOnViewModel():
            get(javafx.scene..* de.saxsys.mvvmfx.ViewModel+.*) ||
                    get(java.awt..* de.saxsys.mvvmfx.ViewModel+.*) ||
                    get(javax.swing..* de.saxsys.mvvmfx.ViewModel+.*);

    pointcut callUIElements():
            call(* javafx.scene..*.*(..)) || call(javafx.scene..*.new(..)) ||
                    call(* java.awt..*.*(..)) || call(java.awt..*.new(..)) ||
                    call(* javax.swing..*.*(..)) || call(javax.swing..*.new(..));

    pointcut withinModel(): within(library.model.*);
    pointcut withinViewModel(): within(de.saxsys.mvvmfx.ViewModel+);

//    declare error: setUIElementsOnModel() || setUIElementsOnViewModel(): "No UI Elements allowed here";
//    declare error: getUIElementsOnViewModel() || getUIElementsOnViewModel():" ui elements get";
//
//    declare error: callUIElements() && withinModel(): "ui elements in model";
//    declare error: callUIElements() && withinViewModel(): "ui elements in viewmodel";



    //    \begin{itemize}
//    \item javafx:\begin{itemize}
//    \item javafx.application.Application;
//    \item javafx.scene.Scene;
//    \item javafx.scene.Control;
//    \item javafx.stage.Stage;
//    \end{itemize}
//
//    \item java AWT:
//            \begin{itemize}
//    \item java.awt.*
//            \end{itemize}
//    \item java Swing:
//            \begin{itemize}
//    \item javax.swing.*
//            \end{itemize}
//    \end{itemize}
}

