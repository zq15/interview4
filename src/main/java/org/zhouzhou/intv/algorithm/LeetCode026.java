package org.zhouzhou.intv.algorithm;

/**
 * 删除有序数组中的重复项
 */
public class LeetCode026 {
    public static void main(String[] args) {
        /**
         * 输入：nums = [1,1,2]
         * 输出：2, nums = [1,2,_]
         * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
         */
        LeetCode026 leetCode026 = new LeetCode026();

        int[] nums = new int[]{1,1,2};
        int result = leetCode026.removeElement(nums, 1);
        System.out.println(result);
    }

    private int removeElement(int[] nums, int i) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow+1; // 数组长度为 slow+1
    }
}
