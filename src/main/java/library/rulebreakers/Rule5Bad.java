package library.rulebreakers;

import library.annotations.C;
import library.annotations.X;
import library.annotations.Y;
import library.annotations.Z;

/**
 * Created by gerardo.balderas on 20.04.2016.
 */

@C
public class Rule5Bad {

    @X
    @Y
    public static void sayHello(){
        System.out.println("Hello");
    }

    @X
    public static void sayHello2(){
        System.out.println("Hello");
    }

    @Y
    public static void sayHello3(){
        System.out.println("Hello");
    }

    @Z
    public static void sayHello4(){
        System.out.println("Hello");
    }

    @X
    @Z
    public static void sayHello5(){
        System.out.println("Hello");
    }
}
