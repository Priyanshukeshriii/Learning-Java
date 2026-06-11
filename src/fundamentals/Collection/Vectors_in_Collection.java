package fundamentals.Collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Vectors_in_Collection {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.addElement(849);
        v.add(39);
        Iterator itr = v.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        Enumeration em = v.elements();
        while (em.hasMoreElements()){
            System.out.println(em.nextElement());
        }
    }
}
