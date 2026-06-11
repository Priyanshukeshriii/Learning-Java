package fundamentals.Collection;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

public class Need_OF_Iterators {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(283);

        a.add(939);
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//            a.add(1);
//        }
        try{
            Iterator itr = a.iterator();
            while (itr.hasNext()) { // throws an ConcurrentModificationException
                System.out.println(itr.next());
                a.add(129);
            }
        }catch (ConcurrentModificationException e){
            System.out.println("Error");
        }
        try{
            ListIterator litr = a.listIterator();
            while (litr.hasNext()) {  // throws an ConcurrentModificationException
                System.out.println(litr.next());
                a.add(99);
            }
        }catch (ConcurrentModificationException e){
            System.out.println("Error");
        }

        ListIterator litr_Revese = a.listIterator(a.size());
        while (litr_Revese.hasPrevious()){
            System.out.println(litr_Revese.previous());
        }
    }
}
