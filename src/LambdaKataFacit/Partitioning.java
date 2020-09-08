package LambdaKataFacit;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.partitioningBy;


public class Partitioning {

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream().collect(partitioningBy(p -> p.getAge() >= 18));
    }
}
