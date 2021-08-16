package com.example.resultactivity;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(name TEXT primary key, contact TEXT, dob TEXT, subjectkannada TEXT, subjecthindi TEXT, subjectscience TEXT, subjectmaths TEXT, subjectsocial TEXT, unittest1 TEXT, unittest2 TEXT, semester1 TEXT ,Semester1Grade TEXT,unittest3 TEXT, unittest4 TEXT,semester2 TEXT ,Semester2Grade TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String name, String contact, String dob, String subjectkannada, String subjecthindi, String subjectscience, String subjectmaths, String subjectsocial) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("subjectkannada", subjectkannada);
        contentValues.put("subjecthindi", subjecthindi);
        contentValues.put("subjectscience", subjectscience);
        contentValues.put("subjectmaths", subjectmaths);
        contentValues.put("subjectsocial", subjectsocial);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String contact, String dob, String subjectkannada, String subjecthindi, String subjectscience, String subjectmaths, String subjectsocial) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        contentValues.put("subjectkannada", subjectkannada);
        contentValues.put("subjecthindi", subjecthindi);
        contentValues.put("subjectscience", subjectscience);
        contentValues.put("subjectmaths", subjectmaths);
        contentValues.put("subjectsocial", subjectsocial);
        Cursor cursor = DB.rawQuery("Select * from userdetails where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }


    //delete
    public Boolean deletedata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userdetails where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    //view
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userdetails", null);
        return cursor;

    }

    //unit test 1
    public Cursor unittest1result() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set unittest1 = dob + subjectkannada + subjecthindi + subjectscience + subjectmaths + subjectsocial", null);
        return cursor;
    }

    //unit test 2
    public Cursor unittest2result() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set unittest2 = dob + subjectkannada + subjecthindi + subjectscience + subjectmaths + subjectsocial", null);
        return cursor;
    }
    //unit test 3
    public Cursor unittest3result() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set unittest3 = dob + subjectkannada + subjecthindi + subjectscience + subjectmaths + subjectsocial", null);
        return cursor;
    }
    //unit test 4
    public Cursor unittest4result() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set unittest4 = dob + subjectkannada + subjecthindi + subjectscience + subjectmaths + subjectsocial", null);
        return cursor;
    }
    //semester 1
    public Cursor semmesterresult1() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set semester1 = unittest1 + unittest2 ", null);
        return cursor;
    }

    //semester 1
    public Cursor semmestergrade1() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set Semester1Grade = unittest1+unittest2+semester1*90/100 ", null);
        return cursor;
    }

    //semester 2
    public Cursor semmesterresult2() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set semester2 = unittest3 + unittest4 ", null);
        return cursor;
    }

    //semester 2
    public Cursor semmestergrade2() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Update userdetails set Semester2Grade = semester2*90/100 ", null);

        return cursor;
    }



}