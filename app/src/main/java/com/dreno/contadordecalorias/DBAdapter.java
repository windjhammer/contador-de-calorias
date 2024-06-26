package com.dreno.contadordecalorias;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    private static final String databaseName = "calorias";
    private static final int databaseVersion = 16;

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, databaseName, null, databaseVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                // criação das tabelas
                db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (" +
                        " user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " user_email VARCHAR, " +
                        " user_pass VARCHAR, " +
                        " user_salt VARCHAR, " +
                        " user_apelido VARCHAR," +
                        " user_aniversario DATE, " +
                        " user_genero INT," +
                        " user_local, " +
                        " user_altura, " +
                        " user_atividade INT, " +
                        " user_peso INT," +
                        " user_peso_objetivo INT," +
                        " user_peso_objetivo_nivel INT, " +
                        " user_ultimo_visto TIME," +
                        " user_nota VARCHAR);");
                        db.execSQL("CREATE TABLE IF NOT EXISTS diario_calorias_consumidas (" +
                        " cal_consumidas_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " cal_consumidas_data DATE, " +
                        " cal_consumidas_refeicaoN INT, " +
                        " cal_consumidas_calorias INT, " +
                        " cal_consumidas_proteina INT, " +
                        " cal_consumidas_carboidrato INT, " +
                        " cal_consumidas_gordura INT);");
                db.execSQL("CREATE TABLE IF NOT EXISTS diario (" +
                        " diario_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " diario_data DATE, " +
                        " diario_numero_refeicao INT," +
                        " diario_porcao DOUBLE, " +
                        " diario_medidor_porcao VARCHAR, " +
                        " diario_calorias_calculado DOUBLE, " +
                        " diario_proteina_calculado DOUBLE, " +
                        " diario_carboidrato_calculado DOUBLE, " +
                        " diario_gordura_calculado DOUBLE, " +
                        " diario_gordura_refeicao_id INT);");
                db.execSQL("CREATE TABLE IF NOT EXISTS categorias (" +
                        " categoria_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " categoria_nome VARCHAR," +
                        " categoria_parent_id INT," +
                        " categoria_icone VARCHAR," +
                        " categoria_nota VARCHAR);");
                db.execSQL("CREATE TABLE IF NOT EXISTS comidas " +
                        " (comida_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " comida_nome VARCHAR," +
                        " comida_produtor VARCHAR," +
                        " comida_porcao DOUBLE," +
                        " comida_medidor_de_porcao VARCHAR," +
                        " comida_num_porcoes DOUBLE," +
                        " comida_num_porcoes_nome VARCHAR," +
                        " comida_calorias DOUBLE," +
                        " comida_proteina DOUBLE," +
                        " comida_carboidrato DOUBLE," +
                        " comida_gordura DOUBLE," +
                        " comida_calorias_calculado DOUBLE," +
                        " comida_proteina_calculado DOUBLE," +
                        " comida_carboidrato_calculado DOUBLE," +
                        " comida_gordura_calculado DOUBLE," +
                        " comida_usuario_id INT," +
                        " comida_codigo_de_barras VARCHAR," +
                        " comida_categoria_id INT," +
                        " comida_miniatura VARCHAR," +
                        " comida_imagem_a VARCHAR," +
                        " comida_imagem_b VARCHAR," +
                        " comida_imagem_c VARCHAR," +
                        " comida_nota VARCHAR);");
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Tabelas a serem dropadas
            db.execSQL("DROP TABLE IF EXISTS diario_calorias_consumidas");
            db.execSQL("DROP TABLE IF EXISTS comidas");
            db.execSQL("DROP TABLE IF EXISTS categorias");
            db.execSQL("DROP TABLE IF EXISTS diario");
            onCreate(db);

            String TAG = "Tag";
            Log.w(TAG, "Atualizando o banco de dados da versão: " + oldVersion + " para a versão: "
                    + newVersion + " , o que resultará na destruição de todos os dados.");

        }
    }

    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public void insert(String table, String fields, String values) {
        db.execSQL("INSERT INTO " + table + "(" + fields + ") VALUES (" + values + ")");
    }

    public int contadorDeNotasGravadas(String table) {
        Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM " + table + "", null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        return count;
    }

}
