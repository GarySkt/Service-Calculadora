package com.example.redbackpack.eduardo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzar_acticidad_evento(View view){
        Intent intent = new Intent(this,Evento.class);
        startActivity(intent);
    }

    public void lanzar_acticidad_necesario_secundario(View view){
        Intent intent = new Intent(this,Necesario_Secundario.class);
        startActivity(intent);
    }

    public void lanzar_indispensable (View view){
        Intent intent = new Intent(this,Indispensable.class);
        startActivity(intent);
    }
}
