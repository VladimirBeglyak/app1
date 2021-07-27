package com.beglyak_project.dao;

import com.beglyak_project.model.Person;

import java.util.Scanner;

public class Console {

    Person person;

    public static Person getData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи имя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введи фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Введи возраст: ");
        int age = scanner.nextInt();

        return new Person(firstName,lastName,age);
    }
}
