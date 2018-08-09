package Basic;

public class BasicCompute {
    public static void main(String[] args) {
        System.out.println("normal");
        BasicCompute bean = new BasicCompute();
        bean.Compute();
    }
    public void Compute(){
        float aFloat = 0.6710339f;
        double aDouble = 0.041505534119847926666d;
//        double sum = aFloat + aDouble;
        double quotient = (aFloat + aDouble/aDouble);
        System.out.println("float:" + aFloat); //0.6710339
        System.out.println("double:" + aDouble); //0.04150553411984792
//        System.out.println("sum:" + sum); //0.7125394529774224
        System.out.println("quotient:" + quotient); //16.167336
    }

}
