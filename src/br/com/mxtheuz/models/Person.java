package br.com.mxtheuz.models;

import br.com.mxtheuz.utils.DateHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private double cardLimit;
    private List<Buy> purchases;

    public Person(String name, double cardLimit) {
        this.name = name;
        this.cardLimit = cardLimit;
        this.purchases = new ArrayList<>();
    }

    public void createPayment(String description, double total) {
        if(this.cardLimit >= total) {
            Buy buy = new Buy(description, total, DateHelper.getDate());
            this.purchases.add(buy);
        }
    }

    public double getTotalFromPurchases() {
        double total = 0;
        for (Buy buy : this.purchases) {
            total += buy.value;
        }
        return total;
    }

    public double getRestInCardLimit() {
        return this.cardLimit - this.getTotalFromPurchases();
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public List<Buy> getPurchases() {
        return purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
