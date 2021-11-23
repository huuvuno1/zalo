package javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(21);
        list.add(13);
        list.add(144);
        list.add(10);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
