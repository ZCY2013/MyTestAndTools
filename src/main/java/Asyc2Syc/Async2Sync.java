package Asyc2Syc;

import scala.reflect.api.Trees;

import java.util.concurrent.CountDownLatch;

public class Async2Sync  implements Runnable{
    private Integer num = null;

    private static CountDownLatch latch;

    public void setNum()
    {
        num =1 ;
    }
    public int getNum(){
        return num;
    }
    public void run(){
        if(Thread.currentThread().getName().equals("Thread-0")||Thread.currentThread().getName().equals("Thread-2")){
            try{
                System.out.println(Thread.currentThread().getName()+"start");
                Thread.sleep(5000);
//                System.out.println(Thread.currentThread().getName()+" num = " + this.getNum());
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            this.setNum();
            System.out.println(Thread.currentThread().getName()+" num = " + this.getNum());
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" num = " + this.getNum());
        }else if (Thread.currentThread().getName().equals("Thread-1")){
            try{
                System.out.println(Thread.currentThread().getName()+"start ");
                latch.await();
                System.out.println(Thread.currentThread().getName()+" num = " + this.getNum());
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" num = " + this.getNum());
        }
    }
    public static void main(String[] args){
        Async2Sync async2Sync = new Async2Sync();
        latch = new CountDownLatch(2);
        Thread t1 = new Thread(async2Sync);
        Thread t2 = new Thread(async2Sync);
        Thread t3 = new Thread(async2Sync);
        t3.start();
        t1.start();
        t2.start();

    }
}
