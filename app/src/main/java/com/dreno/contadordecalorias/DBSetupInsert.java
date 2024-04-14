package com.dreno.contadordecalorias;

public class DBSetupInsert {

    public void setupInsertToComidas(String values){
        db.execSQL("INSERT INTO ", + table + "("+ fields +")");

    }
}
