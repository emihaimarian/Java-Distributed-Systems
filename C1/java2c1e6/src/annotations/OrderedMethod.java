package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderedMethod implements Comparable<OrderedMethod> {

    public final int i;
    private final  Method method;

    public OrderedMethod(int i, Method method) {
        this.i = i;
        this.method = method;
    }
    
    public void invoke(Object object){
        try {
            method.invoke(object);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OrderedMethod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(OrderedMethod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(OrderedMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public int compareTo(OrderedMethod object) {
        return this.i - object.i;
    }
    
}
