package com.sagar;

import java.util.HashMap;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        HashMap h = new HashMap();

        h.put(1, "sagar");
        h.put(2, null);
        h.put(4, 3);
        h.put(5, "vidhya");

        Set<Integer> keys = h.keySet();

        for (Integer key: keys){
            System.out.println(h.get(key));
        }



        System.out.println(h);
    }
}
