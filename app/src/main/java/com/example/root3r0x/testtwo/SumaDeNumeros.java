package com.example.root3r0x.testtwo;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SumaDeNumeros extends AppCompatActivity {

    //Declaro el imageview
    Button anterior , interruptor;
    Camera cam;
    boolean flash=false;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        //botones
        anterior = (Button) findViewById(R.id.btnContador);
        interruptor = (Button)findViewById(R.id.btnInterruptor);

        //Eventos onclick
        interruptor.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Codigo de la lampara
                if (flash==false){
                    //Evento de la camara
                    cam = Camera.open();
                    Camera.Parameters parameters = cam.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    cam.setParameters(parameters);
                    cam.startPreview();
                    flash=true;
                    Toast.makeText(getApplicationContext(), "Flash Encendido", Toast.LENGTH_SHORT).show();

                }
                else {
                    //codigo para camara
                    cam.stopPreview();
                    cam.release();
                    flash = false;
                    Toast.makeText(getApplicationContext(), "Flash Apagado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anterior = new Intent(SumaDeNumeros.this, MainActivity.class);
                startActivity(anterior);
            }
        });
    }
}
