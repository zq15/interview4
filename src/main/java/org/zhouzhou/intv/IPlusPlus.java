package org.zhouzhou.intv;

/**
 * ++i 是前置递增，会先递增然后打印出来
 * i++ 是后置递增，会先打印出来然后递增
 */
public class IPlusPlus {
    public static void main(String[] args) {
        int i = 1;

        System.out.println("i: " + i);
        System.out.println("++i: " + ++i);
        System.out.println("i++: " + i++);
        System.out.println("i: " + i);
        System.out.println("--i: " + --i);
        System.out.println("i--: " + i--);
        System.out.println("i: " + i);
        /**
         * 1
         * 2
         * 2
         * 3
         * 2
         * 2
         * 1
         */
    }
}