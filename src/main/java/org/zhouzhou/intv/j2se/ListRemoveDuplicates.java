package org.zhouzhou.intv.j2se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 手写数组去重
 */
public class ListRemoveDuplicates {
    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();
//        m4();
        m5();
    }

    /**
     * for 循环遍历判断是否含有，没有就新增到 newList 里面
     */
    private static void m1(){
        List<Integer> initList = Arrays.asList(70, 70, -1, 5, 3, 3, 4, 4, 4, 4, 99);
        List<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < srcList.size(); i++) {
            Integer tmpValue = srcList.get(i);
            if (!newList.contains(tmpValue)) {
                newList.add(tmpValue);
            }
        }
        System.out.println(newList);
    }

    /**
     * HashSet或者LinkedHashSet去重复
     */
    private static void m2(){
        List<Integer> initList = Arrays.asList(70, 70, -1, 5, 3, 3, 4, 4, 4, 4, 99);
        List<Integer> newList = new ArrayList<>(new HashSet<>(initList));
        newList.forEach(s -> System.out.print(s+" "));

        System.out.println("LinkedHashSet 保持顺序");
        List<Integer> newList1 = new ArrayList<>(new LinkedHashSet<>(initList));
        newList1.forEach(s -> System.out.print(s+" "));

    }

    /**
     * Stream 流式计算
     */
    private static void m3() {
        List<Integer> initList = Arrays.asList(70, 70, -1, 5, 3, 3, 4, 4, 4, 4, 99);
        List<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();
        newList = srcList.stream().distinct().collect(Collectors.toList());
        newList.forEach(s -> System.out.print(s+" "));
    }

    /**
     * 双 for 循环对比，通过下标获得值，外层循环和内层循环对比，值相同去重复
     */
    private static void m4() {
        List<Integer> initList = Arrays.asList(70, 70, -1, 5, 3, 3, 4, 4, 4, 4, 99);
        List<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);

        for (Integer ele : srcList) {
            if (newList.indexOf(ele) != newList.lastIndexOf(ele)) {
                newList.remove(ele);
            }
        }

        newList.forEach(s -> System.out.print(s+" "));
    }
    /**
     * 循环坐标去除重复，类似双指针，按照值找到下标，不同代表有重复需要删除
     */
    private static void m5() {
        List<Integer> initList = Arrays.asList(70, 70, -1, 5, 3, 3, 4, 4, 4, 4, 99);
        List<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);

        for (int i = 0;i < newList.size()-1; i++) {
            for (int j = 0; j < newList.size()-1; j++) {
                if (newList.get(j) == newList.get(j+1)) {
                    newList.remove(j + 1);
                }
            }
        }

        newList.forEach(s -> System.out.print(s+" "));
    }
}
