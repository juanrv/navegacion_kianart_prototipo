package com.example.esqueleto_kianart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esqueleto_kianart.R;
import com.example.esqueleto_kianart.entity.Imagen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImagenAdapter extends BaseAdapter {


    private List<Imagen> imagenes;
    private final LayoutInflater inflater;

    public ImagenAdapter(Context context, List<Imagen> images) {
        this.imagenes = images;
        inflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imagenes.size();
    }

    @Override
    public Imagen getItem(int i) {
        return imagenes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view != null){
            viewHolder = (ViewHolder) view.getTag();
        }
        else {
            view = inflater.inflate(R.layout.item_imagen,viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        viewHolder.imagen.setImageResource(imagenes.get(position).getImagen());
        String numeroMeGusta = String.valueOf(imagenes.get(position).getNumeroMeGusta());
        viewHolder.numeroMeGusta.setText(numeroMeGusta);

        return view;
    }

    class ViewHolder{

        @BindView(R.id.itemImagen)
        ImageView imagen;
        @BindView(R.id.txtMeGusta)
        TextView numeroMeGusta;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
