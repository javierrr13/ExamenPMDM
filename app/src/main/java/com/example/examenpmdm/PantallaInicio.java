package com.example.examenpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class PantallaInicio extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallainicio);

    }
    public void irMainActivity (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void cerrarAplicacion (View v){

        finish();

    }



}
