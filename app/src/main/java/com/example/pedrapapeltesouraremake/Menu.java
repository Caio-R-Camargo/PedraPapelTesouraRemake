package com.example.pedrapapeltesouraremake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView voltar, progressText, celularModelo;
    ImageView iniciante, avancado, profissional, mestre, platina;
    ProgressBar progressBarNivel;
    boolean inicianteT, avancadoT, profissionalT, mestreT;
    int progressoBarInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iniciante = findViewById(R.id.inicianteTrofeu);
        avancado = findViewById(R.id.avancadoTrofeu);
        profissional = findViewById(R.id.profissionalTrofeu);
        mestre = findViewById(R.id.mestreTrofeu);
        platina = findViewById(R.id.platinaTrofeu);
        voltar = findViewById(R.id.voltar);
        celularModelo = findViewById(R.id.modelCelular);
        progressText = findViewById(R.id.progressText);
        progressBarNivel = findViewById(R.id.progressBarNivel);
        progressoBarInt = 0;

        String produto = Build.MANUFACTURER;
        String modelo = Build.MODEL;

        Bundle dados = getIntent().getExtras();

        inicianteT = dados.getBoolean("trofeuIniciante");
        avancadoT = dados.getBoolean("trofeuAvancado");
        profissionalT = dados.getBoolean("trofeuProfissional");
        mestreT = dados.getBoolean("trofeuMestre");

        progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());
        celularModelo.setText(produto + "-" + modelo);

        if(inicianteT && avancadoT && profissionalT && mestreT){
            iniciante.setImageResource(R.drawable.trofeu_bronze);
            avancado.setImageResource(R.drawable.trofeu_prata);
            profissional.setImageResource(R.drawable.trofeu_ouro);
            mestre.setImageResource(R.drawable.trofeu_ouro);
            platina.setImageResource(R.drawable.trofeu_platina);
            progressoBarInt++;
            progressBarNivel.setProgress(progressoBarInt);
            progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());

        }
        if(inicianteT){
            iniciante.setImageResource(R.drawable.trofeu_bronze);
            progressoBarInt++;
            progressBarNivel.setProgress(progressoBarInt);
            progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());
        }
        if(avancadoT){
            avancado.setImageResource(R.drawable.trofeu_prata);
            progressoBarInt++;
            progressBarNivel.setProgress(progressoBarInt);
            progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());
        }
        if(profissionalT){
            profissional.setImageResource(R.drawable.trofeu_ouro);
            progressoBarInt++;
            progressBarNivel.setProgress(progressoBarInt);
            progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());
        }
        if(mestreT){
            mestre.setImageResource(R.drawable.trofeu_ouro);
            progressoBarInt++;
            progressBarNivel.setProgress(progressoBarInt);
            progressText.setText(progressBarNivel.getProgress() + "/"+ progressBarNivel.getMax());
        }



        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}