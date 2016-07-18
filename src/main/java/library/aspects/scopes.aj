package library.aspects;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by gerardo.balderas on 13.07.2016.
 */
public aspect Scopes {

    Boolean isScopeProviderValid = false;

    Stack<String> viewModelStack = new Stack<>();
    Stack<String> scopeProviderStack = new Stack<>();

    pointcut executionNewView(): execution(de.saxsys.mvvmfx.FxmlView+.new(..));
    pointcut executionNewVM(Object vm): execution(de.saxsys.mvvmfx.ViewModel+.new(..)) && target(vm);
    declare parents : (de.saxsys.mvvmfx.FxmlView+ && !de.saxsys.mvvmfx.FxmlView) implements library.aspects.InitImpl;

    after(Object vm): executionNewVM(vm){
        Annotation[] annotations = vm.getClass().getAnnotations();
        Arrays.stream(annotations)
                .filter(a -> a.annotationType().getCanonicalName()
                        .equals(de.saxsys.mvvmfx.ScopeProvider.class.getCanonicalName()))
                .findAny()
                .ifPresent(a -> {
                    System.out.println("    ScopeProvider found!");
                    isScopeProviderValid = true;
                    scopeProviderStack.push(viewModelStack.peek());
                });
        Arrays.stream(vm.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(de.saxsys.mvvmfx.InjectScope.class) && !isScopeProviderValid)
                .findAny()
                .ifPresent(a -> System.out.println("    SCOPE IS NOT VALID on " + viewModelStack.peek() + "!"));
//                    try {
//                        throw new Exception("Scope is not valid");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }

//        for(Annotation a: annotations){
//            if(a.annotationType().getCanonicalName().equals(de.saxsys.mvvmfx.ScopeProvider.class.getCanonicalName())){
//                System.out.println("    ScopeProvider found!");
//                isScopeProviderValid = true;
//                scopeProviderStack.push(viewModelStack.peek());
//            }
//        }
//
//        for(Field f : vm.getClass().getDeclaredFields()){
//            if(f.isAnnotationPresent(de.saxsys.mvvmfx.InjectScope.class) && !isScopeProviderValid){
//                    System.out.println("    SCOPE IS NOT VALID on " + viewModelStack.peek() + "!");
//            }
//        }
    }

    after(): executionNewView(){
        System.out.println("pushing: " + thisJoinPoint.getSignature().getDeclaringType().getCanonicalName());
        viewModelStack.push(thisJoinPoint.getSignature().getDeclaringType().getCanonicalName());
    }

    after(javafx.fxml.Initializable initializable): execution(* initialize(..)) && this(initializable){
        if (!scopeProviderStack.isEmpty()) {
            if (scopeProviderStack.peek().equals(viewModelStack.peek())) {
                System.out.println("    SCOPEPROVIDER ENDED " + scopeProviderStack.peek());
                scopeProviderStack.pop();
                isScopeProviderValid = false;
            }
        }
        System.out.println("poping " + viewModelStack.pop());
    }

}
