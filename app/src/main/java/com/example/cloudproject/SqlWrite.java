package com.example.cloudproject;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlWrite {

    public static String command = "";
    public static String error = "";


    public static void newUser(User user){

        command = "INSERT INTO users (email, phone, address, insta, name, image) " +
                "VALUES ('" +
                user.email + "', '" +
                user.phone + "', '" +
                user.address + "', '" +
                user.instegram + "', '" +
                user.fullName + "', '" +
                user.imageName + "');";
        new Task().execute();
    }



    static class Task extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://lab-mysql1.mysql.database.azure.com:3306/demo?useSSL=true";//myDbConn=DriverManager.getConnection(url, "kqrh84", "{your_password}");
                Connection connection = DriverManager.getConnection(url, "kqrh84", "WMCnkf515");
                Statement statement = connection.createStatement();
                statement.executeUpdate(command);

            }
            catch(Exception e){
                error = e.toString();
            }
            return null;
        }

//        @Override
//        protected void onPostExecute(Void unused) {
//            text.setText(records);
//            if(error != "")
//                errorText.setText(error);
//            super.onPostExecute(unused);
//        }
    }

}
