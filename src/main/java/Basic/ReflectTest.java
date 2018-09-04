package Basic;

import JMX.StanderdMBean.Hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //array class  get special name
        System.out.println(Double[].class.getName()); // [Ljava.lang.Double;

        System.out.println(Hello[].class.getName());//[LJMX.StanderdMBean.Hello;

        System.out.println(int[].class.getName());//[I

        Class.forName("java.lang.String");
        new Reflect().say(ReflectTest.class); //callback method by reflect
    }

    public void sayhi() throws ClassNotFoundException {
        System.out.println("hi " + Class.forName("Basic.ReflectTest").getName());
    }
}
class Reflect{
    public void say(Class clazz) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("hi " + this.getClass().getName());
        Method  method = clazz.getMethod("sayhi");
//        method.invoke(Class.forName(clazz.getName()));  //error : object is not an instance of declaring class
        method.invoke(clazz.newInstance());
    }
}