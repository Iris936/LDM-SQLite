package com.iris.ldm_sqlite.ViewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.iris.ldm_sqlite.DAO.PersonaDAO;
import com.iris.ldm_sqlite.Entidades.Personas;
import com.iris.ldm_sqlite.DAO.PersonaDAO;
import com.iris.ldm_sqlite.Database.PersonaDatabase;
import com.iris.ldm_sqlite.Entidades.Personas;
import java.util.List;
public class PersonaViewModel extends AndroidViewModel {
    private PersonaDAO personaDAO;
    private LiveData<List<Personas>> listaDePersonas;

    public PersonaViewModel(Application application) {
        super(application);
        PersonaDatabase database = PersonaDatabase.getInstance(application);
        personaDAO = database.personaDAO();
        listaDePersonas = personaDAO.obtenerTodasLasPersonas();
    }
    public void deletePersona(Personas persona) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.deletePersona(persona);
            }
        }).start();
    }
    public void updatePersona(Personas persona) {
        // Actualizar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.updatePersona(persona);
            }
        }).start();
    }

    public LiveData<List<Personas>> getListaDePersonas() {
        return listaDePersonas;
    }

    public void insertPersona(Personas persona) {
        // Insertar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Insert(persona);
            }
        }).start();
    }
}

