package Basic;

public class DataType {
    public static void main(String[] arg){
//  public static void main(String\u005B\u005D args){        javac will compile it  \\uxxxx can be written directly without single quoteso
        String a  = "\u0022+\u0022";
        System.out.println(a.length() + ":" + a);//0:[empty]
        char b = '\u0041';
        System.out.println(b);
        //"const" is a reserved key word

    }
}
