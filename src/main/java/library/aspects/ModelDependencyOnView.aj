package library.aspects;


public aspect ModelDependencyOnView {

    //Generics
    pointcut getGenericTypeModel(): get(*..*<library.model..*> library.views..*);
    pointcut executionGenericTypeModel(): execution(*..*<library.model.*> de.saxsys.mvvmfx.FxmlView+.*(..));
    pointcut executionArgsGenericTypeModel(): execution(* de.saxsys.mvvmfx.FxmlView+.*(.., *..*<library.model.*>, ..));

    pointcut callGenericTypeModel(): call(*..*<library.model.*> de.saxsys.mvvmfx.FxmlView+.*(..));
    pointcut callArgsGenericTypeModel(): call(* de.saxsys.mvvmfx.FxmlView+.*(.., *..*<library.model.*>, ..));

    pointcut setGenericTypeModel(): set(*..*<library.model..*> de.saxsys.mvvmfx.FxmlView+.*);

    //Model Objects
    pointcut getModelObject(): get(library.model..* de.saxsys.mvvmfx.FxmlView+.*);
    pointcut executionArgsModel(): execution(* de.saxsys.mvvmfx.FxmlView+.*(.., library.model.*, ..));
    pointcut callArgsModel(): call(* de.saxsys.mvvmfx.FxmlView+.*(.., library.model.*, ..));
    pointcut setModelObject(): set(library.model..* de.saxsys.mvvmfx.FxmlView+.*);


// ALTERNATIV:
//    pointcut withinFxmlView() : within(de.saxsys.mvvmfx.FxmlView+);
//    pointcut execB(): execution(*..*<library.model.*> *(..));
//    declare error: execB() && withinFxmlView() : "error message";

    //Generics
//    declare error: getGenericTypeModel():"Field in View with a generic type from Model used";
//    declare error: setGenericTypeModel(): "Object with generic type of Model was set or new instance was made";
//
//    declare error: executionGenericTypeModel(): "Method in View with returning object with a generic type from Model not valid";
//    declare error: executionArgsGenericTypeModel():"Methods with arguments with generic type of Model not Valid";
//
//    declare error: callGenericTypeModel():"Call to a method with returning object with a generic type from Model";
//    declare error: callArgsGenericTypeModel(): "Call to a Method with arguments with generic type of Model";
//
//    //Model Objects
//    declare error: getModelObject(): "Usage of a Model object";
//    declare error: setModelObject(): "Model object was set or new instance was made in Views";
//
//    declare error: executionArgsModel():"Methods with arguments of type Model not valid";
//    declare error: callArgsModel(): "Methods with arguments of Type Model called";

   }