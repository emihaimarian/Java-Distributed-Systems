package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import model.Punct;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         * Creeaza o instanta a tipului acelei clase
         * Daca intalnim OutOfMemory cu mesajul PermGeneration se intampla cand s-a umplut PermGen
         * deobicei daca exista un bug intr-o aplicatie de tip container care creeaza instante de tipul de mai jos 
         * necontrolat.
         * new Instance nu functioneaza cand constructorul este privat.
         */
        Class punctClass = Class.forName("model.Punct");
        Constructor constructorPunct =  punctClass.getDeclaredConstructor();
        /*
         * II fac provizoriu accesibil
         */
        constructorPunct.setAccessible(true);
        Punct punct = (Punct) constructorPunct.newInstance();
        
        System.out.println(punct);
        
        /*
         * Dam valori lui x si y
         */
        Field fieldX = punctClass.getDeclaredField("x");
        fieldX.setAccessible(true);
        fieldX.setInt(punct, 10);
        
        Field fieldY = punctClass.getDeclaredField("y");
        fieldY.setAccessible(true);
        fieldY.setInt(punct, 20);
        
        Method method1 = punctClass.getDeclaredMethod("afisareCoordonate");
        method1.setAccessible(true);
        method1.invoke(punct);
    }
}
