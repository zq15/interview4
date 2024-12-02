package org.zhouzhou.intv.algorithm;

import com.alibaba.druid.sql.visitor.functions.Char;

public class LeetCode344 {
    public static void main(String[] args) {
        LeetCode344 leetCode344 = new LeetCode344();

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        leetCode344.reverseString(s);

        System.out.println(s);
    }

    private void reverseString(char[] s) {
        // 左右指针相向而行
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            // 1. 交换
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            // 2. 移动指针
            left++;
            right--;
        }
    }
}
