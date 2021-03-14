package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class _706_MyHashMap {
    Map<Integer, Integer>[] map;
    /** Initialize your data structure here. */
    public _706_MyHashMap() {
        map = new Map[769];
        for (int i = 0; i < 769; i++) {
            Map<Integer, Integer> m = new TreeMap<>();
            map[i] = m;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int mKey = mKey(key);
        map[mKey].put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int mKey = mKey(key);
        return map[mKey].getOrDefault(key, -1);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int mKey = mKey(key);
        map[mKey].remove(key);
    }

    public int mKey(int key) {
        return key % 769;
    }

//    链地址法
    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
//    public MyHashMap() {
//        data = new LinkedList[BASE];
//        for (int i = 0; i < BASE; ++i) {
//            data[i] = new LinkedList<Pair>();
//        }
//    }
    /** value will always be non-negative. */
    public void put1(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get1(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                return pair.value;
            }
        }
        return -1;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove1(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.key == key) {
                data[h].remove(pair);
                return;
            }
        }
    }
    private static int hash(int key) {
        return key % BASE;
    }

/*
  Your _706_MyHashMap object will be instantiated and called as such:
  _706_MyHashMap obj = new _706_MyHashMap();
  obj.put(key,value);
  int param_2 = obj.get(key);
  obj.remove(key);
 */
}
