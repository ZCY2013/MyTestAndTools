package Basic;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println(size);
        System.out.println(size.getAbbreviation());
    }
}

enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
    private String abbreviation;
    private Size(String abbreviation){ this.abbreviation = abbreviation;}
    public String getAbbreviation(){return abbreviation;}
}
