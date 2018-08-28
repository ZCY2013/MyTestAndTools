package JMX.CommonModeler;

public class HelloModel {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("hello world," + name);
    }

    public void printHello(String str) {
        System.out.println("hello " + str);
    }
}
