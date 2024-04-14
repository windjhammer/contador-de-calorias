package com.dreno.contadordecalorias;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.dreno.contadordecalorias.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter db = new DBAdapter(this);
        db.open();

        // Contador de colunas na tabela comidas
        int numberRows = db.contadorDeNotasGravadas("comidas");

        if (numberRows < 1) {
            Toast.makeText(this, "Carregando...", Toast.LENGTH_LONG).show();
            DBSetupInsert setupInsert = new DBSetupInsert(this);
            setupInsert.insertAllComidas();
            setupInsert.insertAllCategorias();
            Toast.makeText(this, "Carregado.", Toast.LENGTH_LONG).show();

        }

        //checar se o usuário está logado
        numberRows = db.contadorDeNotasGravadas("usuarios");
        if(numberRows < 1){
            Toast.makeText(this, "precisa logar", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }

        // db.close();
    }
}
