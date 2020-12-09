package com.example.holamundo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.holamundo.entities.Contact;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private final static int PERMISOS=101;//clave para dar permisode llamada

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MY_APP","Main Cargada");
      //  Log.i("CICLO_DE_VIDA","onCreate");

        //Acceder al boton
       Button button=findViewById(R.id.bntSecondActivity);

       //Pasar datos de una actividad a otra
        String v="hola soy brayan";

        //creamos objeto para pasaarlo al second activity
        Contact contact=new Contact();
        contact.setId(1);
        contact.setName("Brayan M");


       //String txtButton=(String)button.getText();//obtenemos el texto del boton
        //Log.i("MY_APP","El texo nuevo es:"+ txtButton);
       //button.setText("Hacer algo");//cambiar el texo
       // darle comportamiento al boton
        Log.i("MY_APP","El valor de booton es: "+String.valueOf(button) );
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i("MY_APP","Clic en boton");
                Log.i("MY_APP","Abriendo Segunda actividad");
                //llamamos a la otra actividad?
               // Context context = MainActivity.this;//1ra formma, 1er Argumento
               // Context context = getApplicationContext();//2da forma, 1er Argumento
               // Class t = SecondActivity.class; 2do Argumento

               //El Intent comunica diferentes componentes como actividades e incluso otras app como calendario
                Intent intent=new Intent(MainActivity.this,SecondActivity.class); //2 argumentos anteriores
             /*   intent.putExtra("MI_CLAVE", v);//para pasar datos de una actividad a otra
                 intent.putExtra("MI_CLAVE_INT", 10);//para pasar datos de una actividad a otra
                intent.putExtra("MI_CLAVE_BOOL", false);//para pasar datos de una actividad a otra
               */
                //enviamos un objeto que lo transforma en string con Gson
                String contactString = new Gson().toJson(contact);
                intent.putExtra("MI_CLAVEOBJECT", contactString);

                startActivity(intent);

                //llamamos/ hacemos uso del permiso de llamadas
                /*if(TienePermisoParaLlamar()){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:978371482"));
                    startActivity(intent);
                }
                else{
                    SolicitarPermisosParaLamar();
                }*/
            }
        });

        Button finalAnd = findViewById(R.id.Final);
        finalAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Final_Activity.class);
                startActivity(intent);
            }
        });

    }

    private void SolicitarPermisosParaLamar(){
        Log.i("MY_APP","Solicitar permiso");
        String[] permisos=new String[]  {Manifest.permission.CALL_PHONE}; //Arreglo de permisos PODEMOS PONER MAS PERMISOS
        ActivityCompat.requestPermissions(this, permisos, PERMISOS);//3 parametros una es la constante int PERMISOS=101
    }

    private boolean TienePermisoParaLlamar(){
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
    }


    /*
    //OnCreate y demas xd ppts
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CICLO_DE_VIDA","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CICLO_DE_VIDA","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CICLO_DE_VIDA","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CICLO_DE_VIDA","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CICLO_DE_VIDA","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CICLO_DE_VIDA","onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("CICLO_DE_VIDA","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("CICLO_DE_VIDA","onRestoreInstanceState");
    }
    */
}