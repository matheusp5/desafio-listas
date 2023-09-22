package br.com.mxtheuz.screens;

import br.com.mxtheuz.models.Person;

import java.util.Scanner;

public class Screens {

    private Person person;
    private final Scanner scanner = new Scanner(System.in);


    public void InitScreen() {
        System.out.println();
        System.out.println("Olá! Seja bem-vindo.");
        System.out.print("Para começar, insira o seu nome: ");
        String personName = scanner.next();

        System.out.println("Ótimo, " + personName + "! e agora, qual é o limite do seu cartão? ");
        double personCardLimit = scanner.nextDouble();

        this.person = new Person(personName, personCardLimit);
        System.out.println();
    }

    public void Dashboard() {
        System.out.println();
        System.out.println("***********************************");
        System.out.println("Nome:             " + this.person.getName());
        System.out.println("Limite do cartão: " + this.person.get);
        System.out.println("***********************************");
    }
}
