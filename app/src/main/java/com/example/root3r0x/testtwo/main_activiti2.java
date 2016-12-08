package com.example.root3r0x.testtwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("WrongConstant")
public class main_activiti2 extends AppCompatActivity implements View.OnClickListener
{
    private TextView getTitulo, getMsg;
    private Button btnLeer, btnRegresar;
    String titulo, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activiti2);

        getTitulo = (TextView)findViewById(R.id.tvgetTitulo);
        getMsg = (TextView)findViewById(R.id.tvgetContent);
        btnLeer = (Button)findViewById(R.id.btnLeer);
        btnRegresar = (Button)findViewById(R.id.btnActivdad);

        //Escuchadores
        btnLeer.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);

    }

    public  void alerta(String alerta)
    {
        Toast.makeText(getApplicationContext(), alerta, Toast.LENGTH_SHORT).show();
    }

    protected void setText(String tit, String Message)
    {
        this.getTitulo.setText(tit);
        this.getMsg.setText(Message);
    }

    protected void getData()
    {
        try
        {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                titulo = (String) bundle.get("TITULO");
                msg = (String) bundle.get("MENSAGE");
                this.setText(titulo, msg);
            }
        }
        catch (Exception ex)
        {
            this.alerta(ex.getMessage().toString());
        }
    }

    @Override
    public void onClick(View v)
    {
        try
        {
            switch (v.getId())
            {
                case R.id.btnLeer:
                    this.getData();
                    break;
                case R.id.btnActivdad:
                     /*Codigo del boton para llamar a sumActivity */
                    Intent siguiente = new Intent(main_activiti2.this,tercera_actividad.class);
                    startActivity(siguiente);
                    break;
            }
        }
        catch (Exception ex)
        {
            this.alerta(ex.getMessage().toString());
        }
    }
}