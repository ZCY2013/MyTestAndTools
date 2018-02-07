package GCTest;

/**
 * -Xms60m -Xmx60m -Xmn20m -XX:NewRatio=2  -XX:SurvivorRatio=8 -XX:PermSize=30m -XX:MaxPermSize=30m -XX:+PrintGCDetails
 * 引用对象设置为Null时会释放申请的对空间，System.gc首先会引起MinorGc后进行MajorGC，OldGen有8k内容常驻内存
 * 通常String对象会比其字符串占用内存多10k左右空间占用，包含String对象len属性等
 * -XX：PermSize  -XX:MaxPermSize等在jdk1.8中被弃用
 * 年轻代   eden：survivor1：survivor2=8:1:1  young：old = NewRatio
 */
public class GCApplication {
    public void doTest(){
        Integer M = new Integer(1024 * 1024 * 1); //单位, 兆(M)
        byte[] bytes = new byte[1 * M]; //申请 1M 大小的内存空间
        bytes = null; //断开引用链
        System.gc(); //通知 GC 收集垃圾
        System.out.println("ok");
        bytes = new byte[1 * M]; //重新申请 1M 大小的内存空间
        bytes = new byte[1 * M]; //再次申请 1M 大小的内存空间
        System.gc(); System.out.println();
    }
    public static void main(String[] args) {
        new GCApplication().doTest();
    }

}
