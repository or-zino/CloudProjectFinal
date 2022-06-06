package com.example.cloudproject;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class  PostgreSqlJDBC {
    static String cadenaConexion = "jdbc:postgresql://lab-postgre1.postgres.database.azure.com:5432/OrDB?user=kqrh84&password=WMCnkf515&sslmode=require";
    static String respuestaSql= "";
    public static String command = "";

    public PostgreSqlJDBC() {
    }

    public static String getUrl(String email) throws InterruptedException {
        command = "SELECT * FROM urls";
        new Task().execute();
        Thread.sleep(2000);
        return respuestaSql;
    }
    static class Task extends AsyncTask<Void, Void, Void> {

        @Override
        public Void doInBackground(Void... params) {
            Connection connection = null;
            Statement statement = null;
            ResultSet result = null;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(cadenaConexion);
                statement = connection.createStatement();
                result = statement.executeQuery(command);
                respuestaSql = "";
                while (result.next()) {
                    String emailInDB = result.getString("email");
                    /*if(emailInDB.equals("or@mail.com"))*/if(emailInDB.equals(MainActivity.email)) {
                        String urlInDB = result.getString("url");
                        respuestaSql = respuestaSql  + urlInDB + ",";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Error: Cant connect!");
                connection = null;
            } finally {
                if (statement != null) {
                    try {
                        result.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                    }
                }
            }
            return null;
        }
    }
}
