package id.ac.polinema.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataKota extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "datakota.db";
    private static final int DATABASE_VERSION = 1;

    public DataKota(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table kota(nama text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
