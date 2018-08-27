package Basic;

import java.util.ArrayList;

public class ArrayMemory {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(100);
        list.set(0,1); //error ,there is no memory has been allocated

        Integer[] listint = new Integer[100];
        listint[0] = 2; //right
        System.out.println(listint.length); //100
    }
}
