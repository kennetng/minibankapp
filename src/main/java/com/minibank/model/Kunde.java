package com.minibank.model;


import java.util.ArrayList;


/**
 * A customer class that has a list of account tied to kundenummer
 */
public class Kunde {

    final private int kundenummer;
    final private String navn;
    final private ArrayList<Konto> kontoListe;


    public Kunde(final int kundenummer, final String navn) {
        this.kundenummer = kundenummer;
        this.navn = navn;
        kontoListe = new ArrayList<Konto>();
    }

    public void addVanligKonto(final int kontoNummer, final double saldo, final double bevilgetBelop) {
        //TODO Make a check if kontoNummer exist
        kontoListe.add(new VanligKonto(kontoNummer, saldo, bevilgetBelop));
    }

    public void addUtlansKonto(final int kontoNummer, final double saldo, final int innfrielsedata) {
        //TODO Make a check if kontoNummer exist
        kontoListe.add(new UtlanKonto(kontoNummer, saldo, innfrielsedata));
    }

    public void modifySaldoKonto(final int konto, final double saldo) throws NullPointerException {
        Konto kk = kontoListe.stream()
                .filter(k -> k.getKontoNummer() == konto)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No konto found with kontonummer: " + konto));
        kk.setSaldo(saldo);
    }

    public void modifyBevilgetBelop(final int konto, final double bevilgetBelop) throws NullPointerException {
        VanligKonto vk = (VanligKonto) kontoListe.stream()
                .filter(k -> k.getKontoNummer() == konto && k instanceof VanligKonto)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No konto found with kontonummer: " + konto));
        vk.setBevilgetBelop(bevilgetBelop);
    }

    public void modifyInnfrielseData(final int konto, final int innfrielseData) throws NullPointerException {
        UtlanKonto uk = (UtlanKonto) kontoListe.stream()
                .filter(k -> k.getKontoNummer() == konto && k instanceof UtlanKonto)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No konto found with kontonummer: " + konto));
        uk.setInnfrielsedata(innfrielseData);
    }

    public void deleteKonto(final int konto) {
        kontoListe.removeIf(k -> k.getKontoNummer() == konto);
    }

    public int getKundenummer() {
        return kundenummer;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kunde{");
        sb.append("kundenummer=").append(kundenummer);
        sb.append(", navn='").append(navn).append('\'');
        kontoListe.forEach(k -> sb.append(", kontoListe=").append(k.toString()));
        sb.append('}');
        return sb.toString();
    }
}
