package LambdaKataFacit;

import java.util.List;
import java.util.stream.IntStream;


public class SumElements {
    
    public static IntStream getIntStream(List<Integer> list)
    {
        return list.stream().mapToInt(Integer::intValue);
    }
    
    public static int calculate(List<Integer> numbers) {
        
      //  return numbers.stream().reduce(0, (total, number) -> total + number); 
        
        //alternative solution: 
        return getIntStream(numbers).sum();
    }
}
