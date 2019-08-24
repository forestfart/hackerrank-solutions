package oracle.ocp.collections;

import java.util.TreeMap;

public class TreeMapSubMap {

    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0,1);
        map.put(1,4);
        map.put(3,5);
        map.put(5,6);
        map.put(4,8);
        map.put(8,9);
        map.put(6,7);
        map.put(7,10);
        System.out.println(map);

        System.out.println("subMap: " + map.subMap(2, true, 3, true));
        System.out.println("headMap: " + map.headMap(4,false));
        System.out.println("tailMap: " + map.tailMap(5, true));
        System.out.println("headMap: " + map.headMap(7,true));
        System.out.println("tailMap: " + map.tailMap(7, true));

        System.out.println("subMap: " + map.subMap(2, false, 9, false));

        TreeMap<Key, Integer> kmap = new TreeMap<>();
        kmap.put(new Key(), 1);
        kmap.put(new Key(), 2);
        kmap.put(new Key(), 2);
        System.out.println(kmap.values());

    }

    static class Key implements Comparable<Key> {

        @Override
        public int compareTo(Key o) {
            return 0;
        }
    }

}
