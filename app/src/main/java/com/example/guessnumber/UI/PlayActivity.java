package com.example.guessnumber.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.R;
import com.example.guessnumber.data.User;
import com.example.guessnumber.databinding.ActivityPlayBinding;

/**
 * Clase que maneja la Activity PlayActivity y muestra la segunda pantalla de la Application
 */
public class PlayActivity extends AppCompatActivity{
    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumber";
    private ActivityPlayBinding binding;
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
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btRetry.setEnabled(false);
        Bundle bundle = getIntent().getExtras();
        if(savedInstanceState!=null) //Viene de un cambio de configuracion
            user = savedInstanceState.getParcelable("user");
        else
            user = bundle.getParcelable("user");
        binding.btInput.setOnClickListener(view -> guess());
        binding.btRetry.setOnClickListener(view -> clear());
        Log.d(TAG, "PlayActivity -> onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "PlayActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "PlayActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PlayActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "PlayActivity -> onStop()");
    }

    /*
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "PlayActivity -> onDestroy()");
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
        Log.d(TAG, "PlayActivity -> onSaveInstanceState()");
    }
    //endregion

    //region MÉTODOS
    /**
     * Este método recoge y comprueba si el número escrito por el usuario es el número correcto
     * y si no ha gastado todos sus intentos, si se cumple alguna de las condiciones, adivina el
     * número o gasta sus intentos, llama a un método auxiliar startEnding() para lanzar la
     * última actividad
     */
    private void guess() {
        binding.btInput.setEnabled(false);
        binding.etInput.setEnabled(false);
        binding.btRetry.setEnabled(true);
        if (user.getIntentos() == (user.getIntentosMax()- 1))
            startEnding();
        if (binding.etInput.getText().toString().equals(""))
        {
            user.setNumeroEscrito(0);
            user.setIntentos(user.getIntentos() + 1);
            Toast.makeText(this, getResources().getString(R.string.intentosRestantes) + ((user.getIntentosMax()) - user.getIntentos()), Toast.LENGTH_SHORT).show();
        }
        else
        {
            user.setNumeroEscrito(Integer.parseInt(binding.etInput.getText().toString()));
            if (user.getNumeroEscrito() != user.getNumero())
            {
                if (user.getNumeroEscrito() > user.getNumero())
                    binding.tvMessage.setText(getResources().getString(R.string.tvMessageMayor));
                else if (user.getNumeroEscrito() < user.getNumero())
                    binding.tvMessage.setText(getResources().getString(R.string.tvMessageMenor));
                user.setIntentos(user.getIntentos() + 1);
                Toast.makeText(this, getResources().getString(R.string.intentosRestantes) + ((user.getIntentosMax()) - user.getIntentos()), Toast.LENGTH_SHORT).show();
            }
            else
                startEnding();
        }
    }

    /**
     * Este método vacía los textos de la vista y habilita e inhabilita los botones
     */
    private void clear() {
        binding.etInput.setText("");
        binding.tvMessage.setText("");
        binding.btInput.setEnabled(true);
        binding.etInput.setEnabled(true);
        binding.btRetry.setEnabled(false);
    }

    /**
     * Este método lanza EndPlayActivity con un bundle que contiene a user
     */
    private void startEnding()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", user);
        Intent intent = new Intent(PlayActivity.this, EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //endregion
}
