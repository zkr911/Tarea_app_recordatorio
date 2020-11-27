package com.nilson.apptres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityNameMedicamento extends AppCompatActivity {


    Button btnsiguiente;
    String nombremedicamento;

AutoCompleteTextView autocompletmedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_medicamento);
        autocompletmedicamento = findViewById(R.id.autocompletmedicamento);
        btnsiguiente = findViewById(R.id.btnsiguiente);
        String[] medicamentos = getResources().getStringArray(R.array.medicamentos);
        final AutoCompleteTextView autocompletado = findViewById(R.id.autocompletmedicamento);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,medicamentos);
        autocompletado.setAdapter(adapter);





btnsiguiente.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        nombremedicamento = autocompletado.getText().toString();

        Toast.makeText(ActivityNameMedicamento.this,"Medicina ingresada  : "+ nombremedicamento,Toast.LENGTH_SHORT).show();

        Intent VerAgregarHora = new Intent(ActivityNameMedicamento.this,AgregarHoraActivity.class);
        VerAgregarHora.putExtra("Nombremedi",nombremedicamento);
        startActivity(VerAgregarHora);

    }
});








    }
}