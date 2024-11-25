package org.zhouzhou.intv.idea;

import java.util.ArrayList;
import java.util.List;

public class ArrayListResizeDebug {
    public static void main(String[] args)
    {
        //jdk17版默认初始值是10，请问第2次扩容是多少？
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 17; i++)
        {
            list.add(i);
        }


        list.forEach(r  -> System.out.print(r +" "));
    }
}
