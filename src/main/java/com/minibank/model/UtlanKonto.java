package com.minibank.model;

public class UtlanKonto extends Konto {
    private int innfrielsedata;

    public UtlanKonto(final int kontoNummer, final double saldo, final int innfrielsedata) {
        super(kontoNummer, saldo);
        this.innfrielsedata = innfrielsedata;
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

    public int getInnfrielsedata() {
        return innfrielsedata;
    }

    public void setInnfrielsedata(final int innfrielsedata) {
        this.innfrielsedata = innfrielsedata;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UtlanKonto{");
        sb.append("innfrielsedata=").append(innfrielsedata);
        sb.append(", kontoNummer=").append(kontoNummer);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
