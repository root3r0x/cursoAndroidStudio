package com.example.root3r0x.testtwo;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaramos un boton
    Button siguiente ,hint , btnToast, btnA, btnB, btnImg;
    Toast toast;
    TextView txtVista;
    ImageView ivImg;

    boolean tx = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociamos el boton declarado con el del interface
        siguiente = (Button)findViewById(R.id.btnSiguiente);
        hint = (Button)findViewById(R.id.btnHint);
        btnToast = (Button)findViewById(R.id.btnToast);
        btnA = (Button)findViewById(R.id.btnA);
        btnB = (Button)findViewById(R.id.btnB);
        txtVista = (TextView)findViewById(R.id.lblTexto1); //Texto Rojo
        btnImg = (Button)findViewById(R.id.bntImg);
        ivImg = (ImageView)findViewById(R.id.imgViewImagen); //Imagen logo android

        //Habilitamos el onclicklistener
        btnToast.setOnClickListener(this);
        btnImg.setOnClickListener(this);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);

        //Asociamos el metodo con el boton
        siguiente.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    /*Metodo onclick del boton*/
                    public void onClick(View v) {
                        /*Codigo del boton para llamar a sumActivity */
                        Intent siguiente = new Intent(MainActivity.this,SumaDeNumeros.class);
                        startActivity(siguiente);
                    }
                }
        );

        hint.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent hint = new Intent(MainActivity.this,tercera_actividad.class);
                        startActivity(hint);
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        try
        {
            switch (v.getId()) {
                case R.id.btnToast:
                    Toast.makeText(getApplicationContext(), "Toast ejecutado xd", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bntImg:
                    Intent hint = new Intent(MainActivity.this, visor.class);
                    startActivity(hint);
                    break;
                case R.id.btnA:
                    if (tx == false) {
                        txtVista.setText("Se ha cambiado este texto xd");
                        tx = true;
                    } else {
                        txtVista.setText("Precione el boton para acceder a las opcionesd e la lampara :b ");
                        tx = false;
                    }
                    break;
                case R.id.btnB:
                    if (tx == false){
                        ivImg.setImageResource(R.drawable.mario);
                        tx= true;
                    }else{
                        ivImg.setImageResource(R.drawable.ic_launcher);
                        tx= false;
                    }
                    break;
                default:
                    break;

            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage().toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
