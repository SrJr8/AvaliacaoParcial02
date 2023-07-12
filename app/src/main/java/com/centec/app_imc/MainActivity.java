package com.centec.app_imc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        EditText infPeso;
        EditText infAltura;
        Button btCalcular;
        TextView Resultado;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            infPeso = findViewById(R.id.infPeso);
            infAltura = findViewById(R.id.infAltura);
            btCalcular = findViewById(R.id.btCalcular);
            Resultado = findViewById(R.id.Resultado);

            btCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularIMC();
                }
            });
        }

            public void calcularIMC() {

            String pPeso = infPeso.getText().toString();
            String aAltura = infAltura.getText().toString();

            if (!pPeso.isEmpty() && !aAltura.isEmpty()) {
               float peso = Float.parseFloat(pPeso);
               float altura = Float.parseFloat(aAltura);

                float IMC = peso / (altura * altura);

                String classificacao = null;
                if (IMC < 18.5) {
                    classificacao = "Abaixo do peso";
                } else if (IMC < 24.9) {
                    classificacao = "Peso normal";
                } else if (IMC < 29.9) {
                    classificacao = "Excesso de peso";
                } else if (IMC < 34.9) {
                    classificacao = "Obesidade Classe 1";
                } else if (IMC < 39.9) {
                    classificacao = "Obesidade Classe 2";
                } else if (IMC >= 40) {
                    classificacao = "Obesidade Classe 3";
                 }

                String resultado = "Seu IMC é " + IMC + "\nClassificação: " + classificacao;
                Resultado.setText(resultado);
            }
        }
    }

