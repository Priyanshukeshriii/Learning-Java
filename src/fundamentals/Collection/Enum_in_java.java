package fundamentals.Collection;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Iterator;

enum Week{
    MON, TUE, WED, THU, FRI, SAT, SUN;
        }

public class Enum_in_java {
    public static void main(String[] args) {
        Week week = Week.MON;
        System.out.println(week);
        String name = Week.FRI.name();
        System.out.println(name);
        int index = Week.SAT.ordinal();
        System.out.println(index);
        Week[] WeekArray = Week.values();
        Iterator itr = Arrays.stream(WeekArray).iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
