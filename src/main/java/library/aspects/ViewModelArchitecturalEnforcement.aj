package library.aspects;

import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by gerardo.balderas on 29.02.2016.
 */
public aspect ViewModelArchitecturalEnforcement {

//    pointcut withinViewModel() : within(de.saxsys.mvvmfx.ViewModel+);
//
//    pointcut newViewCall() : call((de.saxsys.mvvmfx.FxmlView+).new(..));
//    pointcut callToView() : call(* (de.saxsys.mvvmfx.FxmlView+).*(..));
//
//    declare error: withinViewModel() && callToView(): "viewmodels should not call views";
//    declare error: withinViewModel() && newViewCall(): "viewmodels should not create view instances";


    @Pointcut("within(de.saxsys.mvvmfx.ViewModel+)")
    void withinViewModel(){}

    @Pointcut("call((de.saxsys.mvvmfx.FxmlView+).new(..))")
    void newViewCall(){}

    @Pointcut("call(* (de.saxsys.mvvmfx.FxmlView+).*(..))")
    void callToView(){}

    @DeclareError("withinViewModel() && callToView()")
    public static final String viewModelCallsView = "ViewModels should not call views";

    @DeclareError("withinViewModel() && newViewCall()")
    public static final String viewModelCallsNewView = "Viewmodels should not create view instances";
}
