package com.example.guessnumber.UI;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

/**
 * Clase que maneja lo necesario para crear un menu aboutUs
 */
public class AboutUsActivity extends AppCompatActivity {
    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumber";
    //endregion

    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DE LA ACTIVIDAD
    /**
     * Método que se ejecuta cuando se crea la Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setName(getResources().getString(R.string.aboutUsCreator))
                .setSubTitle(getResources().getString(R.string.aboutUsSubTittle))
                .setBrief(getResources().getString(R.string.aboutUsBrief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(getResources().getString(R.string.aboutUsCreator))
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();
        setContentView(view);
        Log.d(TAG, "AboutUsActivity -> onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "AboutUsActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "AboutUsActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "AboutUsActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "AboutUsActivity -> onStop()");
    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "AboutUsActivity -> onDestroy()");
    }
    //endregion
    //endregion
}