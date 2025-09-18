package com.Collection.Arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMethod {
        public static void main(String[] args) {
            ArrayList list = new ArrayList();
            list.add("Hello");
            list.add("World");
            list.add(null);
            list.add(true);
            list.add(45.55f);
            list.add(45.55f);
            list.add(100);
            System.out.println(list);

            int size=list.size();
            System.out.println("Size of the list: "+size);

            //get
            Object element=list.get(2);
            System.out.println("Element at index 2: "+element);

            Boolean status=(Boolean)list.get(3);
            System.out.println("Element at index 3: "+status);
            //instanceof operator checks relation between object and derived class





            //set, remove, add(index, element), addFirst, addLast
            list.set(2, "Java"); //replaces element at index 2 with "Java"
            System.out.println("After set: "+list);
            list.remove(1); //removes element at index 1

            list.add(1, "New World"); //adds "New World" at index 1
            list.addFirst("First Element"); //adds "First Element" at the beginning
            list.addLast("Last Element"); //adds "Last Element" at the end
            System.out.println("After add, addFirst, addLast: "+list);


            ArrayList list2 = new ArrayList();
            list2.add("Another");
            list2.add("List");
            System.out.println("List2: "+list2);
            list.addAll(list2); //adds all elements of list2 to list
            System.out.println("After addAll: "+list);

            System.out.println(list.indexOf("Java")); //true
            System.out.println(list.indexOf("Python")); //false
            System.out.println(list.lastIndexOf(45.55f)); //last occurrence of 45.55f

            ArrayList l= new ArrayList<>();
            l.add(1);
            l.add(11);
            l.add(111);
            l.add(11122111);

            //Iterator
            Iterator iter=l.iterator();
            while(iter.hasNext()){  //checks that there is element is present or not
                System.out.println(iter.next());
                //iter.remove(2);
                //l.add(22222);
            }
            // you cannot add or delete while element while itterating


            ArrayList<Integer> list1  = new ArrayList<>();
            list1.add(12);
            list1.add(121);
            list1.add(135);
            list1.add(12);
            list1.add(13);
            list1.add(1);
            ArrayList<Integer> list3 = new ArrayList<>();
            list3.add(12);
            list3.add(121);
            list3.add(135);
            list3.add(12);
            list3.add(13);
            list3.add(1);
            list3.add(3445);

            System.out.println(list1);
            list1.containsAll(list3);
            System.out.println(list1);
            list1.retainAll(list3);
            System.out.println(list1.retainAll(list3));
            list.removeAll(list3);
            System.out.println(list1.removeAll(list3));
        }


}

