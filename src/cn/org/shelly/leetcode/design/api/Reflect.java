package cn.org.shelly.leetcode.design.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    private int a = 1;
    private long b = 2;
    Reflect() {
        System.out.println("无参构造");
    }
    Reflect(int a) {
        this.a = a;
        System.out.println("有参构造a");
    }
    Reflect(long b) {
        System.out.println("有参构造");
    }
    public void print() {
        System.out.println("无参方法");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Reflect> reflectClass = Reflect.class;
        Field[] declaredFields = reflectClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        Reflect reflect = reflectClass.getDeclaredConstructor(int.class).newInstance(3);
        System.out.println(reflect.a);
        Field a1 = reflectClass.getDeclaredField("a");
        a1.setAccessible(true);
        System.out.println(a1.getInt(reflect));
        Method print = reflectClass.getDeclaredMethod("print");
        print.invoke(reflect);
    }
}
