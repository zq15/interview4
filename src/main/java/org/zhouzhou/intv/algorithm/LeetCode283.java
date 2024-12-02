package org.zhouzhou.intv.algorithm;

import java.util.Arrays;

/**
 * 移动 0 到末尾
 */
public class LeetCode283 {
    public static void main(String[] args) {
        /**
         * 输入: nums = [0,1,0,3,12]
         * 输出: [1,3,12,0,0]
         */
        LeetCode283 leetCode283 = new LeetCode283();
        int[] nums = new int[]{1};
        leetCode283.moveZeroes(nums);
        // 打印数组
        System.out.println(Arrays.toString(nums));
    }

    private void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
    }
}
