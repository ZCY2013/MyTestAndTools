package CLassloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * loadClass是定义在ClassLoad类中加载类的入口方法，此方法负责加载指定名字的类。如要改变类的加载顺序，则可覆盖此方法，如加载顺序相同，
 * 则可通过覆盖findClass来做特殊的处理，例如解密、固定路径寻找等，
 * 当通过整个寻找类的过程仍然未获取到Class对象时，则抛出ClassNotFoundException。
 */
public class MyCLassLoader extends ClassLoader{
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException
    {
//        System.out.println("class name is : "+name);
        byte[] bt = loadClassData(name);
//        System.out.println(defineClass(name,bt,0,bt.length));
        return defineClass(name,bt,0,bt.length);
    }

    private byte[] loadClassData(String className){
        System.out.println("getClass():"+getClass());
        System.out.println(getClass().getClassLoader());
        System.out.println(getClass().getClassLoader().getResourceAsStream("CLassloader/RichMan.class"));
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".","/")+".class");
        ByteArrayOutputStream bytest = new ByteArrayOutputStream();
        int len = 0;
        try{
            while((len = is.read())!= -1)
            {
                bytest.write(len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return bytest.toByteArray();

    }

    /**
     * ClassLoader的实现方法为先从已经加载的类中寻找，如没有则继续从父ClassLoader中寻找，如仍然没找到，则从BootstrapClassLoader中寻找，
     * 最后再调用findClass方法来寻找，在该测试方法中，构造函数会默认设置AppClassLoader为Parent，执行该方法会发现RichMan类是通过委托
     * AppClassLoader加载的，因此可以访问到RichMan
     * @throws Exception
     */
    public void test2() throws Exception{
        MyCLassLoader loader = new MyCLassLoader();
//        System.out.println("find in loaded class: "+loader.findLoadedClass("CLassloader.RichMan"));
//        System.out.println("loader parent is : "+loader.getParent());
        Class<?> c = loader.loadClass("CLassloader.RichMan");
//        System.out.println("load by: " + c.getClassLoader()+" c is : "+c);
        Person p = (Person) c.newInstance();
        p.say();
        RichMan man = (RichMan) c.newInstance();
        man.say();
    }

    /**
     * 子加载器的命名空间包含了parent加载的所有类,反过来则不成立
     * 下面代码中test类是通过AppClassLoader加载的，所以看不见由MyClassLoader加载的RichMan类，但是Peron接口是可以访问的所以第一
     * 步不会出错
     * @throws Exception
     */
    public void test3() throws Exception{
        MyCLassLoader loader = new MyCLassLoader();
//        System.out.println("find in loaded class: "+loader.findLoadedClass("CLassloader.RichMan"));
//        System.out.println("loader parent is : "+loader.getParent());
        Class<?> c = loader.findClass("CLassloader.RichMan");
//        System.out.println("find in loaded class: "+loader.findLoadedClass("CLassloader.RichMan"));
//        System.out.println("Loaded by : "+c.getClassLoader()+" c is : " +c);
        Person p = (Person) c.newInstance();
        p.say();
        RichMan man = (RichMan) c.newInstance();
        man.say();
    }

    /**(需要对整个jvm机制具体学习后在做修改）
     * 同一个类可以由不同的加载器加载多次但不能由同一个加载器加载两次
     * test2 test3 的主要区别在于loadclass是通过获取当前类的parent来加载类，而findclass是通过自定义的，通过名字来加载类，不能访问
     *MyClassLoader加载的RichMan区域，MyClassLoader ∈ AppClassLoader
     * @param args
     */
    public static void main(String[] args)
    {
        try{
            MyCLassLoader loader = new MyCLassLoader();
//            loader.test2();
            loader.test3();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
