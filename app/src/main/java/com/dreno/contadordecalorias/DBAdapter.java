package com.dreno.contadordecalorias;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBAdapter {
    private static final String databaseName = "calorias";
    private static final int databaseVersion = 7;

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        private static class DatabaseHelper extends SQLiteOpenHelper{
            DatabaseHelper(Context context){
                super(context, databaseName, null, databaseVersion);
            }

            @Override
            public void onCreate(SQLiteDatabase db){
                try {
                    //criação das tabelas
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
                }
                catch (SQLException e){
                    e.printStackTrace();

                }
            }


            @Override
            public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
                //Tabelas a serem dropadas
                db.execSQL("DROP TABLE IF EXISTS comidas");
                onCreate(db);

                String TAG = "Tag";
                Log.w(TAG, "Atualizando o banco de dados da versão: " + oldVersion + " para a versão: "
                        + newVersion + " , o que resultará na destruição de todos os dados.");

            }
        }
        public DBAdapter open() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        DBHelper.close();
    }

    public void insert(String table, String fields, String values){
        db.execSQL("INSERT INTO " + table + "(" + fields + ") VALUES (" + values + ")");
    }

    public int contadorDeNotasGravadas (String table){
        Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM " + table + "", null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        return count;
    }

}