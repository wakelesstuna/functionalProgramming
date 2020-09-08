package LambdaDemo;

import java.util.LinkedList;
import java.util.List;


public class LambdaDemoPerson {
    
    class Person{
        String name;
        String phone;
        
        Person(String name, String phone){
            this.name = name;
            this.phone = phone;
        }
        
        public String getName(){
            return name;
        }
        
        public String getPhone(){
            return phone;
        }
    }
    
    static List<Person> persons = new LinkedList<>();
    
    void fillList(Person... args){
        for(Person s:args){
            persons.add(s);
        } 
    }
    
    LambdaDemoPerson(){
        fillList(new Person("Sigrun", "12345"), new Person("Anna", "987654"), new Person("Bertil", "54321"));
        
        persons.stream().map(Person::getName).forEach(s -> System.out.println(s)); 
        System.out.println("");
        persons.stream().map(Person::getPhone).forEach(s -> System.out.println(s)); 

    }
    
  
    
    
    public static void main (String[] args){
        LambdaDemoPerson ld = new LambdaDemoPerson();

        
    }

}
