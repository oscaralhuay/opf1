package com.example.pablo.opf1;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SesionFragment extends Fragment implements Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;

    EditText cajaUser, cajaPass;
    Button ingresar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista= inflater.inflate(R.layout.fragment_sesion, container, false);
        cajaUser=(EditText) vista.findViewById(R.id.user);
        cajaPass=(EditText) vista.findViewById(R.id.password);
        ingresar= (Button) vista.findViewById(R.id.button);
        rq= Volley.newRequestQueue(getContext());
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"no se encontro el usuario"+error.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        User usuario=new User();
        Toast.makeText(getContext(), "se ha encontrado el usuario"+cajaUser.getText().toString(),Toast.LENGTH_LONG).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject=null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
            usuario.setUser(jsonObject.optString("user"));
            usuario.setPwd(jsonObject.optString("pwd"));
            usuario.setName(jsonObject.optString("names"));
            //Toast.makeText(getContext(),"entramos datos"+jsonArray,Toast.LENGTH_LONG).show();
            Intent volver= new Intent(getContext(),Menu.class);
            startActivity(volver);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
        }
    }

    private void iniciarSesion() {
        String url ="http://192.168.0.31/bancoOPF/sesion.php?user="+cajaUser.getText().toString()+"&pwd="+cajaPass.getText().toString();
       // Toast.makeText(getContext(),url,Toast.LENGTH_LONG).show();
        jrq = new JsonObjectRequest(Request.Method.GET,url, null, this, this);
        rq.add(jrq);

    }
}
