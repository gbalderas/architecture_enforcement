package library.aspects;

/**
 * Created by gerardo.balderas on 25.02.2016.
 */
public aspect ViewArchitecturalEnforcement {
//
////    pointcut withinFxmlView() : within(de.saxsys.mvvmfx.FxmlView+);
//    @Pointcut("within(de.saxsys.mvvmfx.FxmlView+)")
//    void withinFxmlView(){}
//
//
////    pointcut callToModel() : call(* model..*(..));
//    @Pointcut("call(* model..*(..))")
//    void callToModel(){}
//
////    pointcut newModelCall() : call(model..new(..));
//    @Pointcut("call(model..new(..))")
//    void newModelCall(){}
//
//    pointcut executionToModel() : execution(* model..*(..));
//
////    declare error: withinFxmlView() && callToModel() : "View should not call model";
//    @DeclareError("withinFxmlView() && callToModel()")
//    static final String modelCallFromViewError = "View should not call model";
//
//    //    declare error : withinFxmlView() && newModelCall() : "Views should not create model Instances";
//    @DeclareError("withinFxmlView() && newModelCall()")
//    static final String modelInstanceCallFromViewError = "Views should not create model Instances";
//
//
//    declare error : executionToModel() && withinFxmlView(): "Views should not execute model methods";
}
