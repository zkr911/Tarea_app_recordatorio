package com.nilson.apptres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptadorlista extends RecyclerView.Adapter<adaptadorlista.ViewHolderDatos> {

    private ArrayList<lista> Listadedatos;

    public adaptadorlista(ArrayList<lista> listadedatos) {
        Listadedatos = listadedatos;
    }

    @NonNull
    @Override
    public adaptadorlista.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reycler_item_lista,null,false);



        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorlista.ViewHolderDatos holder, int position) {


        holder.cargardatos(Listadedatos.get(position));

    }

    @Override
    public int getItemCount() {
        return  Listadedatos.size();
    }





    public class ViewHolderDatos extends RecyclerView.ViewHolder {


        TextView textViewfechainicial,textViewfechatermino,textViewhora;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            textViewfechainicial = itemView.findViewById(R.id.textViewfechainicial);
            textViewfechatermino = itemView.findViewById(R.id.textViewfechatermino);
            textViewhora = itemView.findViewById(R.id.textViewhora);


        }

        public void cargardatos(lista informacionDatos){

            textViewfechainicial.setText(informacionDatos.getFechainicial());
            textViewfechatermino.setText(informacionDatos.getFechafinal());
            textViewhora.setText(informacionDatos.getAlarma());
        }

    }






}
