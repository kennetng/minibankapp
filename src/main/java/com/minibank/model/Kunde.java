package com.minibank.model;

/**
 * A Kunde class that contains kundeNummer and navn.
 * It is an one to many relation with konto in the database.
 */

public class Kunde {
    final private int kundeNummer;
    private String navn;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kunde(final int kundeNummer, final String navn) {
        this.kundeNummer = kundeNummer;
        this.navn = navn;
    }

    public int getKundeNummer() {
        return kundeNummer;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kunde{");
        sb.append("kundenummer=").append(kundeNummer);
        sb.append(", navn='").append(navn).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
