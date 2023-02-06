package com.example.projectedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.projectedb.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SqlClass sql;
    private  String titol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sql = new SqlClass(this);

        refrescar();

        binding.buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Comentario c = new Comentario(binding.titol.getText().toString(),binding.comentario.getText().toString());
                sql.addComent(c);
                binding.titol.setText("");
                binding.comentario.setText("");

                refrescar();
            }
        });

        binding.buttonver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comentario c=sql.getComentario(titol);
                binding.titolver.setText(c.getTitol());
                binding.comentariover.setText(c.getComentario());

            }
        });

        binding.buttoneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql.eliminar(titol);
                titol="";
                binding.titolver.setText("");
                binding.comentariover.setText("");

                refrescar();
            }
        });

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                titol=adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void refrescar(){
        ArrayList<String> comentarios=sql.getComentarios();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, comentarios);
        binding.spinner.setAdapter(adapter);
    }
}