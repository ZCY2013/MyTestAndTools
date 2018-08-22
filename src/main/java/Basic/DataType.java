package Basic;

public class DataType {
    public static void main(String[] arg) throws Exception {
//  public static void main(String\u005B\u005D args){        javac will compile it  \\uxxxx can be written directly without single quoteso
        String a = "\u0022+\u0022" + "dsa";
        System.out.println(a.length() + ":" + a);//0:[empty]
        char b = '\u0041';
        System.out.println(b);
        //"const" is a reserved key word

        System.out.println(a.join("/", "aaa", "bb", "cc", "dd"));//method join is irrelevant to the object that called it

        //codePoint && String length
        char coin = '\u6C49';
        System.out.println(coin);
        byte[] by = {(byte)0xE6,(byte)0xB1,(byte)0x89,(byte)0xE5,(byte)0xAD,(byte)0x97};
        byte[] by1 = {(byte)0x00006C49};
        System.out.println(new String(by,"utf-8"));
        System.out.println(new String(by1,"utf-32"));
//        String greeting = " is a registered mark";
//        int n = greeting.length(); // 5
//        int cpCount = greeting.codePointCount(0, n);
//        System.out.println(n + "  " + cpCount);
//        int index = greeting.offsetByCodePoints(0, 4);
//        int cp = greeting.codePointAt(index);w
//        System.out.println(index + "   " + cp);
    }
}
