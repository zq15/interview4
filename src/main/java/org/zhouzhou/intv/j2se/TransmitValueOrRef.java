package org.zhouzhou.intv.j2se;

/**
 * 传值还是传引用
 */
public class TransmitValueOrRef {
    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }
    public static void main(String[] args){
        TransmitValueOrRef test = new TransmitValueOrRef();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age----"+age);//要求你打印出来的age到底是那个方法的变量？ 20 局部变量 改了没用

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName-----"+person.getPersonName()); // abc person 对象的值 复杂类型 传的是对象

        String str = "abc";
        test.changeValue3(str); //String 常量池
        System.out.println("String-----"+str);
    }
}