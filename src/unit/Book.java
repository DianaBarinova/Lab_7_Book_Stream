package unit;

import java.util.Comparator;
import java.util.Objects;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
        this.name = "";
        this.author ="";
    }

    public Book(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word != "") {
                if (word.matches("\"\\w+\"") == true) {
                    name=word;
                }
                else{
                    author=word;
                }
            }
            }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }

    static class BookComparatorName implements Comparator<Book> {

        public int compare(Book b1, Book b2) {

            return b1.name.compareTo(b2.name);
        }

    }

    static class BookComparatorAuthor implements Comparator<Book> {

        public int compare(Book b1, Book b2) {

            return b1.author.compareTo(b2.author);
        }

    }
}
