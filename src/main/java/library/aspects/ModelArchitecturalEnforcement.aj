package library.aspects;

import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by gerardo.balderas on 02.03.2016.
 */
public aspect ModelArchitecturalEnforcement {


//    pointcut withinModel(): within(model..*);
//
//    pointcut newViewModelCall() : call((de.saxsys.mvvmfx.ViewModel+).new(..));
//    pointcut callToViewModel() : call(* (de.saxsys.mvvmfx.ViewModel+).*(..));
//
//    pointcut newViewCall() : call((de.saxsys.mvvmfx.FxmlView+).new(..));
//    pointcut callToView() : call(* (de.saxsys.mvvmfx.FxmlView+).*(..));
//
//
//    declare error: withinModel() && callToView() :"model should not call views";
//    declare error: withinModel() && callToViewModel() :"model should not call viewmodels";
//    declare error: withinModel() && newCallToView() : "model should not create a view Instance";
//    declare error: withinModel() && newViewModelCall() : "model should not create a ViewModel Instance";


    @Pointcut("within(*.model..*)")
    void withinModel(){}

    declare error: withinModel() && call(* library..*.*(..)) && !call(* library.model.*.*(..)) : "model should not call outside model" ;

    @Pointcut("call((de.saxsys.mvvmfx.ViewModel+).new(..))")
    void newCallToViewModel(){}

    @Pointcut("call(* (de.saxsys.mvvmfx.ViewModel+).*(..))")
    void  callToViewModel(){}

    @Pointcut("call((de.saxsys.mvvmfx.FxmlView+).new(..))")
    void  newCallToView(){}

    @Pointcut("call(* (de.saxsys.mvvmfx.FxmlView+).*(..))")
    void  callToView() {}

    @DeclareError("withinModel() && callToView()")
    public static final String modelCallsView = "Model should not call Views";

    @DeclareError("withinModel() && callToViewModel()")
    public static final String modelCallsViewModels = "Model should not call ViewModels";

    @DeclareError("withinModel() && newCallToView()")
    public static final String modelCallsNewView = "model should not create a view Instance";

    @DeclareError("withinModel() && newCallToViewModel()")
    public static final String modelCallsNewViewModel = "model should not create a ViewModel Instance";




}
