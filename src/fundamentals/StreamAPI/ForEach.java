package fundamentals.StreamAPI;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ForEach {
    class alpha implements Consumer<Integer> {

        @Override
        public void accept(Integer integer) {
            System.out.println(integer);
        }
        alpha(){
            super();
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(28);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(208);
//        for (int num : arrayList){
//            System.out.println(num);
//        }

//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        };
//
//        ForEach forEach = new ForEach();
//        alpha a = forEach.new alpha();


        alpha a = new ForEach().new alpha();
        arrayList.forEach(a);

        System.out.println();
        arrayList.forEach((Integer n) -> System.out.println(n));

        System.out.println();
        arrayList.forEach((n) -> System.out.println(n));
    }
}
