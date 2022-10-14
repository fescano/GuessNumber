package com.example.guessnumber.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.R;
import com.example.guessnumber.data.User;
import com.example.guessnumber.databinding.ActivityConfigBinding;

/**
 * <h1>Proyecto GuessNumber</h1>
 * En este proyecto se realizan las siguientes operaciones
 * <ol>
 *     <li>Crear varias Activity</li>
 *     <li>Enlazar el código con la vista mediante ViewBinding</li>
 *     <li>Enlazar la vista con un POJO mediante Databinding</li>
 *     <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 *     <li>Ver el ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de Actividades</li>
 * </ol>
 *
 * @author Fernando Escaño Martín
 * @version 1.0
 * @see
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */

/**
 * Clase que maneja la Activity ConfigActivity y muestra la primera pantalla de la Application
 */
public class ConfigActivity extends AppCompatActivity {

    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumber";
    private ActivityConfigBinding binding;
    //endregion

    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DE LA ACTIVIDAD

    /**
     * Método Callback que se ejecuta cuandose crea la Activity
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de esta
     *                           Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btSend.setOnClickListener(view -> play());
        if(savedInstanceState!=null) //Viene de un cambio de configuracion
            binding.setUser(savedInstanceState.getParcelable("user"));
        else
            binding.setUser(new User());
        Log.d(TAG, "ConfigActivity -> onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ConfigActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ConfigActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ConfigActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ConfigActivity -> onStop()");
    }

    /**
     * Método Callback que se ejecuta cuando se quiere destruir la Activity actual
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ConfigActivity -> onDestroy()");
    }
    //endregion
    /**
     *  Este método callback crea el menú de opciones en la vista. Se devuelve true para indicar al
     *  SO que se ha realizado la opcion de modificar el menú.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una dee las opciones del menú de la
     * aplicación
     * @param item
     * @return
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_aboutus:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    //endregion

    //region MÉTODOS
    /**
     * Método que comprueba si los EditText no estan vacios y de que uno de ellos solo contiene
     * números, ademas de lanzar PlayActivity mediante un intent con su bundle
     */
    public void play() {
        if (!TextUtils.isEmpty(binding.etMessage.getText().toString()) && !TextUtils.isEmpty(binding.etUser.getText().toString())) {
            if (Integer.parseInt(binding.etMessage.getText().toString()) > 0) {
                Bundle bundle = new Bundle();
                binding.getUser().setNumero((int)Math.floor(Math.random()*(100-1+1)+1));
                binding.getUser().setIntentos(0);
                binding.getUser().setNumeroEscrito(0);
                bundle.putParcelable("user", binding.getUser());
                Intent intent = new Intent(ConfigActivity.this, PlayActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            } else {
                Toast.makeText(this, getResources().getString(R.string.menorQueCero), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.setnumber), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este método guarda el valor de la respuesta seleccionada por el usuario antes de llamar al
     * método onDestroy() de la Activity
     * @param outState
     */
     @Override
     protected void onSaveInstanceState(@NonNull Bundle outState) {
     super.onSaveInstanceState(outState);
     outState.putParcelable("user", binding.getUser());
     Log.d(TAG, "ConfigActivity -> onSaveInstanceState()");
     }
     //endregion
}