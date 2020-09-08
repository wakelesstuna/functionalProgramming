package ÖvnUppg1_BasicStreams;

import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ÖvnUppg1f_sorting {

    public void getBooksInRatingOrder(List<Book> list){
        list.stream().sorted((p1, p2) -> ((Integer)p1.getRating()).compareTo(p2.getRating()))
                .forEach(b -> System.out.println(b.getTitle()));

    }

    public void getTitlesInOrder(List<Book> list){

        Collator c = Collator.getInstance(new Locale("sv", "SE"));
        list.stream().map(Book::getTitle)
                .sorted(c).forEach(b -> System.out.println(b));

    }




    public ÖvnUppg1f_sorting(){

        List<Book> list = BookUtil.getBookList();
        getBooksInRatingOrder(list);
        System.out.println();
        getTitlesInOrder(list);
    }

    public static void main(String[] args){
        ÖvnUppg1f_sorting öu = new ÖvnUppg1f_sorting();
    }
}
