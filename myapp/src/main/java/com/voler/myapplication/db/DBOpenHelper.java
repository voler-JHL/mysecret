package com.voler.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/11/18.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME = "secret.db"; //数据库名称
    private static final int DATABASEVERSION = 1;//数据库版本

    public DBOpenHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE password (pid integer primary key autoincrement,name varchar(50), account varchar(50), pwd varchar(50))");//执行有更改的sql语句
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS password");
        onCreate(db);
    }
}
