package Basic.FinallyAndReturn;

/**
 * explain {return} and {finally} statement how to execute on the end of function
 * @author ZCY_2013
 */
public class FinallyAndReturnCompute {
    public static void main(String[] args) {
        System.out.println("noException");
        System.out.println("*******************************");
        System.out.println(noException());
        System.out.println("tryCatchReturn");
        System.out.println("*******************************");
        System.out.println(tryCatchReturn());
        System.out.println("tryCatchFinallyReturn");
        System.out.println("*******************************");
        System.out.println(tryCatchFinallyReturn());
        System.out.println("tryExCatchReturn");
        System.out.println("*******************************");
        System.out.println(tryExCatchReturn());
        System.out.println("tryExCatchExReturn");
        System.out.println("*******************************");
        System.out.println(tryExCatchExReturn());
    }
    /**
     * try-catch block has return statement,finally-block as well.
     * Bur actually return try-block-value
     * @return
     */
    public static int noException(){
        int i = 10;
        try{
            System.out.println("i in try block is : " + i);//10
            i--;//9
            return i--;//8
        }catch(Exception e){
            i--;
            System.out.println("i in catch-block from try block is : " + i );
            return i--;
        }finally {
            System.out.println("i in finally block from try-catch block is : " + i);//8
            return --i;//7 real return
        }
    }

    public static int tryCatchReturn(){
        int i = 10;
        try{
            System.out.println("i in try block is : " + i);
            return i--;
        }catch(Exception e){
            i--;
            System.out.println("i in catch block from try block is : " + i);
            --i;
            return i;
        }finally {
            System.out.println("i in finally from try or catch block is : " + i);
            i--;
            System.out.println("i in finally block is : " + i);
        }
    }

    /**
     * normal code block caused exception
     * catch-block has a return statement but real value is from finally block
     * @return
     */
    public static int tryCatchFinallyReturn(){
        int i=10;
        try{
            System.out.println("i in try block is："+i); //10
            i = i/0;
            return --i;
        }
        catch(Exception e){
            System.out.println("i in catch - form try block is："+i); //10
            --i; //9
            System.out.println("i in catch block is："+i); //9
            return --i; //8
        }
        finally{
            System.out.println("i in finally - from try or catch block is :"+i); //8
            --i; //7
            System.out.println("i in finally block is--"+i); //7
            return --i; //6  real
        }
    }
    public static int tryExCatchReturn(){
        int i=10;
        try{
            System.out.println("i in try block is："+i); //10
            i=i/0;
            return --i;
        }catch(Exception e){
            System.out.println("i in catch - form try block is："+i); //10
            return --i; //9 返回这个
        }finally{

            System.out.println("i in finally - from try or catch block is："+i); //9
            --i; //8
            System.out.println("i in finally block is："+i); //8
        }
    }

    public static int tryExCatchExReturn() {
        int i = 10;
        try {
            System.out.println("i in try block is：" + i); //10
            i = i / 0;
            return --i;
        } catch (Exception e) {
            System.out.println("i in catch - form try block is：" + i); //10
            int j = i / 0;
            return --i;
        } finally {

            System.out.println("i in finally - from try or catch block is：" + i); //10
            --i; //9
            --i; //8
            System.out.println("i in finally block is：" + i); //8
            return --i; //7 返回这个
        }
    }

}
