package fundamentals.Collection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.Constructor)
//@Target(ElementType.type) for class
@Target({ElementType.METHOD,ElementType.TYPE})
@interface CricketPlayer{
    String country() default "India";
    int age();

}// this specifies the compiler that annotation type has been created
@CricketPlayer(age = 22)
class priyanshu{
    private int inning;

public priyanshu(int inning) {
        this.inning = inning;
    }
    @CricketPlayer(age = 22)
    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }
}
public class Annotation2 {
    public static void main(String[] args) {
        Class<priyanshu> an = priyanshu.class;
        CricketPlayer info = an.getAnnotation(CricketPlayer.class);
        int age = info.age();
        String country = info.country();
        System.out.println(country + " " + age);

    }
}
