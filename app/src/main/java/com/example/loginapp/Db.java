package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Db extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    ArrayList a1;

    public Db(Context context) {
        super(context, "ranj.db", null, 1);
        sq = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table detail(na text, pass text, Mobno text, adhaar text, ssn text, nationality text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void savedata(String name, String pw, String mob, String s5, String s6, String s7) {
        ContentValues cv = new ContentValues();
        cv.put("na", name);
        cv.put("pass", pw);
        cv.put("Mobno", mob);
        cv.put("adhaar ", s5);
        cv.put("ssn", s6);
        cv.put("nationality", s7);

    }

    public ArrayList myname(String r) {
        a1 = new ArrayList();

        Cursor c;
        Log.i("entered123",r);
        c = sq.query("detail",null," na = ? ",new String[]{r},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            a1.clear();
            a1.add("Not Exits");
            return a1;
        }

        a1.clear();
        a1.add(c.getString(c.getColumnIndex("pass")));
        a1.add(c.getString(c.getColumnIndex("Mobno")));
        a1.add(c.getString(c.getColumnIndex("adhaar")));
        a1.add(c.getString(c.getColumnIndex("ssn")));
        a1.add(c.getString(c.getColumnIndex("nationality")));
        return a1;
    }

}
