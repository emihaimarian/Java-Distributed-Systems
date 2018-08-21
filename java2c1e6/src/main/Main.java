package main;

import annotations.Apeleaza;
import annotations.OrderedMethod;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.MyBean;

public class Main {
    public static void main(String[] args) throws Exception {
        List<OrderedMethod> methodToBeCalled = new ArrayList<>();
        MyBean myBean = new MyBean();
        
        Class myBeanClass = Class.forName("model.MyBean");
        Method [] methods = myBeanClass.getDeclaredMethods();
        
        for (Method method : methods){
            if (method.isAnnotationPresent(Apeleaza.class)){
                Apeleaza apeleaza = method.getDeclaredAnnotation(Apeleaza.class);
                methodToBeCalled.add(new OrderedMethod(apeleaza.ordine(), method));
            }
        }
        
        Collections.sort(methodToBeCalled);
        methodToBeCalled.forEach(method -> method.invoke(myBean));
    }    
}