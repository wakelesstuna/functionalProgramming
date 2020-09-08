package LambdaKataFacit;


import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;


public class Grouping {
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream()
             //   .collect(groupingBy(Person::getNationality)); 
                 .collect(groupingBy(p -> p.getNationality())); 
    }
}

