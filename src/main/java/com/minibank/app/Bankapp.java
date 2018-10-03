package com.minibank.app;


import com.minibank.model.Kunde;

public class Bankapp {
    public static void main(String args[]){
        Kunde kunde1 = new Kunde(123456, "Kenneth Ngo");
        Kunde kunde2 = new Kunde(145167, "Shiela Nguyen");

        kunde1.addVanligKonto(1234, 22.0, 10.0);
        kunde1.addUtlansKonto(5555, 14.0, 152211);

        System.out.println(kunde1.toString());
        System.out.println(kunde2.toString());

        kunde1.modifyBevilgetBelop(1234, 166.11);
        kunde1.modifyInnfrielseData(5555, 12);
        kunde1.modifySaldoKonto(1234, 166.2);

        System.out.println("\n" + kunde1.toString());
    }
}
