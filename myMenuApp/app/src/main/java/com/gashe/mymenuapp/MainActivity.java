package com.gashe.mymenuapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(MainActivity.this, view);
                p.getMenuInflater().inflate(R.menu.menu_layour, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Log.d(getClass().getCanonicalName(), "Boton Tocado: "+item.getTitle());
                        return true;
                    }
                });
                p.show();

            }
        });*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout linear = new LinearLayout(MainActivity.this);
                TextView textview = new TextView(MainActivity.this);
                textview.setText("Texto del textview");
                linear.addView(textview);

                Toast toast = new Toast(MainActivity.this);
                toast.setView(linear);
                toast.show();


                /*Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.alert_dialog);
                dialog.show();*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //CREAR MENUS

        /*MenuItem mi = menu.add(Menu.NONE, 1, 1, "Hola");
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mxcircuit.es"));
        //mi.setIntent(intent);
        menu.add(Menu.NONE, 2, 2, "Adios");
        SubMenu sb = menu.addSubMenu(Menu.NONE, 4, 4, "Submenu");
        sb.add(Menu.NONE, 5, 5, "TOCAR");*/

        //INFLAMOS MENU

        getMenuInflater().inflate(R.menu.menu_layour, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(getClass().getCanonicalName(), "Menu Tocado: "+item.getTitle().toString());
        Log.d(getClass().getCanonicalName(), "Menu Tocado: "+item.getItemId());
        return true;
    }*/

    // switch de cada boton

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Salir");
        ad.setMessage("¿Seguro que quieres salir?");
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        ad.show();
    }
}
