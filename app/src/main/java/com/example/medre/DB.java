package com.example.medre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonUiContext;
import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    private Context context;




    public DB(Context context ) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(name TEXT primary key, medname Text, medQty Text, medsched Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Userdetails");
    }
    public Boolean addMedInfo(String name, String med, String qty, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();

        cv.put("name", name);
        cv.put("medName", med);
        cv.put("medQty", qty);
        cv.put("medSched", time);

        long result = db.insert("Userdetails", null, cv);
        if (result==-1){
            return false;
        } else{
            return true;
        }
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Userdetails", null);
        return cursor;
    }


}
