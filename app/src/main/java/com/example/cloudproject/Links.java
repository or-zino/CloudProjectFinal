package com.example.cloudproject;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;

import com.google.type.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Links extends AppCompatActivity {

    //String jdbcUrl = "jdbc:postgresql://lab-postgre1.postgres.database.azure.com:5432/OrDB?user=kqrh84&password=WMCnkf515&sslmode=require";

    TextView link1,link2,link3,link4,link5,link6,link7,link8,link9,link10,link11,link12,link13;
    Button add;
    EditText editTextUrl;
    PostgreSqlJDBC postgreSqlJDBC = new PostgreSqlJDBC();
    PostgreSqlWirte postgreSqlWirte = new PostgreSqlWirte();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_links);


        link1 = findViewById(R.id.link1);
        link2 = findViewById(R.id.link2);
        link3 = findViewById(R.id.link3);
        link4 = findViewById(R.id.link4);
        link5 = findViewById(R.id.link5);
        link6 = findViewById(R.id.link6);
        link7 = findViewById(R.id.link7);
        link8 = findViewById(R.id.link8);
        link9 = findViewById(R.id.link9);
        link10 = findViewById(R.id.link10);
        link11 = findViewById(R.id.link11);
        link12 = findViewById(R.id.link12);
        link13 = findViewById(R.id.link13);

        add   = findViewById(R.id.addLinkBtn);
        editTextUrl = findViewById(R.id.etUrl);

        String allUrls = "";
        try {

            allUrls = PostgreSqlJDBC.getUrl(MainActivity.email);
            String[] urlsList = allUrls.split(",");
            for(int i = 0 ; i < urlsList.length; i++){
                switch (i) {
                    case 0:
                        link1.setText(urlsList[i]);
                        break;
                    case 1:
                        link2.setText(urlsList[i]);
                        break;
                    case 2:
                        link3.setText(urlsList[i]);
                        break;
                    case 3:
                        link4.setText(urlsList[i]);
                        break;
                    case 4:
                        link5.setText(urlsList[i]);
                        break;
                    case 5:
                        link6.setText(urlsList[i]);
                        break;
                    case 6:
                        link7.setText(urlsList[i]);
                        break;
                    case 7:
                        link8.setText(urlsList[i]);
                        break;
                    case 8:
                        link9.setText(urlsList[i]);
                        break;
                    case 9:
                        link10.setText(urlsList[i]);
                        break;
                    case 10:
                        link11.setText(urlsList[i]);
                        break;
                    case 11:
                        link12.setText(urlsList[i]);
                        break;
                    case 12:
                        link13.setText(urlsList[i]);
                        break;
                    default:
                        break;

                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link1.getText().toString();
                deleteDiag(link);
            }
        });
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link2.getText().toString();
                deleteDiag(link);
            }
        });
        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link3.getText().toString();
                deleteDiag(link);
            }
        });
        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link4.getText().toString();
                deleteDiag(link);
            }
        });
        link5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link5.getText().toString();
                deleteDiag(link);
            }
        });
        link6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link6.getText().toString();
                deleteDiag(link);
            }
        });
        link7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link7.getText().toString();
                deleteDiag(link);
            }
        });
        link8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link8.getText().toString();
                deleteDiag(link);
            }
        });
        link9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link9.getText().toString();
                deleteDiag(link);
            }
        });
        link10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link10.getText().toString();
                deleteDiag(link);
            }
        });
        link11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link11.getText().toString();
                deleteDiag(link);
            }
        });
        link12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link12.getText().toString();
                deleteDiag(link);
            }
        });
        link13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = link13.getText().toString();
                deleteDiag(link);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = editTextUrl.getText().toString();
                try {
                    PostgreSqlWirte.addUrl(MainActivity.email,url);

                    startActivity(new Intent(Links.this,Links.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void deleteDiag(String link){
        AlertDialog dlg = new AlertDialog.Builder(Links.this)
                .setTitle("Delete / Copy")
                .setMessage("You want to Copy or Delete URL")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            PostgreSqlWirte.deleteUrl(MainActivity.email,link);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finish();
                        startActivity(new Intent(getApplicationContext(), Links.class));
                        dialog.dismiss();
                    }
                }).setNegativeButton("Copy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("URL", link);
                        clipboard.setPrimaryClip(clip);
                        dialog.dismiss();

                    }
                })
                .create();
        dlg.show();
//                                        ds.getRef().removeValue();
//                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                                    Toast.makeText(RemoveMedicalBag.this,"medical bag has been remove",Toast.LENGTH_SHORT).show();


    }
}

