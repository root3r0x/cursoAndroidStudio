package com.example.root3r0x.testtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class visor extends AppCompatActivity implements View.OnClickListener {

    /*Lista Imagenes */
    ImageView ivPrincipal, alt, anon, daft, dron, game, ganesh, bear, skul, smile;
    Toast toast;
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //Imagenes con sus vistas
        alt         = (ImageView)findViewById(R.id.ivAlt);
        anon        = (ImageView)findViewById(R.id.ivAnon);
        daft        = (ImageView)findViewById(R.id.ivPunk);
        dron        = (ImageView)findViewById(R.id.ivDrone);
        game        = (ImageView)findViewById(R.id.ivGame);
        ganesh      = (ImageView)findViewById(R.id.ivGanesha);
        bear        = (ImageView)findViewById(R.id.ivOso);
        skul        = (ImageView)findViewById(R.id.ivSkull);
        smile       = (ImageView)findViewById(R.id.ivSmile);
        ivPrincipal = (ImageView)findViewById(R.id.ivPrincipal) ;
        titulo      = (TextView)findViewById(R.id.txtTitulo);

        //Escuchadores
        alt.setOnClickListener(this);
        anon.setOnClickListener(this);
        daft.setOnClickListener(this);
        dron.setOnClickListener(this);
        game.setOnClickListener(this);
        ganesh.setOnClickListener(this);
        bear.setOnClickListener(this);
        skul.setOnClickListener(this);
        smile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try
        {
            switch (v.getId()) {
                case R.id.ivAnon:
                    titulo.setText("No olvidamos no perdonamos, esperenos.. ");
                    ivPrincipal.setImageResource(R.drawable.anonymous);
                    break;
                case R.id.ivPunk:
                    titulo.setText("One more time..");
                    ivPrincipal.setImageResource(R.drawable.daftpunk);
                    break;
                case R.id.ivDrone:
                    titulo.setText("Drone");
                    ivPrincipal.setImageResource(R.drawable.drone);
                    break;
                case R.id.ivGame:
                    titulo.setText("8bits games rules!");
                    ivPrincipal.setImageResource(R.drawable.gamming);
                    break;
                case R.id.ivGanesha:
                    titulo.setText("No words..");
                    ivPrincipal.setImageResource(R.drawable.ganesha);
                    break;
                case R.id.ivOso:
                    titulo.setText("Help me..");
                    ivPrincipal.setImageResource(R.drawable.oso);
                    break;
                case R.id.ivSkull:
                    titulo.setText("I got you..");
                    ivPrincipal.setImageResource(R.drawable.skull);
                    break;
                case R.id.ivSmile:
                    titulo.setText("Be happy.. Don't worry");
                    ivPrincipal.setImageResource(R.drawable.sonrisa);
                    break;
                case R.id.ivAlt:
                    titulo.setText("Ok ??");
                    ivPrincipal.setImageResource(R.drawable.altavoz);
                    break;
                default:
                    break;
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}