package ÖvnUppg1_BasicStreams;

import java.util.List;
import java.util.stream.Collectors;

public class ÖvnUppg1g_joining {

    public String getAllTitles(List<Book> list){
        return list.stream().map(Book::getTitle)
                .collect(Collectors.joining(", ", "" , ""));
    }



    public ÖvnUppg1g_joining(){

        List<Book> list = BookUtil.getBookList();
        System.out.println(getAllTitles(list));
    }

    public static void main(String[] args){
        ÖvnUppg1g_joining öu = new ÖvnUppg1g_joining();
    }
}
