package com.minibank.app;

import com.minibank.model.Kunde;
import com.minibank.model.UtlanKonto;
import com.minibank.model.VanligKonto;
import com.minibank.mysqlutil.MysqlUtil;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Main application that init one Kunde and three konto.
 */
public class Bankapp {
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        MysqlUtil sqlUtil = new MysqlUtil();

        /* Creates one kunde object */
        final Kunde kunde1 = new Kunde(123456, "Kenneth");

        /* Creates three konto objects */
        final VanligKonto konto1 = new VanligKonto(1234, 22.0, 10.0);
        final UtlanKonto konto2 = new UtlanKonto(5555, 14.0, java.sql.Date.valueOf("2010-01-31"));
        final VanligKonto konto3 = new VanligKonto(1555, 251.1, 20.0);

        sqlUtil.connectDB();

        /* Creates one kunde on SQL */
        sqlUtil.createNewKunde(kunde1);

        /* Creates three konto on SQL*/
        sqlUtil.createNewKonto(konto1, kunde1);
        sqlUtil.createNewKonto(konto2, kunde1);
        sqlUtil.createNewKonto(konto3, kunde1);

        /* Print out the whole database */
        System.out.println("Printer ut hele databasen");
        sqlUtil.printWholeTableFromDB("Kunde");
        sqlUtil.printWholeTableFromDB("VanligKonto");
        sqlUtil.printWholeTableFromDB("UtlanKonto");

        /* Modify saldo */
        konto2.setSaldo(2222.2);
        sqlUtil.updateKonto(konto2);
        System.out.println("\nEtter endring i saldo");
        sqlUtil.printWholeTableFromDB("UtlanKonto");

        /* Delete Konto */
        sqlUtil.deleteKonto(konto1);
        System.out.println("\nEtter delete");
        sqlUtil.printWholeTableFromDB("VanligKonto");

        sqlUtil.disconnectDB();
    }
}
