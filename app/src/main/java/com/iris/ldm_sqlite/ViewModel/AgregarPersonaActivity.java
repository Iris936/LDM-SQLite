package com.iris.ldm_sqlite.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.iris.ldm_sqlite.R;
import com.iris.ldm_sqlite.Entidades.Personas;
import com.iris.ldm_sqlite.R;
import com.iris.ldm_sqlite.ViewModel.PersonaViewModel;

public class AgregarPersonaActivity extends AppCompatActivity {

    private EditText Nombre, Apellido, Edad;
    private PersonaViewModel personaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        Nombre = findViewById(R.id.Nombre);
        Apellido = findViewById(R.id.Apellido);
        Edad = findViewById(R.id.Edad);
        Button btnGuardar = findViewById(R.id.BotonGuardar);

        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                String apellido = Apellido.getText().toString();
                int edad = Integer.parseInt(Edad.getText().toString());

                Personas persona = new Personas();
                persona.nombrePersona = nombre;
                persona.apellidoPersona = apellido;
                persona.edadPersona = edad;

                personaViewModel.insertPersona(persona);

                finish(); // Cierra la actividad después de guardar.
            }
        });
    }
}
