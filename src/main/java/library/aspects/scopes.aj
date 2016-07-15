package library.aspects;

/**
 * Created by gerardo.balderas on 13.07.2016.
 */
public aspect scopes {

    Boolean isScopeProvider;

//    void around(): executionNewVM(){
//        System.out.println("before execution to new VM");
//        proceed();
//        System.out.println("after execution new VM");
//    }

    //VIEWMODELS
    pointcut initVM(): initialization(de.saxsys.mvvmfx.ViewModel+.new(..));
    pointcut preInitVM(): preinitialization(de.saxsys.mvvmfx.ViewModel+.new(..));
    pointcut staticInitVM(): staticinitialization(de.saxsys.mvvmfx.ViewModel+);
    pointcut executionNewVM(): execution(de.saxsys.mvvmfx.ViewModel+.new(..));
    pointcut withinVM(): within(de.saxsys.mvvmfx.ViewModel+);

    //VIEWS
    pointcut initView(): initialization(de.saxsys.mvvmfx.FxmlView+.new(..));
    pointcut preInitView(): preinitialization(de.saxsys.mvvmfx.FxmlView+.new(..));
    pointcut staticInitView(): staticinitialization(de.saxsys.mvvmfx.FxmlView+);
    pointcut executionNewView(): execution(de.saxsys.mvvmfx.FxmlView+.new(..));
    pointcut execInitView(): execution(* de.saxsys.mvvmfx.FxmlView+.initialize(..));
    pointcut withinView(): within(de.saxsys.mvvmfx.FxmlView+);

    declare parents : library.views..*View implements javafx.fxml.Initializable;

    //    after(): initView(){
//        System.out.println("after init " + thisJoinPoint.getSignature().toShortString());
//    }
//
//    before(): preInitView(){
//        System.out.println("before preinit " + thisJoinPoint.getSignature().toShortString());
//    }

    after(): executionNewView(){
        System.out.println("after View EXEC " + thisJoinPoint.getSignature().toShortString());
    }

//    void around(): staticInitView(){
//        System.out.println("before static init " + thisJoinPoint.getSignature().toShortString());
//        proceed();
//        System.out.println("after static init " + thisJoinPoint.getSignature().toShortString());
//    }

    void around(): execInitView(){
//        System.out.println("before exec " + thisJoinPoint.getSignature().toShortString());
        proceed();
        System.out.println("after EXEC " + thisJoinPoint.getSignature().toShortString());
    }



//    after() returning: executionNewVM(){
//        System.out.println("after returning exec "+ thisJoinPoint.getSignature().toShortString());
//    }
//
//    after(): initNewVM(){
//        System.out.println("hello its me: "+thisJoinPointStaticPart.getSignature().toShortString());
//    }


}
