package unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    ArrayList<Book> bookList;

    public BookShelf() { bookList = new ArrayList<>();
    }

    public BookShelf(Book book) {
        bookList.add(book);
    }
    public void readFile(File file) throws IOException {
        BufferedReader fileInput = new BufferedReader(new FileReader(file));
        int count = Integer.parseInt(fileInput.readLine());
        bookList = (ArrayList<Book>) fileInput.lines().limit(count).map(Book::new).collect(Collectors.toList());
        fileInput.lines().forEach(string -> bookList.add(new Book(string)));
    }
    public void showAll(){
        bookList.stream().forEach(System.out::println);
    }

    public void sort(Comparator<Book> compere) {
        bookList.sort(compere);
    }

    public Book searchByName(String name) {

        int firstIndex = 0;
        int lastIndex = bookList.size() - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (name.equals(bookList.get(middleIndex).getName()))
                return bookList.get(middleIndex);
            else if (name.compareTo(bookList.get(middleIndex).getName()) > 0)
                firstIndex = middleIndex + 1;
            else if (name.compareTo(bookList.get(middleIndex).getName()) < 0)
                lastIndex = middleIndex - 1;

        }
        return null;
    }

    public List<Book> authorList(String _a)
    {
        return bookList.stream().filter(author -> _a.equals(author.getAuthor())).collect(Collectors.toList());
    }
    public Map<String, List<Book>> group(){
        Map<String,List<Book>> grouped = new HashMap<>();
        for(Book i : bookList){
            List<Book> tmp = grouped.get(i.getAuthor());
            if(tmp == null)
                tmp = new ArrayList<>();
            tmp.add(i);
            grouped.put(i.getAuthor(),tmp);
        }
        return grouped;
    }
}
