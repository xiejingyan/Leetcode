package leetcode;

import java.util.*;

public class _384_Shuffle {
    int[] ns1;
    List<Integer> ns2;
    public _384_Shuffle(int[] nums) {
        ns1 = Arrays.copyOf(nums, nums.length);
        ns2 = new ArrayList<>();
        for (int num : nums) {
            ns2.add(num);
        }
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ns1;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Collections.shuffle(ns2);
        int[] ns = new int[ns2.size()];
        for (int i = 0; i < ns.length; i++) {
            ns[i] = ns2.get(i);
        }
        return ns;
    }

//    暴力
    private int[] array;
    private int[] original;
    private Random rand = new Random();
    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }
//    public Solution(int[] nums) {
//        array = nums;
//        original = nums.clone();
//    }
    public int[] reset1() {
        array = original;
        original = original.clone();
        return array;
    }
    public int[] shuffle1() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }

//    Fisher-Yates 洗牌算法
//    private int[] array;
//    private int[] original;
//    Random rand = new Random();
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
//    public Solution(int[] nums) {
//        array = nums;
//        original = nums.clone();
//    }
    public int[] reset2() {
        array = original;
        original = original.clone();
        return original;
    }
    public int[] shuffle2() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
