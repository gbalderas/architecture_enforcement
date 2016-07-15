package library.rulebreakers;

import library.annotations.A;
import library.annotations.X;
import library.annotations.Y;

/**
 * Created by gerardo.balderas on 15.04.2016.
 */
@A
public class Rule3Ok {


    @X
    @Y
    public static void sayHello(){
        System.out.println("Hello");
    }
}
