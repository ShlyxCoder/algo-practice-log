package cn.org.shelly.leetcode.design.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeCASTest {
    public static void main(String[] args){
        MyAtomic myAtomic = new MyAtomic(100);
        myAtomic.compareAndSet(100,101);
        System.out.println(myAtomic.get());
    }
}
class MyAtomic{
    private static final Unsafe unsafe;
    private static final long valueOffset;

    private volatile int value;
    static {
        Field f;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            valueOffset = unsafe.objectFieldOffset(MyAtomic.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public MyAtomic(int initialValue) {
        value = initialValue;
    }

    public int get() {
        return value;
    }

    public void set(int newValue) {
        value = newValue;
    }

    public boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }


}

