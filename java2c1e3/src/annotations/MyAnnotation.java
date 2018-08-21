package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /*
     * Trebuie sa dau o valoare proprietatii value(); 
     */
    public String value();
    /* 
     * default face proprietatea sa devina optionala
     *   Daca nu ii specific eu o valoare, o sa ia valoarea default 50
     */
    public int other() default 50;
    public Anotimp anotimp() default Anotimp.IARNA;
}
