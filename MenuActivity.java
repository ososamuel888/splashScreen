package com.cuna.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ArrayList<Category> category= new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       //fillArray();
        //lv.setAdapter(adapter);

        new ConsultarTiendas().execute();

    }

    /*private void fillArray() {

        category.add(new Category("Doña Pelos","Tienda Express"));
        category.add(new Category("Oxxo","Recargas"));

    }*/


    class ConsultarTiendas extends AsyncTask<Void, Integer, JSONArray>{



        @Override
        protected JSONArray doInBackground(Void... voids) {

            URLConnection connection= null;
            JSONArray jsonArray=null;


            try {


                connection =
                        new URL("http://172.18.26.67/cursoAndroid/vista/Tienda/obtenerTiendas" +
                                ".php").openConnection();

                InputStream inputStream= (InputStream) connection.getContent();

                byte[] buffer= new byte[10000];
                int size= inputStream.read(buffer);

                jsonArray= new JSONArray(new String(buffer, 0, size));


            }catch(Exception e){

                e.printStackTrace();

            }

            return jsonArray;

        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {

            super.onPostExecute(jsonArray);
            Category mycategory= null;

            for (int i=0;i<jsonArray.length();i++){

                try {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    mycategory= new Category(jsonObject.getInt("idtienda"),jsonObject.getString(
                            "nombre"),jsonObject.getString("descripcion"),jsonObject.getString(
                                    "direccion"),jsonObject.getDouble("latitud"),
                            jsonObject.getDouble("longitud"));

                    Log.i("cadena",mycategory.getId()+"");
                    Log.i("cadena",jsonObject.getString(
                            "nombre")+"");
                    Log.i("cadena",jsonObject.getString("direccion")+"");
                    Log.i("cadena",jsonObject.getDouble("latitud")+"");
                    Log.i("cadena",jsonObject.getDouble("longitud")+"");
                    Log.i("cadena",jsonObject.getString("descripcion")+"");

                    category.add(mycategory);

                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }
            AdapterCategory adapter;
            ListView lv = (ListView) findViewById(R.id.lstTiendas);
            adapter= new AdapterCategory(MenuActivity.this,category);
            lv.setAdapter(adapter);

        }
    }


}
