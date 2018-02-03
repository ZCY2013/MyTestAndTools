package Asyc2Syc;

public class BySync implements  Runnable{
    int num1 =10;
    int num2 = 20;
    int num3 = 10;

    public void synchronized_test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"start");
        synchronized (this){
            while(num1 > 0){
                        Thread.sleep(500);
                     System.out.println(Thread.currentThread().getName()+"num1:"+num1--);
            }
//        }
//        synchronized (this){
            while(num2 > 0){
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "num2:"+num2--);
            }
        }
        while (num3 > 0) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "num3:"+num3--);
        }
        System.out.println(Thread.currentThread().getName()+"end");

    }

    public void synchronized_test(String a){
        System.out.println(Thread.currentThread().getName()+"start");
        while(num1 > 0){
                System.out.println(Thread.currentThread().getName()+"num1:"+num1--);
            }

            while(num2 > 0){
                System.out.println(Thread.currentThread().getName() + "num2:"+num2--);
            }

        while (num3 > 0) {
            System.out.println(Thread.currentThread().getName() + "num3:"+num3--);
        }
        System.out.println(Thread.currentThread().getName()+"end");
    }
    public void run(){
        try {
            synchronized_test();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int i = 3;
        System.out.println(i--);
        BySync bySync = new BySync();
        Thread t1 = new Thread(bySync);
        Thread t2 = new Thread(bySync);
        t2.start();
        System.out.println("asd");
        t1.start();

    }
}
