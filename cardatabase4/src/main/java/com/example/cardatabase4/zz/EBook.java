package com.example.cardatabase4.zz;

public class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("제목 : " + title + ", 저자 : " + author + ", 파일 크기 : " + fileSize + "MB");
    }
}