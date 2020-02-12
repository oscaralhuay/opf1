package com.example.pablo.opf1;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button);
        Toast.makeText(getApplicationContext(),"en camino",Toast.LENGTH_LONG).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"adentro",Toast.LENGTH_LONG).show();
                agregarUsuario();
            }
        });
    }

    public Connection conexionBD() {
        Connection conexion=null;
        Toast.makeText(getApplicationContext(),"vamos",Toast.LENGTH_LONG).show();

        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.mysql.jtds.jdbc.Driver").newInstance();
            Toast.makeText(getApplicationContext(),"ingresando",Toast.LENGTH_LONG).show();
            conexion= DriverManager.getConnection("jdbc:jtdc:sqlserver://192.168.0.1:3306;databaseName=prueba;user=root;password=;");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"error"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return conexion;
    }

    public void agregarUsuario() {
        try{
            PreparedStatement pst=conexionBD().prepareStatement("insert into cliente values(?,?)");
            pst.setString(1,email.getText().toString());
            pst.setString(2,password.getText().toString());
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(),"error"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}