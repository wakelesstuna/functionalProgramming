package LambdaDemo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaDemo {
    
    static List<String> kläder = new LinkedList<>();
    
    void fillList(String... args){
        for(String s:args){
            kläder.add(s);
        } 
    }
    
    LambdaDemo(){
        fillList("klänning", "byxor", "tröja", "jacka", "hatt", "vantar", "mössa");
        //kläder.forEach(s -> System.out.println(s));
        
        kläder.stream().filter(s -> s.charAt(0) == 'k').forEach(s -> System.out.println(s)); 
        System.out.println(" ");
        kläder.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        kläder.stream().map(s -> s+s).forEach(s -> System.out.println(s));
        System.out.println(" ");
    }
    
    
    
    public static void main (String[] args){
        LambdaDemo ld = new LambdaDemo();

        
    }

}
