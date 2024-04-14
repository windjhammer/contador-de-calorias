package com.dreno.contadordecalorias;

import android.content.Context;

public class DBSetupInsert {

    private final Context context;

    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }

    public void setupInsertToCategorias(String values) {
        DBAdapter db = new DBAdapter(context);
        db.open();
        db.insert("categorias", "categoria_id, categoria_nome, categoria_parent_id, categoria_icone, categoria_nota",
                values);
    }

    public void insertAllCategorias() {
        setupInsertToCategorias("NULL, 'Pães', '0', '', NULL");
        setupInsertToCategorias("NULL, 'Pão', '1', '', NULL");
        setupInsertToCategorias("NULL, 'Cereais', '1', '', NULL");
        setupInsertToCategorias("NULL, 'Frutas, Legumes e Vegetais', '0', '', NULL");
        setupInsertToCategorias("NULL, 'Carne, Frango e Peixe', 0, '', NULL");
        setupInsertToCategorias("NULL, 'Bebidas', 0, '', NULL");
        setupInsertToCategorias("NULL, 'Queijos', 0, '', NULL");

    }

    public void setupInsertToComidas(String values) {

        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("comidas",
                "comida_id, comida_nome, comida_produtor, comida_porcao, comida_medidor_de_porcao, comida_num_porcoes, comida_num_porcoes_nome, comida_calorias, comida_proteina, comida_carboidrato, comida_gordura, comida_calorias_calculado, comida_proteina_calculado, comida_carboidrato_calculado, comida_gordura_calculado, comida_usuario_id, comida_codigo_de_barras, comida_categoria_id, comida_miniatura, comida_imagem_a, comida_imagem_b, comida_imagem_c, comida_nota",
                values);

        // db.close();
    }

    public void insertAllComidas() {
        setupInsertToComidas(
                "NULL, 'Amendoim Mendorato', 'Santa Helena', '27', 'g', '1', 'pct', '138', '4.6', '12', '8', NULL, NULL, NULL, NULL, NULL, NULL, '42', 'mendorato_thumb.jpg', 'mendorato_a.jpg', 'mendorato_b.jpg', 'mendorato_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Maçã', 'Turma da Mônica', '100', 'g', '1', 'unidade', '52', '0.3', '14', '0.2', NULL, NULL, NULL, NULL, NULL, NULL, '123', 'maca_thumb.jpg', 'maca_a.jpg', 'maca_b.jpg', 'maca_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Frango Grelhado', 'Sadia', '100', 'g', '1', 'porção', '165', '31', '0', '3.6', NULL, NULL, NULL, NULL, NULL, NULL, '456', 'frango_thumb.jpg', 'frango_a.jpg', 'frango_b.jpg', 'frango_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Arroz Integral Cozido', 'Tio João', '100', 'g', '1', 'porção', '111', '2.6', '23', '0.8', NULL, NULL, NULL, NULL, NULL, NULL, '789', 'arroz_thumb.jpg', 'arroz_a.jpg', 'arroz_b.jpg', 'arroz_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Abacate', 'Fazenda Abacates Deliciosos', '100', 'g', '1', 'unidade', '160', '2', '9', '14', NULL, NULL, NULL, NULL, NULL, NULL, '321', 'abacate_thumb.jpg', 'abacate_a.jpg', 'abacate_b.jpg', 'abacate_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Iogurte Natural', 'Nestlé', '100', 'g', '1', 'porção', '61', '3.5', '4.7', '3.3', NULL, NULL, NULL, NULL, NULL, NULL, '654', 'iogurte_thumb.jpg', 'iogurte_a.jpg', 'iogurte_b.jpg', 'iogurte_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Banana', 'Fazenda Bananas Doces', '100', 'g', '1', 'unidade', '89', '1.1', '23', '0.3', NULL, NULL, NULL, NULL, NULL, NULL, '111', 'banana_thumb.jpg', 'banana_a.jpg', 'banana_b.jpg', 'banana_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Salada de Frutas', 'Mercado ABC', '150', 'g', '1', 'porção', '70', '0.7', '17', '0.4', NULL, NULL, NULL, NULL, NULL, NULL, '222', 'saladafrutas_thumb.jpg', 'saladafrutas_a.jpg', 'saladafrutas_b.jpg', 'saladafrutas_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Cenoura', 'Fazenda Legumes Frescos', '100', 'g', '1', 'unidade', '41', '0.9', '10', '0.2', NULL, NULL, NULL, NULL, NULL, NULL, '333', 'cenoura_thumb.jpg', 'cenoura_a.jpg', 'cenoura_b.jpg', 'cenoura_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Salmão Grelhado', 'Peixaria Mar Fresco', '100', 'g', '1', 'porção', '208', '20', '0', '13', NULL, NULL, NULL, NULL, NULL, NULL, '444', 'salmao_thumb.jpg', 'salmao_a.jpg', 'salmao_b.jpg', 'salmao_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Feijão Preto Cozido', 'Fazenda Feijões Saborosos', '100', 'g', '1', 'porção', '132', '6.9', '20', '0.5', NULL, NULL, NULL, NULL, NULL, NULL, '555', 'feijao_thumb.jpg', 'feijao_a.jpg', 'feijao_b.jpg', 'feijao_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Ovo Cozido', 'Granja Ovos Felizes', '50', 'g', '1', 'unidade', '77', '6.5', '0.6', '5.3', NULL, NULL, NULL, NULL, NULL, NULL, '666', 'ovo_thumb.jpg', 'ovo_a.jpg', 'ovo_b.jpg', 'ovo_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Iogurte de Morango', 'Danone', '150', 'g', '1', 'porção', '120', '3.6', '20', '3.6', NULL, NULL, NULL, NULL, NULL, NULL, '777', 'iogurtemorango_thumb.jpg', 'iogurtemorango_a.jpg', 'iogurtemorango_b.jpg', 'iogurtemorango_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Abacaxi', 'Fazenda Abacaxis Tropicais', '100', 'g', '1', 'unidade', '50', '0.5', '13', '0.1', NULL, NULL, NULL, NULL, NULL, NULL, '888', 'abacaxi_thumb.jpg', 'abacaxi_a.jpg', 'abacaxi_b.jpg', 'abacaxi_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Pão Integral', 'Padaria Pães Saudáveis', '50', 'g', '1', 'fatia', '130', '5', '22', '2', NULL, NULL, NULL, NULL, NULL, NULL, '999', 'pao_integral_thumb.jpg', 'pao_integral_a.jpg', 'pao_integral_b.jpg', 'pao_integral_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Espinafre Cozido', 'Horta Orgânica', '100', 'g', '1', 'porção', '23', '2.9', '3.6', '0.4', NULL, NULL, NULL, NULL, NULL, NULL, '101', 'espinafre_thumb.jpg', 'espinafre_a.jpg', 'espinafre_b.jpg', 'espinafre_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Batata Doce Assada', 'Fazenda Batatas Deliciosas', '150', 'g', '1', 'porção', '112', '2', '26', '0.1', NULL, NULL, NULL, NULL, NULL, NULL, '202', 'batatadoce_thumb.jpg', 'batatadoce_a.jpg', 'batatadoce_b.jpg', 'batatadoce_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Tofu Grelhado', 'Marca Tofu Leve', '100', 'g', '1', 'porção', '76', '8', '1.9', '4.8', NULL, NULL, NULL, NULL, NULL, NULL, '303', 'tofu_thumb.jpg', 'tofu_a.jpg', 'tofu_b.jpg', 'tofu_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Kiwi', 'Fazenda Kiwis Deliciosos', '100', 'g', '1', 'unidade', '61', '1.1', '15', '0.5', NULL, NULL, NULL, NULL, NULL, NULL, '404', 'kiwi_thumb.jpg', 'kiwi_a.jpg', 'kiwi_b.jpg', 'kiwi_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Manteiga de Amendoim', 'Marca Manteigas', '15', 'g', '1', 'colher de sopa', '94', '3.6', '3.1', '8', NULL, NULL, NULL, NULL, NULL, NULL, '505', 'manteigadeamendoim_thumb.jpg', 'manteigadeamendoim_a.jpg', 'manteigadeamendoim_b.jpg', 'manteigadeamendoim_c.jpg', NULL");
        setupInsertToComidas(
                "NULL, 'Queijo Cottage', 'Fazenda Laticínios Naturais', '100', 'g', '1', 'porção', '98', '11', '2.7', '4', NULL, NULL, NULL, NULL, NULL, NULL, '606', 'queijocottage_thumb.jpg', 'queijocottage_a.jpg', 'queijocottage_b.jpg', 'queijocottage_c.jpg', NULL");

    }
}
