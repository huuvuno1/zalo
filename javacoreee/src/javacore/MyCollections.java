package javacore;

import java.util.List;

public class MyCollections {
    public static void sort(List<Integer> list, MyComparator comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Integer temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
