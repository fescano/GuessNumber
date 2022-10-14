package com.example.guessnumber.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.R;
import com.example.guessnumber.data.User;
import com.example.guessnumber.databinding.ActivityEndPlayBinding;

/**
 * Clase que maneja la Activity EndPlayActivity y muestra la última pantalla de la Application
 */
public class EndPlayActivity extends AppCompatActivity {
    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumber";
    private ActivityEndPlayBinding binding;
    private User user;
    //endregion

    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DE LA ACTIVIDAD
    /**
     * Método que se ejecuta cuando se crea la Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        if(savedInstanceState!=null)
            user = savedInstanceState.getParcelable("user");
        else
            user = bundle.getParcelable("user");
        binding.setUser(user);
        fin();
        binding.btFinish.setOnClickListener(view -> restart());
        Log.d(TAG, "EndPlayActivity -> onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "EndPlayActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "EndPlayActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "EndPlayActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "EndPlayActivity -> onStop()");
    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "EndPlayActivity -> onDestroy()");
    }
    //endregion

    /**
     * Este método guarda el valor de la respuesta seleccionada por el usuario antes de llamar al
     * método onDestroy() de la Activity
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("user", user);
        Log.d(TAG, "EndPlayActivity -> onSaveInstanceState()");
    }

    /**
     * Este método Callback escucha si se ha pulsado el botón back y cuando ocurre, nos retorna
     * a la primera Activity
     */
    @Override
    public void onBackPressed() {
        Log.d(TAG, "EndPlayActivity -> onBackPressed()");
        restart();
    }
    //endregion

    //region MÉTODOS
    /**
     * Este método nos devuelve a la primera Activity, ConfigActivity
     */
    private void restart() {
        Intent intent = new Intent(EndPlayActivity.this, ConfigActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * Este método comprueba las distintas condiciones de victoria para mostrar una vista u otra
     */
    private void fin() {
        if ((user.getIntentos() == user.getIntentosMax() - 1) && (user.getNumero() != user.getNumeroEscrito()))
            Texto(1);
        else
            Texto(0);
    }

    /**
     * Este método ajusta la vista de esta Activity segun el parámetro recibido: flag
     * @param flag Parámetro de tipo Integer que indica qué vista preparar
     */
    @SuppressLint("SetTextI18n")
    private void Texto(int flag)
    {
        if (flag == 1)
        {
            binding.tvFinalText.setTextColor(getColor(R.color.rojo));
            binding.tvFinalText.setText(R.string.tvFinalTextP);
        }
        else
        {
            binding.tvFinalText.setTextColor(getColor(R.color.verde));
            binding.tvFinalText.setText(R.string.tvFinalTextV);
        }
        binding.tvDesgloseText.setText(user.getName() + getString(R.string.tvDesgloseText1)
                + (user.getIntentos() + 1) + getString(R.string.tvDesgloseText2) + user.getIntentosMax()
                + getString(R.string.tvDesgloseText3)
                + user.getNumero());
    }
    //endregion
}
