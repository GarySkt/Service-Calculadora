package com.example.redbackpack.eduardo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Necesario_Secundario extends AppCompatActivity {

    Spinner spinner_incidencia_musical;
    Spinner spinner_medio_ejecucion;

    EditText eT_asientos;
    EditText eT_horas_dia;
    EditText eT_dias_mes;

    TextView tV_resultado_n_s;

    private double valor_unidad_musical = 2.5;
    private double porcentaje = 0.6;
    public double valor_incidencia_musical=0;
    public double valor_medio_ejecucion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necesario__secundario);

        spinner_incidencia_musical = (Spinner)findViewById(R.id.spinner_nivel_incidencia_musical);
        String []opcionesincidencia = {"Necesaria - (0.8)","Secundaria - (0.35)"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcionesincidencia);
        spinner_incidencia_musical.setAdapter(adapter);

        spinner_medio_ejecucion = (Spinner)findViewById(R.id.spinner_medio_ejecucion);
        String []opcionesmedioejecucion = {"Humano - (0.04)","Audio - Video (0.03)"};
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcionesmedioejecucion);
        spinner_medio_ejecucion.setAdapter(adapter1);

        eT_asientos = (EditText)findViewById(R.id.eT_asientos);
        eT_horas_dia = (EditText)findViewById(R.id.eT_horas_dia);
        eT_dias_mes = (EditText)findViewById(R.id.eT_dias_mes);

        tV_resultado_n_s = (TextView)findViewById(R.id.tV_resultado_n_s);
    }

    public void calcular_n_s (View view){

        double resultadofinal;

        String asientos = eT_asientos.getText().toString();
        int asientox = Integer.parseInt(asientos);

        String horas_dia = eT_horas_dia.getText().toString();
        int hd = Integer.parseInt(horas_dia);

        String dias_mes = eT_dias_mes.getText().toString();
        int dm = Integer.parseInt(dias_mes);


        //spinner incidencia musical

        String selectspinnerincidencia = spinner_incidencia_musical.getSelectedItem().toString();
        if (selectspinnerincidencia.equals("Necesaria - (0.8)")){

            valor_incidencia_musical = 0.8;

        }else if (selectspinnerincidencia.equals("Secundaria - (0.35)")){
            valor_incidencia_musical = 0.35;
        }

        //spinner medio ejecucion

        String selectspinnermedioejecucion = spinner_medio_ejecucion.getSelectedItem().toString();
        if (selectspinnermedioejecucion.equals("Humano - (0.04)")){

            valor_medio_ejecucion = 0.04;

        }else if (selectspinnermedioejecucion.equals("Audio - Video (0.03)")){
            valor_medio_ejecucion = 0.03;
        }

        resultadofinal = valor_unidad_musical * valor_incidencia_musical * (asientox * porcentaje) * (hd * dm) * valor_medio_ejecucion;

        tV_resultado_n_s.setText("S/. "+resultadofinal);

    }
}
