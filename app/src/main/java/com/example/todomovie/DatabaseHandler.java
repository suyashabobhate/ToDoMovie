package com.example.todomovie;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MovieD";
    private static final String TABLE_List = "List";
    private static final String TABLE_Towatch = "ToWatch";
    private static final String TABLE_Watched = "Watched";
    private static final String TABLE_Watching = "Watching";
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE1 = "CREATE TABLE " + TABLE_List + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Name + " TEXT"
                +  ")";
        db.execSQL(CREATE_CONTACTS_TABLE1);

        String CREATE_CONTACTS_TABLE2 = "CREATE TABLE " + TABLE_Towatch + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Name + " TEXT "
                +  ")";
        db.execSQL(CREATE_CONTACTS_TABLE2);

        String CREATE_CONTACTS_TABLE3= "CREATE TABLE " + TABLE_Watching + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Name + " TEXT "
                +  ")";
        db.execSQL(CREATE_CONTACTS_TABLE3);

        String CREATE_CONTACTS_TABLE4 = "CREATE TABLE " + TABLE_Watched + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Name + " TEXT"
                +  ")";
        db.execSQL(CREATE_CONTACTS_TABLE4);
    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_List);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Towatch);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Watching);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Watched);

        // Create tables again
        onCreate(db);
    }

    public void  deleteTables(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_List);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Towatch);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Watching);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Watched);

        // Create tables again
        onCreate(db);
    }

    void addMovie(String s,String table) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, s); // Contact Name

        // Inserting Row
        db.insert(table, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public boolean checkForTableExists(String table){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+table+"'";
        Cursor mCursor = db.rawQuery(sql, null);
        if (mCursor.getCount() > 0) {
            return true;
        }
        mCursor.close();
        return false;
    }

    public void addSelected(ArrayList<String> List) {

        int size = List.size();

        SQLiteDatabase db = getWritableDatabase();
        try {
            for (int i = 0; i < size; i++) {
                ContentValues cv = new ContentValues();
                cv.put(KEY_ID, i);
                cv.put(KEY_Name, List.get(i));
                Log.d("Added ", "" + cv);
                db.insertOrThrow(TABLE_List, null, cv);
            }
            db.close();
        } catch (Exception e) {
            Log.e("Problem", e + " ");
        }
    }

    // code to get the single contact
    String getList(int id,String table) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table, new String[] { KEY_ID,
                        KEY_Name }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        String s=cursor.getString(1);
        // return contact
        return s;
    }

    public int getId(String s,String table){
        SQLiteDatabase db = this.getReadableDatabase();
        s=s.replaceAll("'","\\'");
        String q = "select id from "+table+" where name = ?";
        Cursor mCursor =db.rawQuery(q, new String[] {s});
        //Cursor mCursor = db.rawQuery("SELECT id  FROM  Towatch WHERE name= '"+s+"'" , null);
        int id=0;
        if (mCursor != null)
        {
            mCursor.moveToFirst();
            id=mCursor.getInt(0);
        }
        return id;
    }

    public int getRandomId(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT id  FROM List ORDER BY RANDOM() LIMIT 1", null);
        int id=0;
        if (mCursor != null)
        {
            mCursor.moveToFirst();
            id=mCursor.getInt(0);
        }
        return id;
    }

    // code to get all contacts in a list view
    public List<Movie> getAllMovie(String table) {
        List<Movie> list = new ArrayList<Movie>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Movie Movie = new Movie();
                Movie.setID(Integer.parseInt(cursor.getString(0)));
                Movie.setName(cursor.getString(1));
                // Adding contact to list
                list.add(Movie);
            } while (cursor.moveToNext());
        }

        // return contact list
        return list;
    }


    // Deleting single contact
    public void deleteMovie(int id, String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }




}

