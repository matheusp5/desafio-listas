package br.com.mxtheuz.screens;

import br.com.mxtheuz.models.Person;

import java.util.Scanner;

public class Screens {

    private Person person;
    private final Scanner scanner = new Scanner(System.in);


    public void initScreen() {
        System.out.println();
        System.out.println("Olá! Seja bem-vindo.");
        System.out.print("Para começar, insira o seu nome: ");
        String personName = scanner.next();

        System.out.println("Ótimo, " + personName + "! e agora, qual é o limite do seu cartão? ");
        double personCardLimit = scanner.nextDouble();

        this.person = new Person(personName, personCardLimit);
    }

    public void options() {
        System.out.println();
        System.out.println("O que você deseja fazer? ");
        System.out.println("1- Consultar conta");
        System.out.println("2- Registrar compra");
        System.out.println("3- Conferir extrato");
        System.out.println();
        System.out.print("Sua escolha: ");
        int choose = scanner.nextInt();

    }

    private void processChoose(int choose) {
        switch (choose) {
            case 1:
                this.dashboard();
                break;
            case 2:
                break;

            case 3:
                break;

            default:
                break;

        }
    }

    public void dashboard() {
        System.out.println();
        System.out.println("***********************************");
        System.out.println("Nome:             " + this.person.getName());
        System.out.println("Limite do cartão: " + this.person.getCardLimit() + "(" + this.person.getRestInCardLimit() + " restante)");
        System.out.println("Total em compras: " + this.person.getTotalFromPurchases() + "(" +this.person.getPurchases().size() + " compras)" );
        System.out.println("***********************************");
    }
}
