package Basic;

public class ModifyWrapper {
    private static final int d = 0;

    /**
     * It isn't add variable x ,value in class Integer is final-type.
     */
    public static void add(Integer x)
    {
        x++;
    }

    public static void main(String[] args) {
        Integer x = 1;
        ModifyWrapper.add(x);
        System.out.println(x);
    }
}
