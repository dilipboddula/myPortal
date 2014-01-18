package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelDAO
{
	static Connection con;
	public static Connection connectDB(){
    try {
       String drivername="com.mysql.jdbc.Driver";
       Class.forName(drivername).newInstance();
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sapient","root","root");
        } catch (InstantiationException e) {
        // TODO Auto-generated catch block
         e.printStackTrace();
         } catch (IllegalAccessException e) {
           // TODO Auto-generated catch block
              e.printStackTrace();
              } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
           e.printStackTrace();
           } catch (SQLException e) {
       // TODO Auto-generated catch block
               e.printStackTrace();
}
return con;
}
}

