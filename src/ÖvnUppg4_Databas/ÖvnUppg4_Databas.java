package ÖvnUppg4_Databas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ÖvnUppg4_Databas {
    
    public Database database;
    public List<Question> questions = new ArrayList<>(); 
    
    //Hur många frågor finns i databasen?
    public int getAmountOfQuestionsInDatabase(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Hitta antalet frågor för en viss, given kategori
    public int getAmountOfQuestionsForACertainCategory(Category category){
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Lista alla frågesträngar där frågan tillhör en viss kategori
    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    //Finns en viss given sträng som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Skapa en lista av alla svarsalternativ där varje svarsalternativ får förekomma en och endast en gång
    public List<String> getAllAnswerOptionsDistinct(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Hur ofta förekommer ett visst svarsalternativ i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Map<Category, List<String>> getQuestionGroupedByCategory(){
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ÖvnUppg4_Databas(){
        database = new Database();
        questions = database.getQuestions();
        
        System.out.println(getAmountOfQuestionsInDatabase());
        
        System.out.println(getAmountOfQuestionsForACertainCategory(Category.CHEMISTRY));
        System.out.println(getAmountOfQuestionsForACertainCategory(Category.HISTORY));
        System.out.println(getAmountOfQuestionsForACertainCategory(Category.FOOD));
        
        System.out.println(getAllQuestionStringsBelongingACategory(Category.CHEMISTRY));
        System.out.println(getAllQuestionStringsBelongingACategory(Category.HISTORY));
        System.out.println(getAllQuestionStringsBelongingACategory(Category.FOOD));
        
        System.out.println(isThisAnAnswerOption("Couscous"));
        System.out.println(isThisAnAnswerOption("fsdgdsgdfgdf"));
        
        System.out.println(getAllAnswerOptionsDistinct());
        
        System.out.println(getAnswerCandidateFrequncy("Couscous"));
        System.out.println(getAnswerCandidateFrequncy("Guld"));
        System.out.println(getAnswerCandidateFrequncy("gfdgd"));
        
        Map<Category, List<String>> categoryQuestionMap = getQuestionGroupedByCategory();
        categoryQuestionMap.forEach((k,v) -> System.out.println(k + " " +v));
    }
    
    public static void main(String[] args){
        ÖvnUppg4_Databas uppg4 = new ÖvnUppg4_Databas();
        
    }

}
