package com.example.esqueleto_kianart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.esqueleto_kianart.adapter.ImagenAdapter;
import com.example.esqueleto_kianart.entity.Imagen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColeccionActivity extends AppCompatActivity {
    private List<Imagen> imagenes;
    private ImagenAdapter imagenAdapter;

    @BindView(R.id.listImagenesColeccion)
    ListView listViewImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleccion);
        ButterKnife.bind(this);
        cargarInformacion();
        imagenAdapter = new ImagenAdapter(this, imagenes);
        listViewImagenes.setAdapter(imagenAdapter);
        listViewImagenes.setClickable(true);
        listViewImagenes.setOnItemClickListener((parent, view, position, id) -> {
            Imagen imagenSeleccionada = (Imagen) listViewImagenes.getItemAtPosition(position);
            goToVerImagenActivity(view, imagenSeleccionada);
        });
    }

    private void goToVerImagenActivity(View view, Imagen imagenSeleccionada) {
        Intent intent = new Intent(this, VerImagenActivity.class);
        intent.putExtra("idImagen", imagenSeleccionada.getIdImagen());
        startActivity(intent);
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }


    private void cargarInformacion(){
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(6, R.drawable.imagen1, 1));
        imagenes.add(new Imagen(16, R.drawable.imagen2, 2));
        imagenes.add(new Imagen(9, R.drawable.imagen3, 3));
    }
}