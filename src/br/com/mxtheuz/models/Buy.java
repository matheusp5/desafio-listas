package br.com.mxtheuz.models;

public class Buy {
    public String description;
    public double value;
    public String date;

    public Buy(String description, double value, String date) {
        this.description = description;
        this.value = value;
        this.date = date;
    }
}
