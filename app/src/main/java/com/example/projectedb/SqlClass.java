package com.example.projectedb;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SqlClass extends SQLiteOpenHelper {

    private static final String DB_NAME = "CommentDatabase";
    private static final int DB_VERSION = 1;

    public SqlClass(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS comentarios ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, 'titol' TEXT, 'comentario' TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addComent(Comentario comentario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titol", comentario.getTitol());
        contentValues.put("comentario", comentario.getComentario());
        db.insert("comentarios", null, contentValues);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Comentario> getComentarios() {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from comentarios", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    Comentario item = new Comentario();
                    item.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    item.setTitol(cursor.getString(cursor.getColumnIndex("titol")));
                    item.setComentario(cursor.getString(cursor.getColumnIndex("comentario")));
                    comentarios.add(item);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return comentarios;
    }

}
