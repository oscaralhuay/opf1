package com.example.pablo.opf1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario, new SesionFragment()).commit();
    }
}




        /*
        findViewById(R.id.btnEjecutar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new MiAsyncTask().execute();
                Intent ListSong = new Intent(getApplicationContext(), Login.class);
                startActivity(ListSong);
            }
        });*/


   /* private class MiAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            return RESTService.makeGetRequest(
                    " https://jsonplaceholder.typicode.com/posts/1 " );
        }
        @Override
        protected void onPostExecute(String result) {

            Toast notificacion = Toast.makeText (
                    getApplicationContext(), result, Toast. LENGTH_LONG );
            notificacion.show();
        }
    }*/

