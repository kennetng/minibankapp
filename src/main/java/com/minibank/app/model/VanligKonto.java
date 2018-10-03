package com.minibank.app.model;

public class VanligKonto extends Konto{
    private double bevilgetBelop;

    public VanligKonto(final int kontoNummer, final double saldo, final double bevilgetBelop) {
        super(kontoNummer, saldo);
        this.bevilgetBelop = bevilgetBelop;
    }

    public int getKontoNummer() {
        return kontoNummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(final double saldo) {
        this.saldo = saldo;
    }

    public double getBevilgetBelop() {
        return bevilgetBelop;
    }

    public void setBevilgetBelop(final double bevilgetBelop) {
        this.bevilgetBelop = bevilgetBelop;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VanligKonto{");
        sb.append("bevilgetBelop=").append(bevilgetBelop);
        sb.append(", kontoNummer=").append(kontoNummer);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
