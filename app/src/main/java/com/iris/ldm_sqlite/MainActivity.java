package com.iris.ldm_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.iris.ldm_sqlite.ViewModel.AgregarPersonaActivity;
import com.iris.ldm_sqlite.ViewModel.MostrarListaActivity;

public class MainActivity extends AppCompatActivity {

    private Button AgregarPersona;
    private Button MostrarLista;
    private Button AcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AgregarPersona = findViewById(R.id.AggPersona);
        MostrarLista = findViewById(R.id.MostrarLis);
        AcercaDe = findViewById(R.id.AcercaDe);

        AgregarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, AgregarPersonaActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("AgregarPersonaActivity", "Error al guardar persona: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        });

        MostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarListaActivity.class);
                startActivity(intent);
            }

        });

        AcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }

        });
    }
}