package com.example.cloudproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity2 extends AppCompatActivity {

    private TextView text, errorText;
    private Button btn;
    String records = "", error = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textView);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = "or@mail.com";
//                new Task().execute();
//                if(!records.equals(""))
//                try {
//
//                    //text.setText(SqlReadWrite.GetName(email));
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                else
//                    text.setText("");
            }
        });

    }
    class Task extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://lab-mysql1.mysql.database.azure.com:3306/demo?useSSL=true";//myDbConn=DriverManager.getConnection(url, "kqrh84", "{your_password}");
                Connection connection = DriverManager.getConnection(url, "kqrh84", "WMCnkf515");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                while(resultSet.next()){
                    records = resultSet.getString(6); //+ " " + resultSet.getString(2) + "\n";
                }
            }
            catch(Exception e){
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            text.setText(records);
            if(error != "")
                errorText.setText(error);
            super.onPostExecute(unused);
        }
    }
}