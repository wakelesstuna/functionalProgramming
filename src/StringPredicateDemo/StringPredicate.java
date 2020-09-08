package StringPredicateDemo;

public interface StringPredicate {
    
    boolean test(String t, String u);
    
    default StringPredicate negate(){
        return (t, u) -> !test(t, u);
    }
    
    default StringPredicate and(StringPredicate other){
        return (t, u) -> test(t, u) && other.test(t, u);
    }
    
    default StringPredicate or(StringPredicate other){
        return (t, u) -> test(t, u) || other.test(t, u);
    }
}
