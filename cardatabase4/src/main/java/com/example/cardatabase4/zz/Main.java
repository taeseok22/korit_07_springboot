package com.example.cardatabase4.zz;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석", "남궁성");
        EBook ebook = new EBook("스프링3부트 3 백과사전", "김영환", 20.5);

        book.displayInfo();
        ebook.displayInfo();
    }
}