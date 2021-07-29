package com.eva.hashmap;

public class Main {
    public static void main(String[] args) {

        HashMap<Long, Integer> map = new HashMap<>();

        map.put(9223372036854775805L, 1);
        map.put(-9223372036854775807L, -1);
        map.put(-9223372036854775808L, -2);
        map.put(10000000000L, 10);
        map.put(20000000000L, 20);

        // matched for collision
        map.put(40000000L, 4);

        System.out.println(map);

        System.out.println(map.get(9223372036854775807L));

        System.out.println(map.hasElement(922337203685477587L));
    }
}