package br.com.mxtheuz.screens;

import br.com.mxtheuz.models.Buy;
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

        System.out.print("Ótimo, " + personName + "! e agora, qual é o limite do seu cartão? ");
        double personCardLimit = scanner.nextDouble();

        this.person = new Person(personName, personCardLimit);
    }

    public boolean options() {
        System.out.println();
        System.out.println("Olá, " + this.person.getName());
        System.out.println("O que você deseja fazer? ");
        System.out.println("1- Consultar conta");
        System.out.println("2- Registrar compra");
        System.out.println("3- Conferir extrato");
        System.out.println("4- Sair");
        System.out.println();
        System.out.print("Sua escolha: ");
        int choose = scanner.nextInt();
        if(choose == 4) return false;
        this.processChoose(choose);
        return false;
    }

    public void registerPurchase() {
        System.out.println();
        System.out.println("Ok! Você deseja fazer uma nova compra, saiba que você tem R$ " + this.person.getRestInCardLimit() + " sobrando.");
        System.out.println();
        System.out.print("Qual é a descrição da compra? ");
        String description = scanner.next();

        System.out.print("Qual é o valor da compra? ");
        double total = scanner.nextDouble();

        if(this.person.getRestInCardLimit() >= total) {
            System.out.println();
            System.out.println("Resumo: ");
            System.out.println("Descrição: " + description);
            System.out.println("Total: " + total);
            System.out.println("Valor restante após a compra: R$ " + (this.person.getRestInCardLimit() - total));
            System.out.print("Deseja prosseguir? (S/N) ");
            String choose = (this.scanner.next()).toLowerCase();

            if(choose.equals("s")) {
                this.person.createPayment(description, total);
                System.out.println("Compra efetuada com sucesso.");
                this.options();
            } else if (choose.equals("n")) {
                System.out.println("Ok!");
                this.options();
            } else {
                this.registerPurchase();
            }
        } else {
            System.out.println("Você não tem limite suficiente.");
            this.registerPurchase();
        }
    }

    public void getExtract() {
        System.out.println();
        System.out.println("Confira o seu extrato");
        System.out.println();

        for (Buy buy : this.person.getPurchases()) {
            System.out.println("-");
            System.out.println(buy.description);
            System.out.println("Valor: R$ " + buy.value);
            System.out.println("Registrado em " + buy.date);
        }
        System.out.println("-");
        this.options();
    }

    private void processChoose(int choose) {
        switch (choose) {
            case 1:
                this.dashboard();
                break;
            case 2:
                this.registerPurchase();
                break;

            case 3:
                this.getExtract();
                break;
            default:
                System.out.println("Opção inválida!");
                this.options();
                break;

        }
    }

    public void dashboard() {
        System.out.println();
        System.out.println("***********************************");
        System.out.println("Nome:                " + this.person.getName());
        System.out.println("Limite do cartão:    R$ " + this.person.getCardLimit() + " (R$ " + this.person.getRestInCardLimit() + " restante)");
        System.out.println("Total em compras:    " + this.person.getTotalFromPurchases() + "(" +this.person.getPurchases().size() + " compras)" );
        System.out.println("***********************************");
        this.options();
    }
}
