package com.starttohkar.learn;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book{
     String bookName;
     int isbn;
     int bookPrice;

    public Book(String bookName, int isbn, int bookPrice) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", isbn=" + isbn +
                ", bookPrice=" + bookPrice +
                '}';
    }

    //default implementation
   /* @Override
    public int hashCode() {
        return Objects.hash(bookName, isbn, bookPrice);
    }*/

    //Default Implementation
    /*@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        return isbn == book.isbn &&
               bookPrice == book.bookPrice &&
               Objects.equals(bookName, book.bookName);
    }*/

    //using getClass() method
    /*@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }*/


    // using instance of
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book book))
            return false;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class SerDemoCustomClass
{
    public static void main(String[] args) {

        Set<Book> books = new HashSet<>();
        books.add(new Book("C++", 1, 100));
        books.add(new Book("C++", 2, 100));
        books.add(new Book("Python", 2, 200));
        books.add(new Book("Java", 3,300));

        System.out.println(books.size());
        System.out.println(books);


    }


}
