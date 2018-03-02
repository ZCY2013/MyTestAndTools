public class StringTest {
    public static void main(String[] args)
    {
        String str0 = new String("a");
        String str1 = str0.intern();
        String str2 = "a";
        String str3 = "a";
        System.out.println(str1 == str0);//false
        System.out.println(str2 == str0);//false
        System.out.println(str2 == str1);//true
        System.out.println(str3 == str2);//true
        "a".equals(str2);//true
    }

}
