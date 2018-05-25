package JVM;

public class StringTest {
    public static void main(String[] args)
    {
        String abc = "123123";
        String prefixMsg = abc.length()>=2?(String)abc:"";
        System.out.print(prefixMsg);
//        String str0 = new String("a");
//        String str1 = str0.intern();
//        String str2 = "a";
//        String str3 = "a";
//        System.out.println(str1 == str0);//false
//        System.out.println(str2 == str0);//false
//        System.out.println(str2 == str1);//true
//        System.out.println(str3 == str2);//true
//        "a".equals(str2);//true
    }

}
