package com.nilson.apptres;

import android.content.Intent;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkManager;

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
    public void onBindViewHolder(@NonNull final adaptadorlista.ViewHolderDatos holder, final int position) {


        holder.cargardatos(Listadedatos.get(position));

    }


    @Override
    public int getItemCount() {
        return  Listadedatos.size();
    }








    public class ViewHolderDatos extends RecyclerView.ViewHolder {


        TextView textViewfechainicial,textViewfechatermino,textViewhora;

        TextView textViewmedicamento;

        Button btndelete;



        public ViewHolderDatos(@NonNull final View itemView) {
            super(itemView);

            textViewfechainicial = itemView.findViewById(R.id.textViewfechainicial);
            textViewfechatermino = itemView.findViewById(R.id.textViewfechatermino);
            textViewhora = itemView.findViewById(R.id.textViewhora);

            textViewmedicamento = itemView.findViewById(R.id.textViewmedicamento);


            btndelete = itemView.findViewById(R.id.btndelete);







            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Listadedatos.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    //eliminar("tag1");


                }
            });


        }

        public void cargardatos(lista informacionDatos){

            textViewfechainicial.setText(informacionDatos.getFechainicial());
            textViewfechatermino.setText(informacionDatos.getFechafinal());
            textViewhora.setText(informacionDatos.getAlarma());

            textViewmedicamento.setText(informacionDatos.getNmedicamento());



        }

    }

    private void eliminar(String tag){

        //WorkManager.getInstance(this).cancelAllWorkByTag(tag);
        //Toast.makeText(adaptadorlista.this,"Alarma eliminada",Toast.LENGTH_SHORT).show();

    }




}
