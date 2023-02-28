package com.company;
import java.util.*;
public class Main {
    static Map<Integer, List> result = new HashMap<>();
    static Map<Integer, String> result1 = new HashMap<>();
    public static void main(String[] args) {
        final var arrays = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        for (int i = 1; i <= arrays.size(); i++)
            permK(arrays, 0, i);
        System.out.println("Result: ");
        final var lists = new ArrayList<List>(result.values());
        for (int i = 0; i < lists.size(); i++) {
           for (int j = i; j < lists.size(); j++) {

                   var l1 = lists.get(i);
                   var l2 = lists.get(j);
                   if(isCheck(l1, l2) && j >= arrays.size()) {
                       System.out.println(l1.toString()+", "+l2.toString());
                   }
                   if (i == lists.size()-1) {
                       System.out.println(l1);
                   }
           }
            if (i < arrays.size()) {
                System.out.println(lists.get(i));
            }
        }

    }
    static <E> void permK(List<E> p, int i, int k) {
        if (i == k) {
            final var s = new ArrayList<E>(p.subList(0, k));
            final var key = convertListToIntValue(s);
            result.put(key, s);
            return;
        }

        for (int j = i; j < p.size(); j++) {
            Collections.swap(p, i, j);
            permK(p, i + 1, k);
            Collections.swap(p, i, j);
        }
    }
    static <E> int convertListToIntValue(List<E> s) {
        int value = 0;
        for (int i = 0; i < s.size(); i++) {
            value += s.get(i).hashCode();
        }
        return value;
    }
    static <E> boolean isCheck(List<E> s1, List<E> s2) {
        for (E s : s1) {
            if (s2.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
