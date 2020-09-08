package StringPredicateDemo;


public class FunctionalInterfaceDemo {
    
    public static void printTestResult(StringPredicate p, 
            String s, String t){
        System.out.println(p.test(s, t));
    }
    
    public static void main(String[] args){
        
        StringPredicate p1 = (s1, s2) -> s1.equals(s2);
        StringPredicate p2 = (s1, s2) -> s1.length() == s2.length();
        
//        printTestResult(p1, "Java", "java");
//        printTestResult(p1, "Java", "Java");
//        printTestResult(p2, "Java", "java");
//        
        printTestResult(p1.or(p2), "Java", "java");
        printTestResult(p1.and(p2), "Java", "java");
        printTestResult(p2.and(p1.negate()), "Java", "java");
    }
    
}
