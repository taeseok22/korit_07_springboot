package com.example.cardatabase4.zz;

class Animal {
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("개가 짖습니다.");
        // Dog 클래스의 고유 메서드
        public void fetch() {
            System.out.println("멍멍");
        }
    }
}
clsss Cat extends Animal {

}
public class PolymorphismExample {
    public static void main(String[] args) {

    }
}
