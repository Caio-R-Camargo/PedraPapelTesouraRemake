package com.example.pedrapapeltesouraremake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    ImageView iniciante, avancado, profissional, mestre, platina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iniciante = findViewById(R.id.inicianteTrofeu);
        avancado = findViewById(R.id.avancadoTrofeu);
        profissional = findViewById(R.id.profissionalTrofeu);
        mestre = findViewById(R.id.mestreTrofeu);
        platina = findViewById(R.id.platinaTrofeu);

        boolean inicianteT = false;
        boolean avancadoT = false;
        boolean profissionalT = false;
        boolean mestreT = false;

        Bundle dados = getIntent().getExtras();

        inicianteT = dados.getBoolean("trofeuIniciante");
        avancadoT = dados.getBoolean("trofeuAvancado");
        profissionalT = dados.getBoolean("trofeuProfissional");
        mestreT = dados.getBoolean("trofeuMestre");



        if(inicianteT == true && avancadoT == true && profissionalT == true && mestreT == true){
            iniciante.setImageResource(R.drawable.trofeu_bronze);
            avancado.setImageResource(R.drawable.trofeu_prata);
            profissional.setImageResource(R.drawable.trofeu_ouro);
            mestre.setImageResource(R.drawable.trofeu_ouro);
            platina.setImageResource(R.drawable.trofeu_platina);


        }else{
            if(inicianteT == true){
                iniciante.setImageResource(R.drawable.trofeu_bronze);
            }
            if(avancadoT == true){
                avancado.setImageResource(R.drawable.trofeu_prata);
            }
            if(profissionalT == true){
                profissional.setImageResource(R.drawable.trofeu_ouro);
            }
            if(mestreT == true){
                mestre.setImageResource(R.drawable.trofeu_ouro);
            }

        }

    }


}