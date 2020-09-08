package StreamDemo;


import LambdaKataFacit.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;


public class MapDemo {
    
    List<String> stuff = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();

    
    public MapDemo() {
        //Initializing lists
        names = Arrays.asList("Anna", "Bertil", "Camilla", 
                "Doris", "Elmer", "Hilma");
        
        //Skapar en map där namnen i names är nycklar och deras längder är värden
        Map<String, Integer> nameLengthTracker = names.stream()
                .collect(Collectors.toMap(p -> p, n -> n.length()));
        
 //       nameLengthTracker.forEach((k,v) -> System.out.println(k +" "+v));
        
//        System.out.println(nameLengthTracker.entrySet());
//        System.out.println(nameLengthTracker.keySet());
//        System.out.println(nameLengthTracker.values());
        
//
//        System.out.println(nameLengthTracker.get("Anna"));
////        
//        System.out.println(nameLengthTracker.containsKey("Bertil"));
//        System.out.println(nameLengthTracker.containsKey("Rulle"));
//        
//        System.out.println(nameLengthTracker.containsValue(4));
//        System.out.println(nameLengthTracker.containsKey(100));
//       
        
        nameLengthTracker.put("Frideborg", 9);
        
        //För att skriva ut värdena i mappen
 //       nameLengthTracker.forEach((k,v) -> System.out.println(k +" "+v));

        
        //vi gör replaceAll på värdena och multiplicerar dem med 2
       // nameLengthTracker.replaceAll((k,v) -> k.substring(1).length());
       // nameLengthTracker.forEach((k,v) -> System.out.println(k +" "+v));
        
        //Med compute ändrar vi ett av värdena till valfritt värde
//        nameLengthTracker.compute("Anna", (k, v) -> 100);  
//        nameLengthTracker.forEach((k,v) -> System.out.println(k +" "+v));


        stuff = Arrays.asList("bike", "öljett", "spoon", "card",
                "dime", "Monopolspel", "film", "game", "åder", 
                "fork", "knife", "ämne", "lame", "film" );
        numbers = Arrays.asList(15, 65, 23, 567, 1, 345, 33, 78,
                976, 1005);
        
        //PartitioningBy, vi delar upp numbers efter vilka nummer som är större eller mindre än 50
//        Map<Boolean, List<Integer>> under50 = numbers.stream()
//                .collect(partitioningBy(n -> n < 50));
//        //under50.forEach((k,v) -> System.out.println(k +" "+v));
//        System.out.println(under50.get(false));
//        System.out.println(" ");
//        System.out.println(under50.get(true));
        
        //GroupBy, vi grupperar stuff efter hur långa orden är
        Map<Integer, List<String>> wordLength = stuff.stream()
                .collect(groupingBy(n->n.length()));
        wordLength.forEach((k,v) -> System.out.println(k +" "+v));
        System.out.println(wordLength.get(5));
        
    }

    public static void main(String[] args){
        MapDemo s = new MapDemo();
    }
}
