package com.example.redbackpack.eduardo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Indispensable extends AppCompatActivity {

    EditText eT_Asientos_indispensable;
    EditText eT_entradA;
    EditText eT_entradB;
    EditText eT_entradC;

    Spinner spinner_porcentaje;
    Spinner spinner_uso_entrada;
    Spinner spinner_dias_uso_musica;

    Button btn_calcular_indispensable;

    TextView tV_resultadoindispensable;

    double porcentaje_indispensable=0;
    double totalentrada;
    double diasusomusica;
    double resultadototalindispensable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indispensable);

        spinner_porcentaje = (Spinner)findViewById(R.id.spinner_porcentaje);
        String []porcentaje = {"60%","70%","80%"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,porcentaje);
        spinner_porcentaje.setAdapter(adapter);

        spinner_uso_entrada = (Spinner)findViewById(R.id.spinner_costo_entrada);
        String []usocostoentrada = {"Si","No - 3 VUM"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,usocostoentrada);
        spinner_uso_entrada.setAdapter(adapter1);

        spinner_dias_uso_musica = (Spinner)findViewById(R.id.spinner_dias_uso_musica);
        String []usomusica = {"02 dias a la semana - 09 dias al Mes",
                                "03 dias a la semana - 13 dias al Mes",
                                "04 dias a la semana - 18 dias al Mes",
                                "05 dias a la semana - 22 dias al Mes",
                                "06 dias a la semana - 25 dias al Mes",
                                "07 dias a la semana - 30 dias al Mes"};
        ArrayAdapter<String> adaptaerdias = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,usomusica);
        spinner_dias_uso_musica.setAdapter(adaptaerdias);

        eT_Asientos_indispensable = (EditText)findViewById(R.id.eT_Asientos_indispensable);
        eT_entradA = (EditText)findViewById(R.id.eT_entradaA);
        eT_entradB = (EditText)findViewById(R.id.eT_entradaB);
        eT_entradC = (EditText)findViewById(R.id.eT_entradaC);
        tV_resultadoindispensable = (TextView)findViewById(R.id.tV_resultadoindispensable);

        btn_calcular_indispensable = (Button)findViewById(R.id.btn_calcular_indispensale);

    }

    public void calcular_indispensable (View view){

        String asiento_indispensable = eT_Asientos_indispensable.getText().toString();
        int ai = Integer.parseInt(asiento_indispensable);




        //spinner porcentaje

        String sporcentaje = spinner_porcentaje.getSelectedItem().toString();

        if (sporcentaje.equals("60%")){

            porcentaje_indispensable = 0.6;

        } else if (sporcentaje.equals("70%")){

            porcentaje_indispensable = 0.7;

        }else if (sporcentaje.equals("80%")){

            porcentaje_indispensable = 0.8;

        }

        //spinner uso de entrada

        String susoentrada = spinner_uso_entrada.getSelectedItem().toString();

        if (susoentrada.equals("Si")){

            String entradA = eT_entradA.getText().toString();
            int eA = Integer.parseInt(entradA);
            String entradB = eT_entradB.getText().toString();
            int eB = Integer.parseInt(entradB);
            String entradC = eT_entradC.getText().toString();
            int eC = Integer.parseInt(entradC);



            totalentrada = (eA + eB + eC) * 0.5;

        }else if (susoentrada.equals("No - 3 VUM")){

            totalentrada = 7.5 * 0.8;

        }

        //spinner dias uso musica

        String diasuso = spinner_dias_uso_musica.getSelectedItem().toString();

        if (diasuso.equals("02 dias a la semana - 09 dias al Mes")){

            diasusomusica = 9;
        }else if (diasuso.equals("03 dias a la semana - 13 dias al Mes")){

            diasusomusica = 13;

        }else if (diasuso.equals("04 dias a la semana - 18 dias al Mes")){

            diasusomusica = 18;

        }else if (diasuso.equals("05 dias a la semana - 22 dias al Mes")){

            diasusomusica = 22;

        }else if (diasuso.equals("06 dias a la semana - 25 dias al Mes")){

            diasusomusica = 25;

        }else if (diasuso.equals("07 dias a la semana - 30 dias al Mes")){

            diasusomusica = 30;

        }


        resultadototalindispensable = (ai * porcentaje_indispensable) * totalentrada * diasusomusica;
        tV_resultadoindispensable.setText("S/. "+ resultadototalindispensable);


    }
}
