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

        //Contador de colunas na tabela comidas
        int numberRows = db.contadorDeNotasGravadas("comidas");

        if (numberRows < 1){
            db.insert("comidas", "comida_id, comida_nome, comida_produtor, comida_porcao, comida_medidor_de_porcao, comida_calorias, comida_calorias_calculado",
                    "NULL, 'Ovo, inteiro, cozido', 'Natural', '136.0', 'g', '211', '211'");
        }

        DBSetupInsert setupInsert = new DBSetupInsert(this);
        setupInsert.setupInsertToComidas("NULL, 'Amendoim Mendorato', 'Santa Helena', '27', 'g', '1', 'pct', '138', '4.6', '12', '8', NULL, NULL, NULL, NULL, NULL, NULL, '42', 'mendorato_thumb.jpg', 'mendorato_a.jpg', 'mendorato_b.jpg', 'mendorato_c.jpg', NULL");
        db.close();
    }
}