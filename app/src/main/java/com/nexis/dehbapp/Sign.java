package com.nexis.dehbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign extends AppCompatActivity {

    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    public Button btnkayit;
    public Button bt9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        editEmail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        editSifre = (EditText) findViewById(R.id.editTextTextPassword2);
        mAuth = FirebaseAuth.getInstance();
        btnkayit = (Button) findViewById(R.id.btnkayit);

        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitOL();
            }
        });


    }

    private void kayitOL() {
        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();



        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)) {
            mAuth.createUserWithEmailAndPassword(txtEmail, txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                                Toast.makeText(Sign.this, "Kayıt İşlemi Başarılı.", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(Sign.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else
            Toast.makeText(this, "Email ve Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();


    }
}






