package LambdaKata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class GetOldestPerson {

     public static Person getOldestPerson(List<Person> people) {

         Person cribb = new Person("Cribb", 31);
         Person oscar = new Person("Oscar", 28);
         Person maggan = new Person("Maggan", 65);
         List<Person> persons = Arrays.asList(cribb,oscar,maggan);

         return persons.stream().max(Comparator.comparing(Person::getAge)).get();

         //throw new UnsupportedOperationException("Not supported yet.");
    }
}
