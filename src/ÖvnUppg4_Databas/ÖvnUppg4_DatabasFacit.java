package ÖvnUppg4_Databas;

import LambdaKataFacit.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;


public class ÖvnUppg4_DatabasFacit {
    
    public Database database;
    public List<Question> questions = new ArrayList<>(); 
    
    //Hur många frågor finns i databasen?
    public int getAmountOfQuestionsInDatabase(){
        return  (int) questions.stream().count();
    }
    
    //Hitta antalet frågor för en viss, given kategori
    public int getAmountOfQuestionsForACertainCategory(Category category){
        return (int) questions.stream()
                .filter(q -> q.category.equals(category)).count();
    }
    
    //Lista alla frågesträngar där frågan tillhör en viss kategori
    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        return questions.stream().filter(c -> c.category.equals(category))
                .map(Question::getQuestionString).collect(Collectors.toList());
    }
    
    //Finns en viss given sträng som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate){
        return questions.stream().map(Question::getAllAnswers)
                .flatMap(value -> value.stream())
                .anyMatch(s -> s.equals(answerCandidate));
    }
    
    //Skapa en lista av alla svarsalternativ där varje svarsalternativ får 
    //förekomma en och endast en gång
    public List<String> getAllAnswerOptionsDistinct(){
       
        return questions.stream().map(Question::getAllAnswers)
                .flatMap(value -> value.stream()).distinct()
                .collect(Collectors.toList());
    }
    
    public List<String> getList(){
         return questions.stream().map(Question::getQuestionString)
         .collect(Collectors.toList());
    }
    
    //Hur ofta förekommer ett visst svarsalternativ i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate){
        return (int) questions.stream().map(Question::getAllAnswers)
                .flatMap(value -> value.stream())
                .filter(s -> s.equals(answerCandidate)).count();
    }
    

    //Skapa en Map där kategorierna är nycklar och värdena är en lista 
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory(){
       return questions.stream().collect(
               Collectors.groupingBy(Question::getCategory, 
               Collectors.mapping(Question::getQuestionString, 
                       Collectors.toList())));
    }
    
            
    
    public ÖvnUppg4_DatabasFacit(){
        database = new Database();
        questions = database.getQuestions();
        
//        System.out.println(getAmountOfQuestionsInDatabase());
//        
//        System.out.println(getAmountOfQuestionsForACertainCategory(Category.CHEMISTRY));
//        System.out.println(getAmountOfQuestionsForACertainCategory(Category.HISTORY));
//        System.out.println(getAmountOfQuestionsForACertainCategory(Category.FOOD));
        
//        System.out.println(getAllQuestionStringsBelongingACategory(Category.CHEMISTRY));
//        System.out.println(getAllQuestionStringsBelongingACategory(Category.HISTORY));
//        System.out.println(getAllQuestionStringsBelongingACategory(Category.FOOD));
////        
//System.out.println(getList());


//        System.out.println(isThisAnAnswerOption("Couscous"));
//        System.out.println(isThisAnAnswerOption("fsdgdsgdfgdf"));
////        
//        System.out.println(getAllAnswerOptionsDistinct());
//        
        System.out.println(getAnswerCandidateFrequncy("Couscous"));
        System.out.println(getAnswerCandidateFrequncy("Guld"));
        System.out.println(getAnswerCandidateFrequncy("gfdgd"));


//        Map<Category, List<String>> categoryQuestionMap = getQuestionGroupedByCategory();
//        categoryQuestionMap.forEach((k,v) -> System.out.println(k + " " +v));
    }
    
    public static void main(String[] args){
        ÖvnUppg4_DatabasFacit uppg4 = new ÖvnUppg4_DatabasFacit();
        
    }

}
