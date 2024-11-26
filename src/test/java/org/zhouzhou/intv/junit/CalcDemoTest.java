package org.zhouzhou.intv.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcDemoTest {

    @Test
    void add() {
        CalcDemo calcDemo = new CalcDemo();
//        System.out.println(calcDemo.add(2, 2));
        int add = calcDemo.add(2, 2);
        assertEquals(4, add);
    }

    @Test
    void sub() {
    }
}