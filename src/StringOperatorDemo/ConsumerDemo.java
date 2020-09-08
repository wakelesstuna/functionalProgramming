package StringOperatorDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerDemo {

    
    public static void main(String[] args) {
        Consumer n = t -> System.out.println(t); 
        n.accept("Hej"); 

        List<String> l = new ArrayList<>();
        l.add("aaaa");
        l.add("bbbb");
//        
        l.forEach(e -> System.out.println(e));
        l.forEach(n);
//       
    }
    

}
