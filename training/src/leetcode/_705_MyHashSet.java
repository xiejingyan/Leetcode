package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _705_MyHashSet {
    List<List<Integer>> hashSet;
    /** Initialize your data structure here. */
    public _705_MyHashSet() {
        hashSet = new ArrayList<>();
        for (int i = 0; i < 997; i++) {
            List<Integer> hashKey = new ArrayList<>();
            hashSet.add(hashKey);
        }
    }

    public void add(int key) {
        int hKey = key % 997;
        if (!hashSet.get(hKey).contains(key)) {
            hashSet.get(hKey).add(key);
        }
    }

    public void remove(int key) {
        int hKey = key % 997;
        if (hashSet.get(hKey).contains(key)) {
            for (int i = 0; i < hashSet.get(hKey).size(); i++) {
                if (hashSet.get(hKey).get(i) == key) {
                    hashSet.get(hKey).remove(i);
                    break;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hKey = key % 997;
        return hashSet.get(hKey).contains(key);
    }

//    链地址法
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
//    public MyHashSet() {
//        data = new LinkedList[BASE];
//        for (int i = 0; i < BASE; ++i) {
//            data[i] = new LinkedList<Integer>();
//        }
//    }
    public void add1(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }
    public void remove1(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }
    /** Returns true if this set contains the specified element */
    public boolean contains1(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }
    private static int hash(int key) {
        return key % BASE;
    }
}

/*
  Your MyHashSet object will be instantiated and called as such:
  MyHashSet obj = new MyHashSet();
  obj.add(key);
  obj.remove(key);
  boolean param_3 = obj.contains(key);
 */
