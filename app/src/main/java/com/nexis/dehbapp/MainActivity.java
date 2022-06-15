package com.nexis.dehbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Button btnOyun;
    public Button btnSkor;
    public Button btnGorev;
    public Button btnMedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOyun = findViewById(R.id.btnOyun);
        btnSkor = findViewById(R.id.btnSkor);
        btnGorev = findViewById(R.id.btnGorev);
        btnMedi = findViewById(R.id.btnMedi);

        btnOyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent oyun = new Intent(MainActivity.this, MiniOyun.class);
                startActivity(oyun);
            }});

            btnSkor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    startActivity(new Intent(MainActivity.this, SkorlarActivity.class));
                }


        });
        btnGorev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                startActivity(new Intent(MainActivity.this, Gorevler.class));
            }


        });

        btnMedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                startActivity(new Intent(MainActivity.this, Meditasyon.class));
            }


        });

    }
}
