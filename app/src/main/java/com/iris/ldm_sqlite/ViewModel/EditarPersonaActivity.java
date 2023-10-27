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

public class EditarPersonaActivity extends AppCompatActivity {

    private EditText Nombre, Apellido, Edad;
    private PersonaViewModel personaViewModel;
    private Personas personaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        Nombre = findViewById(R.id.Nombre);
        Apellido = findViewById(R.id.Apellido);
        Edad = findViewById(R.id.Edad);
        Button btnGuardar = findViewById(R.id.BotonGuardar);

        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);

        // Obtener la persona actual de la actividad anterior
        personaActual = (Personas) getIntent().getSerializableExtra("persona");

        // Verificar si la persona actual es nula
        if (personaActual != null) {
            Nombre.setText(personaActual.nombrePersona);
            Apellido.setText(personaActual.apellidoPersona);
            Edad.setText(String.valueOf(personaActual.edadPersona));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                String apellido = Apellido.getText().toString();
                int edad = Integer.parseInt(Edad.getText().toString());

                if (personaActual != null) {
                    // Actualizar la información de la persona actual
                    personaActual.nombrePersona = nombre;
                    personaActual.apellidoPersona = apellido;
                    personaActual.edadPersona = edad;

                    // Actualizar en la base de datos
                    personaViewModel.updatePersona(personaActual);

                    finish(); // Cierra la actividad después de guardar.
                }
            }
        });
    }
}
