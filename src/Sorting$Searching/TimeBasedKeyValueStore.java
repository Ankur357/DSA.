package Sorting$Searching;

import java.util.*;

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) return "";

        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();

        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1)); // bar
        System.out.println(obj.get("foo", 3)); // bar

        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4)); // bar2
        System.out.println(obj.get("foo", 5)); // bar2

        obj.set("love", "high", 10);
        obj.set("love", "low", 20);

        System.out.println(obj.get("love", 5));  // ""
        System.out.println(obj.get("love", 10)); // high
        System.out.println(obj.get("love", 15)); // high
        System.out.println(obj.get("love", 20)); // low
    }
}

