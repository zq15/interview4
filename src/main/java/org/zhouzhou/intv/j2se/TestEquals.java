package org.zhouzhou.intv.j2se;

import java.util.HashSet;
import java.util.Set;

/**
 * == 与 equals 的区别
 * 1. == 基本类型比较值，引用类型比较内存地址
 * 2. equals 通常用于比较引用类型，如果引用类型没有重写 equals 方法，则仍然调用 Object 中的 equals 方法，
 *      Object 中的 equals 使用的还是 ==
 */
public class TestEquals {

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Set<String> set01 = new HashSet<>();
        set01.add(s1);
        set01.add(s2);
        System.out.println(set01.size());
        System.out.println(s1.hashCode() + "\t" + s2.hashCode()); // 96354	96354
        System.out.println("===============");
        /**
         * false
         * true
         * 1
         */

        Person p1 = new Person("abc");
        Person p2 = new Person("abc");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        Set set02 = new HashSet<>();
        set02.add(p1);
        set02.add(p2);
        System.out.println(set02.size());
        System.out.println(p1.hashCode() + "\t" + p2.hashCode()); // 1078694789	1831932724
        /**
         * false
         * false
         * 2
         */
    }
}
