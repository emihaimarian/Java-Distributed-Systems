package main;

import annotations.Anotimp;
import annotations.MyAnnotation;

public class Main {
    
    @MyAnnotation(value="abc", other = 10, anotimp = Anotimp.PRIMAVARA)
    int x;
    
    /*
     * Daca este singura proprietate pe adnotare
        pot folosi @MyAnnotation("abc")
     */
    @MyAnnotation("abc")
    public Main(){}
    
    public void method1(){}

    public static void main(String[] args) {   
    }
}
