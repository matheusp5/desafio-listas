package br.com.mxtheuz.screens;

import java.util.Scanner;

public class Screens {

    private double CardLimit = 0;
    private String name = "";
    private final Scanner scanner = new Scanner(System.in);


    public void InitScreen() {
        System.out.println();
        System.out.println("Olá! Seja bem-vindo.");
        System.out.print("Para começar, iniciar o seu nome: ");
        this.name = scanner.next();

        System.out.println();
    }
}
