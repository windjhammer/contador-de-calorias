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

        //db.close();
    }

    public void insertAllComidas(){
        setupInsertToComidas("NULL, 'Amendoim Mendorato', 'Santa Helena', '27', 'g', '1', 'pct', '138', '4.6', '12', '8', NULL, NULL, NULL, NULL, NULL, NULL, '42', 'mendorato_thumb.jpg', 'mendorato_a.jpg', 'mendorato_b.jpg', 'mendorato_c.jpg', NULL");
        setupInsertToComidas("NULL, 'Maçã', 'Turma da Mônica', '100', 'g', '1', 'unidade', '52', '0.3', '14', '0.2', NULL, NULL, NULL, NULL, NULL, NULL, '123', 'maca_thumb.jpg', 'maca_a.jpg', 'maca_b.jpg', 'maca_c.jpg', NULL");
        setupInsertToComidas("NULL, 'Frango Grelhado', 'Sadia', '100', 'g', '1', 'porção', '165', '31', '0', '3.6', NULL, NULL, NULL, NULL, NULL, NULL, '456', 'frango_thumb.jpg', 'frango_a.jpg', 'frango_b.jpg', 'frango_c.jpg', NULL");
        setupInsertToComidas("NULL, 'Arroz Integral Cozido', 'Tio João', '100', 'g', '1', 'porção', '111', '2.6', '23', '0.8', NULL, NULL, NULL, NULL, NULL, NULL, '789', 'arroz_thumb.jpg', 'arroz_a.jpg', 'arroz_b.jpg', 'arroz_c.jpg', NULL");
        setupInsertToComidas("NULL, 'Abacate', 'Fazenda Abacates Deliciosos', '100', 'g', '1', 'unidade', '160', '2', '9', '14', NULL, NULL, NULL, NULL, NULL, NULL, '321', 'abacate_thumb.jpg', 'abacate_a.jpg', 'abacate_b.jpg', 'abacate_c.jpg', NULL");
        setupInsertToComidas("NULL, 'Iogurte Natural', 'Nestlé', '100', 'g', '1', 'porção', '61', '3.5', '4.7', '3.3', NULL, NULL, NULL, NULL, NULL, NULL, '654', 'iogurte_thumb.jpg', 'iogurte_a.jpg', 'iogurte_b.jpg', 'iogurte_c.jpg', NULL");
        
    }
}
