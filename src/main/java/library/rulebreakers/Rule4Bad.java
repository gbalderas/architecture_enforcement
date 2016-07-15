package library.rulebreakers;

import library.annotations.B;
import library.annotations.X;
import library.annotations.Y;

/**
 * Created by gerardo.balderas on 20.04.2016.
 */
@B
public class Rule4Bad {

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
}
