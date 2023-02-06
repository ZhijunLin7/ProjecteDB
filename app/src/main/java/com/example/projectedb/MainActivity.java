package com.example.projectedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projectedb.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SqlClass sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sql = new SqlClass(this);
        binding.buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Comentario c = new Comentario(binding.titol.getText().toString(),binding.comentario.getText().toString());
                sql.addComent(c);

            }
        });

        binding.buttonver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Comentario> comentarios=sql.getComentarios();
                for (int i = 0; i <comentarios.size() ; i++) {
                    Log.d("testeo", "onClick: "+comentarios.get(i).toString());
                }
            }
        });
    }
}