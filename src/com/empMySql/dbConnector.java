package com.empMySql;

import java.sql.*;

public class dbConnector {

    ResultSet rs;
    Connection con = null;
    Statement stmnt = null;

    public Connection conOpen() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails","root","root");
            System.out.println("Succed");
        }catch (Exception e) {
            System.out.println("Exception occured");
        }
        return con;
    }
    public void conClose(Connection conn) throws SQLException{
        conn.close();
        return;
    }
}

