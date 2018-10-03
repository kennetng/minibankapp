package com.minibank.app.model;

public abstract class Konto {
    final protected int kontoNummer;
    protected double saldo;

    public Konto(final int kontoNummer, final double saldo) {
        this.kontoNummer = kontoNummer;
        this.saldo = saldo;
    }

    public int getKontoNummer() {
        return kontoNummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
