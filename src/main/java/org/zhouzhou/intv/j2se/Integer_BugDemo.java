package org.zhouzhou.intv.j2se;

public class Integer_BugDemo {
    public static void main(String[] args) {
        // 1. Integer 构造方法
//        Integer i = new Integer(1); // @Deprecated(since = "9", forRemoval = true)
        // he static factory valueOf(int) is generally a better choice, as it is likely to yield significantly better space and time performance.
//        Integer j = Integer.valueOf(1);
        // 2. Integer 数值比较
        /**
         * This method will always cache values in the range -128 to 127, inclusive, and may cache other values outside of this range.
         */
        Integer a = Integer.valueOf(600);
        Integer b = Integer.valueOf(600);
        int c = 600;
        System.out.println(a == b); // false
        System.out.println(a.equals(b));
        System.out.println(a == c);

        System.out.println("=================");

        Integer x = Integer.valueOf(99);
        Integer y = Integer.valueOf(99);
        System.out.println(x == y);
        System.out.println(x.equals(y));
        /**
         * false
         * true
         * true
         * =================
         * true
         * true
         */
    }
}
