package com.example.pablo.opf1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class Menu extends Activity {

    Button datosPersonales,movimientos,transferencias,pagosYServicios,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        datosPersonales=(Button) findViewById(R.id.buttonDP);
        movimientos=(Button) findViewById(R.id.buttonM);
        transferencias=(Button) findViewById(R.id.buttonT);
        pagosYServicios=(Button) findViewById(R.id.buttonPS);
        salir=(Button) findViewById(R.id.buttonS);
        
        datosPersonales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos = new Intent(v.getContext(),DatosPersonales.class);
                startActivity(datos);
            }
        });
        movimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movi = new Intent(v.getContext(),Movimientos.class);
                startActivity(movi);
            }
        });
        transferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tran= new Intent(v.getContext(),Transferencias.class);
                startActivity(tran);
            }
        });
        pagosYServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pag= new Intent(v.getContext(),PagosYServicios.class);
                startActivity(pag);
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir= new Intent(v.getContext(),MainActivity.class);
                startActivity(salir);
            }
        });
    }

}
