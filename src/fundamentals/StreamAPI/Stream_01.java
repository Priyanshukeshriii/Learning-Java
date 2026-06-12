package fundamentals.StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Stream_01 {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(10);
        lst.add(100);
        lst.add(1);
        lst.add(120);
        lst.add(110);
        System.out.println(lst);
//        Collections.sort(lst, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 < o2){
//                    return 1;
//                }
//                return -1;
//            }
//        });
//        System.out.println(lst);

        Stream<Integer> stream = lst.stream();
        Stream<Integer> stream1 = stream.sorted((Integer o1 ,Integer o2 ) -> {
            if(o1 < o2){
                return 1;
            }
            return -1;
        });

//        stream1.forEach(n-> System.out.println(n));

//        once stream is used it cannot be used again
//        Stream<Integer> stream2 = stream1.map(n-> n*2); //will throw IllegalStateException

//        but we can use two or more method at once using method channing
        Stream<Integer> stream2 = stream1.map(n->n*2).sorted();
        stream2.forEach(n-> System.out.println(n));
     }
}
