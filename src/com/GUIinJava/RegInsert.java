package com.GUIinJava;

import java.sql.*;

public class RegInsert {

        public RegInsert(String query)
        {

            try
            {
                Connection con  = DBManager.getDBConnection();

                DatabaseMetaData dbmd = con.getMetaData();
                System.out.println(dbmd.getDatabaseMajorVersion());
                System.out.println(dbmd.getDatabaseProductName());
                System.out.println(dbmd.getDriverName());
                Statement stmt = con.createStatement();

                //stmt.execute("create table reginfo(sname varchar(30),address varchar(40),gender varchar(10),hobbies varchar(30),languages varchar(30))");

                stmt.executeUpdate(query);
                ResultSet rs  = stmt.executeQuery("select *from reginfo");
                ResultSetMetaData rsmd  =	  rs.getMetaData();

                //System.out.println(rsmd.getTableName(0));
                System.out.println(rsmd.getColumnCount());
                //System.out.println(rsmd.getColumnName(0));






            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }


        }


}
