package Basic.FinallyAndReturn;

public class FunctionTryCatchTest {
    public static void main(String[] args) {
        int result = test();
        System.out.println("value result :" + result);

        Person person = new FunctionTryCatchTest().testPerson();
        System.out.println("Class Person age: " + person.age);

    }

    public static int test(){
        int t =0;
        try{
            return t;
        }finally{
            t++;
            return t;
        }
    }

    public  Person testPerson() {
        Person t = new Person();
        t.age = 0;
        try {
            return t;
        } finally {
            t.age++;
            return t;
        }
    }
    class Person{
        int age;
    }
}
