package LambdaKataFacit;

import java.util.List;
import java.util.stream.Collectors;


public class FlattenCollection {

    public static List<String> transform(List<List<String>> l){
        return l.stream().flatMap(value -> value.stream()).collect(Collectors.toList());
    }
    
    public static List<String> goingDeeper(List<List<List<String>>> l){
        return l.stream()
                .flatMap(value -> value.stream()
                .flatMap(value2 -> value2.stream()))
                .collect(Collectors.toList());
    }
}
