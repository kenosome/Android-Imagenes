package com.cali.uao.imagenes;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    ImageView galeria;
    TextView titulo;
    int[] imagenes;
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galeria=(ImageView) findViewById(R.id.galeria);
        titulo=(TextView) findViewById(R.id.titulo);

        int foto1=R.drawable.foto2;
        indice=0;
        imagenes=new int[3];

        imagenes[0]=R.drawable.foto1;
        imagenes[1]=R.drawable.foto2;
        imagenes[2]=R.drawable.foto3;

        galeria.setBackgroundResource(imagenes[indice]);
        indice++;

        //TouchListener
        galeria.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                galeria.animate().setDuration(500).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        //La accion que debe ocurrir luego del fading
                        galeria.setBackgroundResource(imagenes[indice]);
                        indice++;

                        if (indice>2){
                            indice=0;
                        }

                        galeria.animate().alpha(1).setDuration(500);
                    }
                });





                Toast.makeText(getApplicationContext(),"Tap",Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }




}
