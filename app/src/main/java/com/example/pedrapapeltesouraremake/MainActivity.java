
package com.example.pedrapapeltesouraremake;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    TextView resultadoJogada, scoreJogador, scoreBot, nivel, menu;
    ImageView starJogador, starOponente, iniciante, avancado, profissional, mestre, jogadaApp, platina;
    int scoreValor, scoreValorBot;
    boolean trofeuIni, trofeuAvan, trofeuPro, trofeuMest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView versionApp = findViewById(R.id.version);
        versionApp.setText("ver" + BuildConfig.VERSION_NAME);

        initial();

    }

    public void initial(){
        menu = findViewById(R.id.bottomMenu);
        iniciante = findViewById(R.id.inicianteTrofeu);
        avancado = findViewById(R.id.avancadoTrofeu);
        profissional = findViewById(R.id.profissionalTrofeu);
        mestre = findViewById(R.id.platinaTrofeu);
        jogadaApp = findViewById(R.id.jogadaApp);
        resultadoJogada = findViewById(R.id.resultado);
        scoreJogador = findViewById(R.id.score);
        scoreValor = Integer.parseInt(String.valueOf(scoreJogador.getText()));
        scoreBot = findViewById(R.id.pontuacao_int_oponente);
        scoreValorBot = Integer.parseInt(String.valueOf(scoreBot.getText()));
        nivel = findViewById(R.id.nivelJogador);
        starJogador = findViewById(R.id.starJogador);
        starOponente = findViewById(R.id.starOponente);
        platina = findViewById(R.id.platina);
        scoreValor = 0;
        scoreValorBot = 0;

        //Alerta para quando o usuario entrar
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Aviso");
        dialog.setMessage("Este Software foi desenvolvido para fins de estudo, podendo haver erros e alguns componentes podem não funcionar corretamente. Agradeço desde já a compreensão.");
        dialog.setCancelable(true);
        dialog.setIcon( android.R.drawable.ic_popup_reminder);
        dialog.setPositiveButton("Ok" , new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create();
        dialog.show();

        Intent intent = new Intent(getApplicationContext(), Menu.class);

        //Ir para Conquistas
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validação de troféus
                if(trofeuIni){
                    intent.putExtra("trofeuIniciante", true);
                }
                if(trofeuAvan){
                    intent.putExtra("trofeuAvancado", true);
                }
                if(trofeuPro){
                    intent.putExtra("trofeuProfissional", true);
                }
                if(trofeuMest){
                    intent.putExtra("trofeuMestre", true);
                }
                if(!trofeuIni){
                    intent.putExtra("trofeuIniciante", false);
                }
                startActivity(intent);

            }
        });

    }

    public void scoreValidacaoTrofeu(){

        if(scoreValor == 1){
            trofeuIni = true;
        }
        if(scoreValor == 2){
            trofeuAvan = true;
        }
        if(scoreValor == 3){
            trofeuPro = true;
        }
        if(scoreValor == 4){
            trofeuMest = true;
            platina.setVisibility(View.VISIBLE);
        }

    }

    public void scoreNivel(){

        switch (scoreValor){
            case 0:
                nivel.setText("Nenhum.");
                break;

            case 1:
                nivel.setText("Iniciante.");
                break;

            case 2:
                nivel.setText("Avançado.");
                break;

            case 3:
                nivel.setText("Profissional.");
                break;

            case 4:
                nivel.setText("MESTRE!");
                break;
        }

        //Tornar a estrela visivel para quem está ganhando
        if(scoreValorBot > scoreValor){
            starOponente.setVisibility(View.VISIBLE);
            starJogador.setVisibility(View.INVISIBLE);
        }else{
            starJogador.setVisibility(View.VISIBLE);
            starOponente.setVisibility(View.INVISIBLE);
        }

    }

    public void pedraJogada   (View view) {
        this.opcaoSelecionada ("Pedra");
    }
    public void papelJogada   (View view) {
        this.opcaoSelecionada ("Papel");
    }
    public void tesouraJogada (View view) {
        this.opcaoSelecionada ("Tesoura");
    }

    @SuppressLint("ResourceAsColor")
    public void opcaoSelecionada (String opcaoSelecionada){

        int numeroAleatorio = new Random().nextInt(3);
        String[] opcoes = {"Pedra" , "Papel" , "Tesoura"};
        String opcaoApp = opcoes[numeroAleatorio];

        switch (opcaoApp){
            case "Pedra":
                jogadaApp.setImageResource(R.drawable.pedra_icon);
                break;

            case "Papel":
                jogadaApp.setImageResource(R.drawable.papel_icon);
                break;

            case "Tesoura":
                jogadaApp.setImageResource(R.drawable.tesoura_icon);
                break;

        }

        if(
                (opcaoApp.equals("Pedra") && opcaoSelecionada.equals("Tesoura")) ||
                (opcaoApp.equals("Papel") && opcaoSelecionada.equals("Pedra"))  ||
                (opcaoApp.equals("Tesoura") && opcaoSelecionada.equals("Papel"))

        ){

            resultadoJogada.setText("VOCÊ PERDEU!");
            resultadoJogada.setTextColor(Color.parseColor("#850000"));

            //verficação do valor para não ter numeros negativos
            if(scoreValor <= 0){
                scoreValorBot++;
                scoreNivel();
                scoreBot.setText(Integer.toString(scoreValorBot));
            }else{
                scoreValor--;
                scoreValidacaoTrofeu();
                scoreValorBot++;
                scoreNivel();
                scoreJogador.setText(Integer.toString(scoreValor));
                scoreBot.setText(Integer.toString(scoreValorBot));
            }

        }else if
        (
                (opcaoSelecionada.equals("Pedra") && opcaoApp.equals("Tesoura")) ||
                (opcaoSelecionada.equals("Papel") && opcaoApp.equals("Pedra")) ||
                (opcaoSelecionada.equals("Tesoura") && opcaoApp.equals("Papel"))

        ){

            resultadoJogada.setText("VOCÊ GANHOU!");
            resultadoJogada.setTextColor(Color.parseColor("#FF03DAC5"));
            scoreValor++;
            scoreValidacaoTrofeu();
            //verficação do valor para não ter numeros negativos
            if(scoreValorBot <= 0){
                scoreBot.setText(Integer.toString(scoreValorBot));
            }else{
                scoreValorBot--;
                scoreBot.setText(Integer.toString(scoreValorBot));
            }

            scoreNivel();
            scoreJogador.setText(Integer.toString(scoreValor));


        }else{
            resultadoJogada.setText("EMPATE!");
            resultadoJogada.setTextColor(Color.parseColor("#696969"));
        }

    }

    //Rede Social
    public void linkedinRedir(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/caio-camargo-developer/")));

    }


}
