package com.naufal.coffee;

public class HandlerCoffee {
    String kodecoffee,namacoffee,jeniscoffee,hargacoffee,stockcoffee;

    public HandlerCoffee() {
    }

    public HandlerCoffee(String kodecoffee, String namacoffee, String jeniscoffee, String hargacoffee, String stockcoffee) {
        this.kodecoffee = kodecoffee;
        this.namacoffee = namacoffee;
        this.jeniscoffee = jeniscoffee;
        this.hargacoffee = hargacoffee;
        this.stockcoffee = stockcoffee;
    }

    public String getKodecoffee() {
        return kodecoffee;
    }

    public void setKodecoffee(String kodecoffee) {
        this.kodecoffee = kodecoffee;
    }

    public String getNamacoffee() {
        return namacoffee;
    }

    public void setNamacoffee(String namacoffee) {
        this.namacoffee = namacoffee;
    }

    public String getJeniscoffee() {
        return jeniscoffee;
    }

    public void setJeniscoffee(String jeniscoffee) {
        this.jeniscoffee = jeniscoffee;
    }

    public String getHargacoffee() {
        return hargacoffee;
    }

    public void setHargacoffee(String hargacoffee) {
        this.hargacoffee = hargacoffee;
    }

    public String getStockcoffee() {
        return stockcoffee;
    }

    public void setStockcoffee(String stockcoffee) {
        this.stockcoffee = stockcoffee;
    }
}
