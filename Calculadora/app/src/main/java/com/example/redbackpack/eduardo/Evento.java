package com.example.redbackpack.eduardo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Evento extends AppCompatActivity {

    private double porcentaje = 0.20;
    private double monto;
    private EditText eT_monto;
    private TextView tV_resultado;
    private Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        eT_monto = (EditText) findViewById(R.id.eT_monto);
        btn_calcular = (Button)findViewById(R.id.btn_calcular);
        tV_resultado = (TextView)findViewById(R.id.tV_resultado);

    }

    public void calcular_evento (View v){

        String sMonto =  eT_monto.getText().toString();
        monto = Integer.parseInt(sMonto);

        double res = monto * porcentaje;

        String resultado  = String.valueOf(res);

        tV_resultado.setText("S/. "+resultado);


    }


}
