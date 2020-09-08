package LambdaKataFacit;

import java.util.Comparator;
import java.util.List;


public class GetOldestPerson {

     public static Person getOldestPerson(List<Person> people) {
        return people.stream().max(Comparator.comparing(Person::getAge)).get(); 
    }
     
    

}
