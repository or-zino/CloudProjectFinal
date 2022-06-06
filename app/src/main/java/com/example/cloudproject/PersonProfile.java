package com.example.cloudproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PersonProfile extends AppCompatActivity {

    private User user = SqlRead.GetUser(MainActivity.email);
    public  String email;
    private ImageView imUser;
    private TextView nameTV, emailTV, phoneTV, addressTV, instaTV;
    private Button btn;
    private StorageReference storageReference;
    private static final String UPLOADS = "uploads/";

    public PersonProfile() throws InterruptedException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        email = MainActivity.email;

        imUser    = findViewById(R.id.personImageView);
        nameTV    = findViewById(R.id.nameTextView);
        emailTV   = findViewById(R.id.emailTextview);
        phoneTV   = findViewById(R.id.phoneText);
        addressTV = findViewById(R.id.addressText);
        instaTV   = findViewById(R.id.instegramText);
        btn       = findViewById(R.id.linksBtn);

                storageReference = FirebaseStorage.getInstance().getReference().child(UPLOADS + user.imageName);
                try {
                    File imgFile =File.createTempFile("profile", ".jpg");
                    storageReference.getFile(imgFile).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getPath());
                            imUser.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(PersonProfile.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            nameTV.setText(user.fullName);
            emailTV.setText(email);
            phoneTV.setText(user.phone);
            addressTV.setText(user.address);
            instaTV.setText(user.instegram);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(PersonProfile.this,Links.class));

                }
            });

    }
}