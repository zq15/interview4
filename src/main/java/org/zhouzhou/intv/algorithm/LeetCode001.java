package org.zhouzhou.intv.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LeetCode001 {

    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            Integer partnerNum = target - nums[i];
            if (map.containsKey(partnerNum)) {
                return new int[] {map.get(partnerNum), i};
            }
            // map结构: 数组值 -> 数组下标
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        LeetCode001 test = new LeetCode001();

        int[] nums = new int[]{2,7,11,15};
        int target = 9;

        int[] ints = test.twoSum2(nums, target);

        for (int element : ints) {
            System.out.println(element);
        }
    }


}
