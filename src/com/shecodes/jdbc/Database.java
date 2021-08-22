package com.shecodes.jdbc;

import com.shecodes.models.Gender;
import com.shecodes.models.Student;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Database {

    public Database() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

    }

    public Connection connection(){
        try {
            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String password = "";
            Connection conn= DriverManager.getConnection(url,
                    user, password);
            return conn;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
    public void closeConnection() throws SQLException {
        connection().close();
    }




}
