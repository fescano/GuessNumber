package com.example.guessnumber;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Clase que maneja la Aplicación
 */
public class GuessNumberApplication extends Application {
    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DE LA ACTIVIDAD
    /**
     * Método que se ejecuta cuando se crea la Activity
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto Application");
    }
    //endregion
    //endregion
}