package com.dreno.contadordecalorias;

import android.content.Context;

public class DBSetupInsert {

    private final Context context;

    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }

    public void setupInsertToComidas(String values){

        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("comidas", "comida_id, comida_nome, comida_produtor, comida_porcao, comida_medidor_de_porcao, comida_num_porcoes, comida_num_porcoes_nome, comida_calorias, comida_proteina, comida_carboidrato, comida_gordura, comida_calorias_calculado, comida_proteina_calculado, comida_carboidrato_calculado, comida_gordura_calculado, comida_usuario_id, comida_codigo_de_barras, comida_categoria_id, comida_miniatura, comida_imagem_a, comida_imagem_b, comida_imagem_c, comida_nota", values);
//        db.execSQL("INSERT INTO comidas (" + fields + ") VALUES (" + values + ")");


    }
}
