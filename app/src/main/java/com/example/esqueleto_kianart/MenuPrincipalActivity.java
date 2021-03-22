package com.example.esqueleto_kianart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void goToActivitySubir(View view) {
        Intent intent = new Intent(this, SubirImagenActivity.class);
        startActivity(intent);
    }

    public void goToActivityMiColeccion(View view) {
        Intent intent = new Intent(this, ColeccionActivity.class);
        startActivity(intent);
    }

    public void goToActivityExplorar(View view) {
        Intent intent = new Intent(this, ExplorarActivity.class);
        startActivity(intent);
    }

    public void goToActivityMisImagenes(View view) {
        Intent intent = new Intent(this, MisImagenesActivity.class);
        startActivity(intent);
    }
}