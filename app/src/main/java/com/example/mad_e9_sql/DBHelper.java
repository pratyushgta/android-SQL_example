/**
 * This class contains methods for handling the components of the DB
 * MAD-E10
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
package com.example.mad_e9_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "monkeyRadar.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "monkey_records";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ATTACK_HP = "hitpoints";

    public static final String CREATE_DB_QUERY = "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " //ID will keep on auto incrementing
            + COLUMN_NAME + " TEXT NOT NULL,"
            + COLUMN_ATTACK_HP + " TEXT)";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) { //i= old version i1= new version
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
