package com.dreno.contadordecalorias;

import android.os.Bundle;
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
        db.insert("comidas", "comida_id, comida_nome, comida_produtor", "NULL , 'Presunto', 'Sadia'");
        db.close();

        Toast.makeText(this, "Banco de dados comidas foi criado.", Toast.LENGTH_LONG).show();
    }
}