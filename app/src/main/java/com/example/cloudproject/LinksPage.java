package com.example.cloudproject;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import java.sql.DriverManager;
import java.sql.SQLException;


public class LinksPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_page);




//        /* Register jdbc driver class. */
//        try {
//            Class.forName("org.postgresql.Driver");
//
//            /* Create connection url. */
//            String mysqlConnUrl = "jdbc:postgresql://lab-postgre1.postgres.database.azure.com:5432/OrDB?useSSL=true";
//            String url=           "jdbc:mysql://lab-mysql1.mysql.database.azure.com:3306/demo?useSSL=true";
//            String url2=          "jdbc:postgresql://lab-postgre1.postgres.database.azure.com:5432/{your_database}?user=kqrh84&password={your_password}&sslmode=require";
//            /* user name. */
//            String mysqlUserName = "kqrh84";
//
//            /* password. */
//            String mysqlPassword = "WMCnkf515";
//
//            /* Get the Connection object. */
//            java.sql.Connection conn = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
//            Log.d("connect", "connected");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }




    }
}