package org.zhouzhou.intv.j2se;

import java.math.BigDecimal;

public class BigDecimal_BugDemo {
    public static void main(String[] args) {
//        double_demo();

        //m1();
         //m2();
//        m3();
        m4();
    }

    // 科学计数法
    public static void m4() {
        BigDecimal a1 = BigDecimal.valueOf(3124124312312312312.214312513251512321312);
        System.out.println(a1); // 3.1241243123123123E+18
        System.out.println(a1.toString()); // 3.1241243123123123E+18
        System.out.println(a1.toPlainString()); // 3124124312312312300 不使用科学计数法

        System.out.println();

        BigDecimal a2 = new BigDecimal("3124124312312312312.214312513251512321312"); // 用 String 构造，不会失真
        System.out.println(a2); // 3124124312312312312.214312513251512321312
        System.out.println(a2.toString()); // 3124124312312312312.214312513251512321312
        System.out.println(a2.toPlainString()); // 3124124312312312312.214312513251512321312
    }

    // 除数四舍五入的案例
    private static void m3() {
        BigDecimal a1 = new BigDecimal("2.0");
        BigDecimal a2 = new BigDecimal("3.0");

//        System.out.println(a1.divide(a2)); // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.

        // 小数点保留两位 四舍五入
        System.out.println(a1.divide(a2, 2, BigDecimal.ROUND_HALF_UP));
    }

    // 科学计数法比较
    private static void m2() {
        BigDecimal a1 = new BigDecimal("0.1");
        BigDecimal a2 = new BigDecimal("0.10");
        /**
         * API Note:
         * One example that shows how 2.0 and 2.00 are not substitutable for each other under
         * some arithmetic operations are the two expressions: new BigDecimal("2.0" )
         * .divide(BigDecimal. valueOf(3), HALF_UP) which evaluates to 0.7 and new BigDecimal("2.00")
         * .divide(BigDecimal. valueOf(3), HALF_UP) which evaluates to 0.67.
         */
        System.out.println(a1.equals(a2)); // false
        System.out.println(a1.compareTo(a2)); // 0
    }

    // 构造方法
    private static void m1() {
        // 构造方法相关: 禁止使用BigDecimal构造方法将 double 转换为 BigDecimal
        /**
         * The results of this constructor can be somewhat unpredictable. One might assume that writing new
         * BigDecimal(0.1) in Java creates a BigDecimal which is exactly equal to 0.1 (an unscaled
         * value of 1, with a scale of 1), but it is actually equal to 0.1000000000000000055511151231257827021181583404541015625.
         * This is because 0.1 cannot be represented exactly as a double (or, for that matter, as a
         * binary fraction of any finite length). Thus, the value that is being passed in to the constructor is not
         * exactly equal to 0.1, appearances notwithstanding.
         */
        /*
        BigDecimal a1 = new BigDecimal(0.03);
        BigDecimal a2 = new BigDecimal(0.02);
        System.out.println(a1); // 0.03000000000000000020816681711721685132943093776702880859375
        System.out.println(a1.subtract(a2));
        */
        // 优先推荐入参为 String 的构造方法
//        BigDecimal a1 = new BigDecimal("0.03");
//        BigDecimal a2 = new BigDecimal("0.02");
//        System.out.println(a1);
//        System.out.println(a1.subtract(a2));

        // 使用 valueOf
        BigDecimal a3 = BigDecimal.valueOf(0.03);
        BigDecimal a4 = BigDecimal.valueOf(0.02);
        System.out.println(a3);
        System.out.println(a3.subtract(a4));

    }

    // double 相减会先转换成二进制数
    private static void double_demo() {
        double a = 0.03;
        double b = 0.02;
        System.out.println(a - b); // 0.009999999999999998
    }
}
