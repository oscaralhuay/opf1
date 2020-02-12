package com.example.pablo.opf1;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PagosYServicios extends Activity implements Response.Listener<JSONObject>, Response.ErrorListener {

        RequestQueue rq;
        JsonRequest jrq;

        EditText cuenta,importe,tipo;
        Button button;





    // Toast.makeText(getApplicationContext(),"no se registro"+error.toString(),Toast.LENGTH_SHORT).show();


       //@Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

           // super.onCreate(savedInstanceState);
            cuenta = (EditText) findViewById(R.id.cuenta);
            importe = (EditText) findViewById(R.id.importe);
            tipo = (EditText) findViewById(R.id.tipo);
            button = (Button) findViewById(R.id.button);
            rq = Volley.newRequestQueue(getApplicationContext());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cargarDatos();
                }
            });
        return inflater.inflate(R.layout.activity_pagos_yservicios,container,false);
        }

       // @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),"no se registro"+error.toString(),Toast.LENGTH_SHORT).show();
        }

       // @Override
        public void onResponse(JSONObject response) {

            Toast.makeText(getApplicationContext(), "se ha registro"+cuenta.getText().toString(),Toast.LENGTH_LONG).show();
            limpiarCaja();
        }

        private void cargarDatos() {
            String url ="http://192.168.0.31/bancoOPF/sesion.php?cuenta="+cuenta.getText().toString()+"&importe="+importe.getText().toString()+"&tipo="+tipo.getText().toString();
            jrq = new JsonObjectRequest(Request.Method.GET,url, null, this, this);
            rq.add(jrq);

        }

        void limpiarCaja() {
            cuenta.setText("");
            importe.setText("");
            tipo.setText("");
        }
}
