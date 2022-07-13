package com.naufal.coffee;

public class HandlerPesanan {
    String kodepesanan,namapesanan,coffeepesanan,hargapesanan,jumlahpesanan;

    public HandlerPesanan() {
    }

    public HandlerPesanan(String kodepesanan, String namapesanan, String coffeepesanan, String hargapesanan, String jumlahpesanan) {
        this.kodepesanan = kodepesanan;
        this.namapesanan = namapesanan;
        this.coffeepesanan = coffeepesanan;
        this.hargapesanan = hargapesanan;
        this.jumlahpesanan = jumlahpesanan;
    }

    public String getKodepesanan() {
        return kodepesanan;
    }

    public void setKodepesanan(String kodepesanan) {
        this.kodepesanan = kodepesanan;
    }

    public String getNamapesanan() {
        return namapesanan;
    }

    public void setNamapesanan(String namapesanan) {
        this.namapesanan = namapesanan;
    }

    public String getCoffeepesanan() {
        return coffeepesanan;
    }

    public void setCoffeepesanan(String coffeepesanan) {
        this.coffeepesanan = coffeepesanan;
    }

    public String getHargapesanan() {
        return hargapesanan;
    }

    public void setHargapesanan(String hargapesanan) {
        this.hargapesanan = hargapesanan;
    }

    public String getJumlahpesanan() {
        return jumlahpesanan;
    }

    public void setJumlahpesanan(String jumlahpesanan) {
        this.jumlahpesanan = jumlahpesanan;
    }
}
