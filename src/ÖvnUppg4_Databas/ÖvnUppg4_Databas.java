package ÖvnUppg4_Databas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ÖvnUppg4_Databas {
    
    public Database database = new Database();
    public List<Question> questions = database.getQuestions();
    
    //G. Hur många frågor finns i databasen?
    public int getAmountOfQuestionsInDatabase(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //G. Hitta antalet frågor för en viss, given kategori
    public int getAmountOfQuestionsForACertainCategory(Category category){
       throw new UnsupportedOperationException("Not supported yet.");
    }

    //G. Lista alla frågesträngar i databasen
    public List<String> getListOfAllQuestions(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //G. Lista alla frågesträngar där frågan tillhör en viss kategori
    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //G. Skapa en lista av alla svarsalternativ där varje svarsalternativ får förekomma en och endast en gång
    public List<String> getAllAnswerOptionsDistinct(){
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //VG. Finns en viss given sträng som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //VG. Hur ofta förekommer ett visst svarsalternativ i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //VG. Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory(){
       throw new UnsupportedOperationException("Not supported yet.");
    }

    //VG. Skapa en funktion som hittar det svarsalternativ som har felst bokstäver, i en kategori
    // Använd Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void main(String[] args){
        ÖvnUppg4_Databas uppg4 = new ÖvnUppg4_Databas();
        
    }

}
