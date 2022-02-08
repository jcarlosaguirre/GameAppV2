package com.example.gameappv2.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.google.gson.Gson

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, "gameappv2.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        createTables( db )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS characters"
        db!!.execSQL(ordenBorrado)
        onCreate( db )
    }

    fun resetDatabase(){
        onUpgrade( this.writableDatabase, 1, 1)
    }

    private fun createTables( db: SQLiteDatabase? ){
        val ordenCreacion = "CREATE TABLE characters (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "description TEXT, " +
                "type INTEGER, " +
                "img_src TEXT, " +
                "anim_src TEXT, " +
                "available INTEGER" +
                ")"
        db!!.execSQL( ordenCreacion )
    }

    fun isCharactersTableFilled(){

        val dataExists = "SELECT * FROM characters"

        /*Abrimos la base de datos en modo lectura*/
        val db = this.readableDatabase
        val cursor = db.rawQuery(dataExists, null)
        Log.i("AAAAAA--------", cursor.count.toString())

        if(cursor.count == 0){
            fillCharactersTable()
        }
    }

    private fun fillCharactersTable(){
        val characters = SpriteViewModel.characterSprites
        val gson = Gson()
        val values = ContentValues()
        val db = this.writableDatabase

        for (char in characters){
            values.put("nombre", char.name)
            values.put("description", char.description)
//            values.put("type", gson.toJson(char.type).toByteArray())
            values.put("type", char.type.ordinal)
            values.put("img_src", char.img_src)
            values.put("anim_src", char.anim_src)
            values.put("available", char.available)
            db.insert("characters", null, values)
        }

        db.close()
    }


    fun anyadirDato(nombre: String, email: String) {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("email", email)
        val db = this.writableDatabase

        /*Abrimos la base de datos en modo escritura*/
        db.insert("characters", null, datos)
        db.close()
    }

    fun mostrarDatos(): Cursor? {
        val db: SQLiteDatabase = this.readableDatabase

        /*Abrimos la base de datos en modo lectura*/
        val cursor = db.rawQuery("SELECT * FROM characters", null)
        return cursor
    }

    fun actualizarDatos( id: Number, nombre: String, email: String){
        val args = arrayOf(id.toString())

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("email", email)

        val db = this.writableDatabase
        db.update("characters", datos, "id = ?", args)

        db.close()
    }

    fun eliminarDato( id: Number ){
        val args = arrayOf(id.toString())


        val db = this.writableDatabase
        db.delete("characters", "id = ?", args)

        db.close()
    }


}