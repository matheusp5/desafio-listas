package br.com.mxtheuz.screens;

import java.util.Scanner;

public class Screens {

    private double cardLimit = 0;
    private String name = "";
    private final Scanner scanner = new Scanner(System.in);


    public void InitScreen() {
        System.out.println();
        System.out.println("Olá! Seja bem-vindo.");
        System.out.print("Para começar, insira o seu nome: ");
        this.name = scanner.next();

        System.out.println("Ótimo, " + name + "! e agora, qual é o limite do seu cartão? ");
        this.cardLimit = scanner.nextDouble();

        System.out.println();
    }
}
