package LambdaKata;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;


public class FlattenCollection {

    public static List<String> transform(List<List<String>> l){
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        return collection.stream().flatMap(Collection::stream).collect(Collectors.toList());

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //valfri att implementera
    static List<String> goingDeeper(List<List<List<String>>> collection) {
        List<List<List<String>>> collection2 = asList(asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third")));
        return collection2.stream().flatMap(Collection::stream).flatMap(Collection::stream).collect(Collectors.toList());

        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
