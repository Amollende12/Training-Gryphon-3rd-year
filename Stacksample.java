import java.util.*;
public class Stacksample {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList();
        list.add("Mango");
        list.add("Banana");
        list.add("Apple");

        list.addFirst("Orange");
        list.addLast("cherry");
        list.add("Kiwi");

        list.remove("Apple");

        System.out.println("Fruits:"+list);
        System.out.println("First Fruit:"+list.getFirst());
        System.out.println("last Fruit:"+list.getLast());

        System.out.println();

        for(String f:list)
        {
            System.out.println("f:"+f);

        }
        
    }
    
}
