package com.example.schoolapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.schoolapp.videolecs.VideoLecData;

import java.util.ArrayList;
import java.util.List;

public  class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name = "videolecs.db";
    public static final String Table_Name = "videolecs";
    public static final String id = "ID";
    public static final String title = "TITLE";
    public static final String keyword = "KEYWORD";
    public static String query1 = "CREATE TABLE"+ Table_Name +" ("+
            id+" integer primary key autoincrement, "+
            title+" text, "+keyword+" text)";
    private static String query2="Drop table"+Table_Name+" if exists";
    private Context context;

    List<VideoLecData> list = new ArrayList<>();

    public DatabaseHelper( Context context) {
        super(context, Database_Name, null, 1);
        this.context=context;
        SQLiteDatabase db=this.getWritableDatabase();
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String query = "CREATE TABLE Table_Name (title TEXT NOT NULL, keyword TEXT NOT NULL)";
//        db.execSQL(query);
//        db.execSQL("INSERT INTO Table_Name(title,keyword) VALUES('Pythagorus Theorem','TED-Ed')");
//
//        db.execSQL("INSERT INTO Table_Name(title,keyword) VALUES('Newtons 2nd Law','Don%27tMemorise')");
//
//        db.execSQL("INSERT INTO Table_Name(title,keyword) VALUES('Evaporation and Condensation','Studylearn')");
//
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Table_Name");
//        onCreate(sqLiteDatabase);
//    }

//    public static DatabaseHelper addData(String title, String keyword){
//
//
//        return null;
//    }

    public Cursor readData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String qury= "SELECT * FROM Table_Name";
        Cursor cursor=db.rawQuery(qury,null);
        return  cursor;
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(query1);
            Toast.makeText(context,"on Create Call",Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(context,""+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            Toast.makeText(context,"on Upgrade Call",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(query2);
            onCreate(sqLiteDatabase);
        }catch (SQLException e){
            Toast.makeText(context,""+e,Toast.LENGTH_SHORT).show();
        }
    }
}
