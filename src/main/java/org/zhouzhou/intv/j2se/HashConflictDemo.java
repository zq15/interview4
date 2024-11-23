package org.zhouzhou.intv.j2se;

import java.util.HashSet;

/**
 * 编写一个hash冲突的案例
 */
public class HashConflictDemo {
    static class Book {
        int id;
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 100 * 10000; i++) {
            int hashcode = new Book().hashCode();
            if (!hashSet.contains(hashcode)) {
                hashSet.add(hashcode);
            } else {
                System.out.println("发生了 hash 冲突，hashcode：" + hashcode);
            }
        }
        System.out.println("hashSet.size() = " + hashSet.size());
    }
}
