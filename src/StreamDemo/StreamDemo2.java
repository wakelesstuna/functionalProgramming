package StreamDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamDemo2 {
    
    List<String> stuff = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    IntStream intStream;
    Stream stringStream;
    
    public StreamDemo2() throws FileNotFoundException {
        //Initializing lists
        stuff = Arrays.asList("bike", "öljett", "spoon", "card","dime", 
                "Monopolspel", "film", "game", "åder", "fork", 
                "knife", "ämne", "lame", "film" );
        
        numbers = Arrays.asList(15, 65, 23, 567, 1, 345, 33, 78, 976, 1005);
        
        //Initializing streams
        stringStream = Stream.of("green", "yellow", "green", "green", 
                "blue", "black", "white");
        
        intStream = IntStream.of(12, 23, 34, 13, 1);
       
//        //Distinct
//        System.out.println(stringStream.distinct()
//                .collect(Collectors.toList()));
        
//        //Sorted() för en List<Integer>
//        numbers.stream().mapToInt(e -> e).sorted()
//                .forEach(s -> System.out.println(s));
//                

        //Sorted() för strängar sorterar i ASCII-ordning, notera att versaler alltid kommer före gemener
        //å, ä, ö kommer i fel ordning
//        System.out.println(stuff.stream().sorted()
//                .collect(Collectors.toList()));
//        
//        //sorterar baklänges
//        System.out.println(stuff.stream()
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList()));
        
//        //om vi vill ha svensk sortering:
        Collator svenskCollator = Collator
                .getInstance(new Locale("sv", "SE"));
//        System.out.println(stuff.stream().sorted(svenskCollator)
//                .collect(Collectors.toList()));
//        
//        //Sorterar på svenskt sätt baklänges
//        System.out.println(stuff.stream()
//                .sorted(svenskCollator.reversed())
//                .collect(Collectors.toList()));
//        
//        //SummaryStatistics
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).summaryStatistics().getMin());
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).summaryStatistics().getCount());
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).summaryStatistics().getMax());
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).summaryStatistics().getAverage());
//        
//        //Vi får en Optional
//        System.out.println(numbers.stream().
//                mapToDouble(Double::valueOf).min().getAsDouble());
////        
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).min().getAsInt());
////        
////        //Ger inte en OptionalInt
//        System.out.println(numbers.stream().
//                mapToInt(Integer::valueOf).sum());
//        
//        //Vi kan få strömmar från t.ex BufferedReader
//        BufferedReader in = new BufferedReader(
//                new FileReader("src\\StreamDemo\\totaleclipse.txt"));
//        System.out.println(in.lines().count());
        
//        För att skriva ut alla ord i filen i bokstavsordning 
        Pattern p = Pattern.compile("\\s+");
        BufferedReader in2 = new BufferedReader(
                new FileReader("src\\StreamDemo\\totaleclipse.txt"));
        in2.lines().flatMap(s -> p.splitAsStream(s))
                .map(s -> s.toLowerCase())
                .distinct().sorted()
                .forEach(s -> System.out.println(s));
//        
////        //Joining, skriver ut låttexten med komma emellan
//        BufferedReader in3 = new BufferedReader(
//                new FileReader("src\\StreamDemo\\totaleclipse.txt"));
//        System.out.println(in3.lines()
//                .collect(Collectors.joining(",")));
////        
//        System.out.println(stuff.stream()
//                .collect(Collectors.joining("-", "%", "*")));
////        
    }

    public static void main(String[] args) throws FileNotFoundException{
        StreamDemo2 s = new StreamDemo2();
    }
}
