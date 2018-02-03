package Asyc2Syc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSync implements  Runnable{
    int num1 = 10;
    int num2 = 20;
    int num3 = 10;
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void synchonized_test() {
        System.out.println(Thread.currentThread().getName() + "start");
        lock1.lock();
        try {
            while (num1 > 0) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "access num1:" + num1--);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
        lock2.lock();
        try {
            while (num2 > 0) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "access num2:" + num2--);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }
    public int NoLockTest(){
        System.out.println(Thread.currentThread().getName() + "start");
        while(num1 < 30) {
            System.out.println(Thread.currentThread().getName()+"num is :" + num1++);
        }
        System.out.println(Thread.currentThread().getName() + "end");
        return num1;
    }

    public void run() {
        synchonized_test();
//        NoLockTest();
    }

    public static void main(String[] args){
        LockSync ls = new LockSync();
        Thread t1 = new Thread(ls);
        Thread t2 = new Thread(ls);
        t1.start();
        t2.start();
    }
}
