package com.example.root3r0x.testtwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class tercera_actividad extends AppCompatActivity implements View.OnClickListener {

    //Elementos para las actividades
    Button menu, btnEnviar;
    EditText etMsg , etTitulo;
    String titulo, msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_actividad);

        //Asociamos elementos
        etMsg         = (EditText) findViewById(R.id.editText);
        menu        = (Button)findViewById(R.id.btnmenu);
        etTitulo      = (EditText)findViewById(R.id.tvwText);
        btnEnviar   = (Button)findViewById(R.id.btnEnviar);


        //Escuchadores
        menu.setOnClickListener(this);
        btnEnviar.setOnClickListener(this);

        //Creamos el evento
    }

    public  void alerta(String alerta)
    {
        Toast.makeText(getApplicationContext(), alerta, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v)
    {
        try {
            switch (v.getId())
            {
                case R.id.btnmenu:
                    Intent hint = new Intent(tercera_actividad.this,MainActivity.class);
                    startActivity(hint);
                    break;

                case R.id.btnEnviar:
                    this.validaDatos(etTitulo, etMsg);
                    break;
            }
        }
        catch(Exception ex)
        {
           this.alerta(ex.getMessage().toString());
        }
    }


    protected void validaDatos(EditText et1,EditText et2)
    {
        try
        {
            titulo = etTitulo.getText().toString();
            msg = etMsg.getText().toString();

            if (titulo.isEmpty() && msg.isEmpty()) {
                this.alerta("Debes rellenar los campos");
            }
            else
            {
                if (titulo.isEmpty()) {
                    this.alerta("Agrega un titulo antes de enviar");
                }
                if (msg.isEmpty()) {
                    this.alerta("Agrega tu mensaje");
                }
            }
            if(titulo.length() > 0 && msg.length() > 0)
            {
                this.alerta("Enviando..");
                /*Codigo del boton para llamar a sumActivity */
                Intent siguiente = new Intent(tercera_actividad.this,main_activiti2.class);
                //Nombre y el dato
                siguiente.putExtra("TITULO", this.titulo);
                siguiente.putExtra("MENSAGE",this.msg);

                startActivity(siguiente);
            }

        }
        catch(Exception ex)
        {
            this.alerta(ex.getMessage().toString());
        }
    }

}
