package com.example.cardatabase4.zz;

public class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("제목: " + title + "저자: " + author);
    }


}
