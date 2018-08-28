package JMX.StanderdMBean;
public class Hello{
//public class Hello implements HelloMBean {
    private String name;

//    @Override
    public String getName(){
        return name;
    }

//    @Override
    public void setName(String name) {
        this.name = name;
    }

//    @Override
    public void printHello() {
        System.out.println("hello world," + name);
    }

//    @Override
    public void printHello(String str) {
        System.out.println("hello " + str);
    }
}
