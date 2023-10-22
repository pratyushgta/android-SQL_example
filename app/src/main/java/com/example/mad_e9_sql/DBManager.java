/**
 * This class contains methods for managing DB (insert, fetch, update, delete records)
 * MAD-E10
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
package com.example.mad_e9_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context ctx) {
        context = ctx;
    }

    // DB Manager will open the DB > give context to helper class > initialise DB instance with DB object returned by helper
    public DBManager open() throws SQLDataException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String hit_pts) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NAME, name);
        contentValues.put(DBHelper.COLUMN_ATTACK_HP, hit_pts);
        database.insert(DBHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME, DBHelper.COLUMN_ATTACK_HP};
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            // arrange cursor in right order
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long id, String name, String hit_pts) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NAME, name);
        contentValues.put(DBHelper.COLUMN_ATTACK_HP, hit_pts);
        return database.update(DBHelper.TABLE_NAME, contentValues, DBHelper.COLUMN_ID + "=" + id, null);
    }

    public void delete(long id) {
        database.delete(DBHelper.TABLE_NAME, DBHelper.COLUMN_ID + "=" + id, null);
    }
}
