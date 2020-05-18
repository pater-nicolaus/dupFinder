import java.util.*;
public class Iterator {
    public static void main(String args[]) {
        Iterator itr = list.iterator();

        while(itr.hasNext()) {

            Object element = itr.next();

            System.out.print(element + " ");

        }
        System.out.println();
    }
}

