package fundamentals.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream_02 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("priyanshu");
        lst.add("priyanshu");
        lst.add("Rupam");
        lst.add("Ujjwal");


        System.out.println(lst);
        String str1 = lst.stream().sorted().collect(Collectors.joining(", "));
        System.out.println(str1);

        Set<String> set = lst.stream().collect(Collectors.toSet());
        System.out.println(set);
    }
}
