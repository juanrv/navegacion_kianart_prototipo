package com.example.esqueleto_kianart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

import com.example.esqueleto_kianart.adapter.ImagenAdapter;
import com.example.esqueleto_kianart.entity.Imagen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MisImagenesActivity extends AppCompatActivity {
    @BindView(R.id.listImagenesMisTrabajos)
    ListView listViewMisImagenes;


    private List<Imagen> imagenes;
    private ImagenAdapter imagenAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_imagenes);
        ButterKnife.bind(this);
        cargarInformacion();
        imagenAdapter = new ImagenAdapter(this, imagenes);
        listViewMisImagenes.setAdapter(imagenAdapter);
        listViewMisImagenes.setClickable(true);
        listViewMisImagenes.setOnItemClickListener((parent, view, position, id) -> {
            Imagen imagenSeleccionada = (Imagen) listViewMisImagenes.getItemAtPosition(position);
            goToVerImagenActivity(view, imagenSeleccionada);
        });
        listViewMisImagenes.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle(R.string.confirm);
            builder.setMessage(R.string.confirm_message_eliminar_imagen);
            builder.setPositiveButton(R.string.confirm_action, (dialog, which) -> {
                eliminarImagen(position);
            });
            builder.setNegativeButton(R.string.cancelar, (dialog, which) ->  dialog.cancel() );
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        });
    }

    private void eliminarImagen (int position){
        if(imagenes != null && imagenes.size() > 0){
            imagenes.remove(position);
        }
        imagenAdapter.notifyDataSetChanged();
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