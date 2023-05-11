package com.github.adedayo.code;

import java.sql.*;
import java.util.Random;

/**
 * @author Adedayo Adetoye
 */
public class SQLInjection {

    String classField = "Select * from importantTable where data=";

    boolean inject = (new SQLInjectionExtended()).execute("This is a body call");

    public SQLInjection() throws SQLException {
        throw new UnsupportedOperationException();
    }

    public ResultSet queryDB(String query) throws SQLException {
        int y = 4 + (new Random()).nextInt();
        System.out.println(y);
        // query += this.executeMyQuery("First execution " + query + y);
        System.out.println(query);
        // query += "select * from table where name='test'" + y;
        Connection conn = DriverManager.getConnection("SomeConnectionString");
        Statement stmt = conn.createStatement();
        boolean queried = stmt.execute(query);
        System.out.println("ExecutedQuery");
        ResultSet result = stmt.executeQuery(query);
        executeMyQuery("Executed Query");
        query += extendedQuery("Extended Query Select * from ", "table where secret=" + queried);
        System.out.println(query);
        query = executeMyQuery2(new SQLInjectionExtended());
        System.out.println(query);
        return result;
    }

    public String executeMyQuery(String q) throws SQLException {
        int y = 4 + (new Random()).nextInt();
        System.out.println(y);
        Connection conn = DriverManager.getConnection("SomeConnectionString");
        Statement stmt = conn.createStatement();
        String qq = "test" + y;
        stmt.execute(qq);
        return q;
    }

    public String executeMyQuery2(SQLInjectionExtended q) throws SQLException {
        int y = 4 + (new Random()).nextInt();
        System.out.println(y);

        q.execute("select " + y + inject);
        return "";
    }

    public ResultSet extendedQuery(String q, String z) throws SQLException {
        int y = 4 + (new Random()).nextInt() - 3;
        int m = y - 2;
        System.out.println(y);
        SQLInjectionExtended inject = new SQLInjectionExtended();
        // String r = q + y + z;
        inject.execute(classField + q + y + z + m);
        return inject.executeQuery(q);

    }
}
