package com.iris.ldm_sqlite.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.iris.ldm_sqlite.DAO.PersonaDAO;
import com.iris.ldm_sqlite.Entidades.Personas;
@Database(entities = {Personas.class}, version = 1)
public abstract class PersonaDatabase extends RoomDatabase {
    private static PersonaDatabase instance;
    public abstract PersonaDAO personaDAO();
    public static synchronized PersonaDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            PersonaDatabase.class, "personasdb")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
