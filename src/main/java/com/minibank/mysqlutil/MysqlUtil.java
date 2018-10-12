package com.minibank.mysqlutil;

import com.minibank.model.Konto;
import com.minibank.model.Kunde;
import com.minibank.model.UtlanKonto;
import com.minibank.model.VanligKonto;

import java.sql.*;

/**
 * A mysql utilty class that handles creating, deleting and updating of tables.
 * <p>
 * This would have been much easier if the Hibernate framework could read my hibernate.cfg.xml
 * in the resource folder, but for some reason it did not work for me.
 */
public class MysqlUtil {
    private final String myDriver = "com.mysql.jdbc.Driver";
    private final String myUrl = "jdbc:mysql://localhost:3306/minibankdb";
    private Connection connection;
    private String query;

    /**
     * Starts connecting to database
     */
    public void connectDB() throws ClassNotFoundException, SQLException {
        Class.forName(myDriver);
        connection = DriverManager.getConnection(myUrl, "root", "");
    }

    /**
     * Creates a new table for kunde
     *
     * @param kunde
     * @throws SQLException
     */
    public void createNewKunde(final Kunde kunde) throws SQLException {
        query = " insert into Kunde (kunde_nummer, navn)" + " values (?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, kunde.getKundeNummer());
        stmt.setString(2, kunde.getNavn());
        stmt.execute();
    }

    /**
     * Creates a new table for UtlanKonto or VanligKonto
     *
     * @param konto
     * @param kunde
     * @throws SQLException
     */
    public void createNewKonto(final Konto konto, final Kunde kunde) throws SQLException {
        final PreparedStatement stmt;
        if (konto instanceof UtlanKonto) {
            query = "insert into UtlanKonto (konto_nummer, saldo, innfrielse_dato, eier) "
                    + "values (?, ?, ?, ?)";

            stmt = connection.prepareStatement(query);
            stmt.setInt(1, konto.getKontoNummer());
            stmt.setDouble(2, konto.getSaldo());
            stmt.setDate(3, ((UtlanKonto) konto).getInnfrielsedata());
            stmt.setInt(4, kunde.getKundeNummer());
        } else {

            query = "insert into VanligKonto (konto_nummer, saldo, bevilget_belop, eier) "
                    + "values (?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, konto.getKontoNummer());
            stmt.setDouble(2, konto.getSaldo());
            stmt.setDouble(3, ((VanligKonto) konto).getBevilgetBelop());
            stmt.setInt(4, kunde.getKundeNummer());
        }
        stmt.execute();
    }

    /**
     * Deletes a kunde table
     *
     * @param kunde
     * @throws SQLException
     */
    public void deleteKunde(final Kunde kunde) throws SQLException {
        query = "delete from kunde where kunde_nummer = " + kunde.getKundeNummer();
        connection.prepareStatement(query).execute();
    }

    /**
     * Deletes a UtlanKonto or VanligKonto table
     *
     * @param konto
     * @throws SQLException
     */
    public void deleteKonto(final Konto konto) throws SQLException {
        if (konto instanceof UtlanKonto) {
            query = "delete from UtlanKonto where konto_nummer = " + konto.getKontoNummer();
        } else {
            query = "delete from VanligKonto where konto_nummer = " + konto.getKontoNummer();
        }
        connection.prepareStatement(query).execute();
    }

    /**
     * Update a kunde table
     *
     * @param kunde
     * @throws SQLException
     */
    public void updateKunde(final Kunde kunde) throws SQLException {
        query = "update Kunde set navn = " + kunde.getNavn()
                + " where kunde_nummer = " + kunde.getKundeNummer();
        connection.prepareStatement(query).execute();
    }

    /**
     * Updates a konto table
     *
     * @param konto
     * @throws SQLException
     */
    public void updateKonto(final Konto konto) throws SQLException {
        final PreparedStatement stmt;
        if (konto instanceof UtlanKonto) {
            query = "update UtlanKonto"
                    + " set saldo = ?"
                    + ", innfrielse_dato = ?"
                    + " where konto_nummer = ?";
            stmt = connection.prepareStatement(query);
            stmt.setDouble(1, konto.getSaldo());
            stmt.setDate(2, ((UtlanKonto) konto).getInnfrielsedata());
            stmt.setInt(3, konto.getKontoNummer());
        } else {
            query = "update VanligKonto"
                    + " set saldo = ?"
                    + ", bevilget_belop = ?"
                    + " where konto_nummer = ?";
            stmt = connection.prepareStatement(query);
            stmt.setDouble(1, konto.getSaldo());
            stmt.setDouble(2, ((VanligKonto) konto).getBevilgetBelop());
            stmt.setInt(3, konto.getKontoNummer());
        }
        stmt.execute();
    }

    /**
     * Print the whole table from a database
     *
     * @param navn The name of the table
     * @throws SQLException
     */
    public void printWholeTableFromDB(final String navn) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from " + navn);
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println(navn);
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Disconnect from database
     *
     * @throws SQLException
     */
    public void disconnectDB() throws SQLException {
        connection.close();
    }
}
