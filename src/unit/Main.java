package unit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        BookShelf bookList = new BookShelf();

        bookList.readFile(new File("input.txt"));
        bookList.showAll();
        System.out.println('\n');

       System.out.println("sorting by name");
        Comparator<Book> compare=new Book.BookComparatorName();
        bookList.sort(compare);
        bookList.showAll();
        System.out.println('\n');

        String name="name1";
        if(bookList.searchByName(name)!=null) {
            System.out.println("Yes "+name+" "+bookList.searchByName(name));
            System.out.println('\n');
        }
        else{
            System.out.println("there is no book "+name);
            System.out.println('\n');
        }

        System.out.println("sorting by author");
        Comparator<Book> compar=new Book.BookComparatorAuthor();
        bookList.sort(compar);
        bookList.showAll();
        System.out.println('\n');

        System.out.println('\n');
        System.out.println("Shoes by aaaa:");
        bookList.authorList("aaaa").stream().forEach(System.out::println);

        System.out.println('\n');
        System.out.println("grouped:");
        System.out.println(bookList.group());


    }
}
