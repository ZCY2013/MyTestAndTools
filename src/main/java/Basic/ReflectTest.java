package Basic;

import JMX.StanderdMBean.Hello;

public class ReflectTest {
    public static void main(String[] args) {
        //array class  get special name
        System.out.println(Double[].class.getName()); // [Ljava.lang.Double;

        System.out.println(Hello[].class.getName());//[LJMX.StanderdMBean.Hello;

        System.out.println(int[].class.getName());//[I
    }
}
