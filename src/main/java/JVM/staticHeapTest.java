package JVM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class staticHeapTest  {
    static{
        String str = "12345678999654123";
        Set<String> set = new HashSet<String>();
        System.out.println("static start");

        for(int i = 0; i < 10; i++){
            set.add(set + String.valueOf(i));
            if(i % 1  == 0 ){
                try{
                    Thread.sleep(1000);
                }catch (Exception e )
                {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args)throws Exception{
        System.out.println("main function start!");
        Thread.sleep(20000);
        List<String> strList = new ArrayList<String>(100);
        System.out.println("strList initial completed!");
        Thread.sleep(10000);

    }
}
