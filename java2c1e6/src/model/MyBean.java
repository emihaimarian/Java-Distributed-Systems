package model;

import annotations.Apeleaza;

public class MyBean {

    @Apeleaza(ordine = 3)
    public void m1(){
        System.out.println("m1");
    }
    
    @Apeleaza(ordine = 2)
    public void m2(){
        System.out.println("m2");
    }
    
    @Apeleaza(ordine = 3)
    public void m3(){
        System.out.println("m3");
    }
    
    public void m4(){
        System.out.println("m4");
    }
    
    public void m5(){
        System.out.println("m5");
    }
        
}