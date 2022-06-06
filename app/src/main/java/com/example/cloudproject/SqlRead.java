package com.example.cloudproject;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlRead {

    public static String command = "";
    public static String error = "";
    public static User user = new User();


    public static User GetUser(String email) throws InterruptedException {

        command = "SELECT * FROM users WHERE email=\"" + email + "\"";
        new Task().execute();
        Thread.sleep(3000);
        return user;
    }

    static class Task extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://lab-mysql1.mysql.database.azure.com:3306/demo?useSSL=true";//myDbConn=DriverManager.getConnection(url, "kqrh84", "{your_password}");
                Connection connection = DriverManager.getConnection(url, "kqrh84", "WMCnkf515");
                Statement statement = connection.createStatement();
                //statement.executeUpdate(command);
                ResultSet resultSet = statement.executeQuery(command);


                while(resultSet.next()){
                  user.phone = resultSet.getString(3);
                  user.address = resultSet.getString(4);
                  user.instegram = resultSet.getString(5);
                  user.fullName = resultSet.getString(6);
                  user.imageName = resultSet.getString(7);
                }
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
