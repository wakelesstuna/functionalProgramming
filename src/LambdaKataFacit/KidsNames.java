package LambdaKataFacit;

import java.util.List;
import static java.util.stream.Collectors.toList;


public class KidsNames {
    
      public static List<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName).collect(toList()); 
    }

}

