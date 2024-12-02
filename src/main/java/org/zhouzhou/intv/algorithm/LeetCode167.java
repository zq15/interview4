package org.zhouzhou.intv.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LeetCode167 {

    private int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 因为题目中下标从1开始
            } else if (sum < target) {
                left++; // 增加左侧索引以尝试更大的数值
            } else {
                right--; // 减少右侧索引以尝试更小的数值
            }
        }
        return null; // 如果没有找到，则返回null
    }


    public static void main(String[] args)
    {
        LeetCode167 test = new LeetCode167();

        int[] numbers = new int[]{2,7,11,15};
        int target = 9;

        int[] ints = test.twoSum(numbers, target);

        for (int element : ints) {
            System.out.println(element);
        }
    }


}
