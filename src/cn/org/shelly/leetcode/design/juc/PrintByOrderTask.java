package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintByOrderTask {
    static char tmp = 'A';
    public static void main(String[] args){
        int n = 5;
        ReentrantLock r = new ReentrantLock();
        Condition a = r.newCondition();
        Condition b = r.newCondition();
        Condition c = r.newCondition();
       new Thread(
               () -> {
                   for(int i = 0;i<n;i++){
                       try {
                           r.lock();
                           while (tmp != 'A') {
                               a.await();
                           }
                               System.out.print("A");
                               tmp = 'B';
                               b.signal();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       } finally {
                           r.unlock();
                       }
                   }

               }
       ).start();
        new Thread(
                () ->{
                    for(int i = 0;i<n;i++){
                        try {
                            r.lock();
                            while (tmp != 'B') {
                                b.await();
                            }
                                System.out.print("B");
                                tmp = 'C';
                                c.signal();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } finally {
                            r.unlock();
                        }
                    }

                }
        ).start();
        new Thread(
                () ->{
                    for(int i = 0;i<n;i++){
                        r.lock();
                        try {
                            while (tmp != 'C') {
                                c.await();
                            }
                                System.out.print("C");
                                tmp = 'A';
                                a.signal();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } finally {
                            r.unlock();
                        }
                    }

                }
        ).start();
    }
}
