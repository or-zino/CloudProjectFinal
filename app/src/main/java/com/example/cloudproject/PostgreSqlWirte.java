package com.example.cloudproject;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class PostgreSqlWirte {
    static String cadenaConexion = "jdbc:postgresql://lab-postgre1.postgres.database.azure.com:5432/OrDB?user=kqrh84&password=WMCnkf515&sslmode=require";
    public static String command = "";
    public static String error = "";

    public PostgreSqlWirte() {
    }

    public static void addUrl(String email, String url) throws InterruptedException {
        int id = (int) (new Date().getTime() / 1000);
        command = "INSERT INTO urls (id, email, url) " +
                "VALUES ('" +
                id + "', '" +
                email + "', '" +
                url + "')";
        new Task().execute();
    }

    public static void deleteUrl(String email, String url) throws InterruptedException{
        command = "DELETE FROM urls WHERE" +
                " email='" + email + "' AND" +
                " url='" + url + "'" ;
        new Task().execute();
    }

    static class Task extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Connection connection = null;
                Statement statement = null;
                ResultSet result = null;
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(cadenaConexion);
                    statement = connection.createStatement();
                    statement.executeUpdate(command);



            }catch (Exception e) {
                error = e.toString();
            }
            return null;
        }
    }
}