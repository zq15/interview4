package org.zhouzhou.intv.algorithm;

/**
 * 二分查找
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode704 leetCode704 = new LeetCode704();
        /**
         * 输入: nums = [-1,0,3,5,9,12], target = 9
         * 输出: 4
         * 解释: 9 出现在 nums 中并且下标为 4
         */
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = leetCode704.search(nums, target);
        System.out.println(result);
    }
}
