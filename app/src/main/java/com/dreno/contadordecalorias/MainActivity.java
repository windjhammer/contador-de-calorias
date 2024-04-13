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
        //insert de teste
        //db.insert("comidas", "comida_id, comida_nome, comida_produtor", "NULL , 'Presunto', 'Sadia'");

        //criação das comidas na tabela
        db.insert("comidas", "comida_id, comida_nome, comida_produtor, comida_porcao, comida_medidor_de_porcao, comida_calorias, comida_calorias_calculado",
                                            "NULL, 'Ovo, inteiro, cozido', 'Natural', '136.0', 'g', '211', '211'");
        //db.close();

        Toast.makeText(this, "Banco de dados comidas foi criado.", Toast.LENGTH_LONG).show();
    }
}