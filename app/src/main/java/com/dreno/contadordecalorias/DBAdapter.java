package com.dreno.contadordecalorias;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBAdapter {
    private static final String databaseName = "calorias";
    private static final int databaseVersion = 1;

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
                    db.execSQL("CREATE TABLE IF NOT EXISTS comidas " + " (comida_id INTEGEGER PRIMARY KEY AUTOINCREMENT, " + " comida_nome VARCHAR," + " comida_produtor VARCHAR);");
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

}
