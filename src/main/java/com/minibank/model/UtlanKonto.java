package com.minibank.model;

import java.sql.Date;

/**
 * A subclass with the variable innfrielsedato
 */
public class UtlanKonto extends Konto {
    private Date innfrielsedato;

    public UtlanKonto(final int kontoNummer, final double saldo, final Date innfrielsedato) {
        super(kontoNummer, saldo);
        this.innfrielsedato = innfrielsedato;
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

    public Date getInnfrielsedata() {
        return innfrielsedato;
    }

    public void setInnfrielsedato(Date innfrielsedato) {
        this.innfrielsedato = innfrielsedato;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UtlanKonto{");
        sb.append("innfrielsedata=").append(innfrielsedato);
        sb.append(", kontoNummer=").append(kontoNummer);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
