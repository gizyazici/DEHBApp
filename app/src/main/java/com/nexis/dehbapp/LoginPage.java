package com.nexis.dehbapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    public Button bt6;
    public Button bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page1);
        editEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editSifre = (EditText) findViewById(R.id.editTextTextPassword);
        mAuth = FirebaseAuth.getInstance();
        bt6 = (Button) findViewById(R.id.bt6);
        bt8 = (Button) findViewById(R.id.bt8);

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                girisYap();

            }
        });


        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginPage.this, Sign.class));
            }
        });

    }

    public void girisYap() {

        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();


        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)) {
            mAuth.signInWithEmailAndPassword(txtEmail, txtSifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser();
                            Intent main = new Intent(LoginPage.this, MainActivity.class);
                            startActivity(main);

                        }

                    }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        } else
            Toast.makeText(this, "Email ve Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();


    }
}

