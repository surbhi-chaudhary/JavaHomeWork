package org.example.h1.animal.subclass;

import org.example.h1.animal.Animal;

public class Dog extends Animal {


    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
    public void fetch(){
        System.out.println("Dog is fetching." );
    }
}
