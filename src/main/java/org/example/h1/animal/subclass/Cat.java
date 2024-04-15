package org.example.h1.animal.subclass;

import org.example.h1.animal.Animal;

public class Cat extends Animal {


    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
    public void scratch(){
        System.out.println("Cat is scratching." );
    }
}
