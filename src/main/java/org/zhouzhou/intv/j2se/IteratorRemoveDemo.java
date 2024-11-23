package org.zhouzhou.intv.j2se;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 遍历集合时删除新增元素
 */
public class IteratorRemoveDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            Integer value = iterator.next();

            if (value == 12) {
//                list.remove(value); // Exception in thread "main" java.util.ConcurrentModificationException
                /**
                 * final void checkForComodification() {
                 *     if (modCount != expectedModCount)
                 *         throw new ConcurrentModificationException();
                 * }
                 */
                iterator.remove();
            }
        }
        list.forEach(v -> System.out.println(v));

    }
}
