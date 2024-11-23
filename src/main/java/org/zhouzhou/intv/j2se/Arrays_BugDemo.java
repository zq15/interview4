package org.zhouzhou.intv.j2se;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList 转换数组的坑
 * 转换的数组是一个固定大小的list
 * 可以设置为 ArrayList 来避免这个问题
 * List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
 */
public class Arrays_BugDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5); // 是私有的一个 ArrayList 类，并不是 util 中的
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // 修改版本
        list.add(6); // Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list);
    }
}
