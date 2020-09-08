package ÖvnUppg1_BasicStreams;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class ÖvnUppg1a_filter {

    public List<Book> getAllBooksByAnAuthor(String author, List<Book> list){
        return list.stream().filter(s -> s.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooksByAColor(String color, List<Book> list){
        return list.stream().filter(s -> s.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    public int getNumberOfBooksBelongingToAnOwner(String owner, List<Book> list){
        return list.stream().filter(s -> s.getOwner().equalsIgnoreCase(owner))
                .collect(Collectors.toList()).size();
    }

    public ÖvnUppg1a_filter(){

        List<Book> list = BookUtil.getBookList();
        getAllBooksByAnAuthor("J.R.R. Tolkien", list)
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println();

        getAllBooksByAColor("röd", list)
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println();

        System.out.println(getNumberOfBooksBelongingToAnOwner("Sigrun", list));

    }

    public static void main(String[] args){
        ÖvnUppg1a_filter öu = new ÖvnUppg1a_filter();
    }
}
