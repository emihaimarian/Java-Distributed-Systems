package main;

import annotations.Aleator;
import java.lang.reflect.Field;
import java.util.Random;
import model.NumarComplex;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Random random = new Random();
        NumarComplex numarComplex = new NumarComplex();
        
        Class numarComplexClass = Class.forName("model.NumarComplex");
        Field [] allFields = numarComplexClass.getDeclaredFields();
        
        for (Field field : allFields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(Aleator.class)){
                Aleator aleator = field.getDeclaredAnnotation(Aleator.class);
                field.setInt(numarComplex, random.nextInt(aleator.max()));
            }
        }
        System.out.println(numarComplex);
    }
    
}
