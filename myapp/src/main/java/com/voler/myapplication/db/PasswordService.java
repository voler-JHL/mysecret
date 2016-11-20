package com.voler.myapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.voler.myapplication.mvp.model.entity.PasswordEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/11/18.
 */
@Singleton
public class PasswordService {

    private DBOpenHelper dbOpenHelper;

    public PasswordService(Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
    }

    public void save(PasswordEntity password){
        //如果要对数据进行更改，就调用此方法得到用于操作数据库的实例,该方法以读和写方式打开数据库
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into password (name,account,pwd) values(?,?,?)", new Object[]{password.getName(),password.getAccount(),password.getPwd()});
    }

    public void update(PasswordEntity password){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("update password set name=?,account=?,pwd=? where pid=?", new Object[]{password.getName(),password.getAccount(),password.getPwd(),password.getPid()});
    }

    public void delete(String pid){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("delete from password where pid=?", new Object[]{pid});
    }

    public PasswordEntity find(String pid){
        //如果只对数据进行读取，建议使用此方法
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from password where pid=?", new String[]{pid});
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String account = cursor.getString(cursor.getColumnIndex("account"));
            String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
            return new PasswordEntity(pid,name,account,pwd);
        }
        return null;
    }

    public List<PasswordEntity> getScrollData(Integer offset, Integer maxResult){
        List<PasswordEntity> passwordEntitiess = new ArrayList<>();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from password limit ?,?",
                new String[]{offset.toString(), maxResult.toString()});
        while(cursor.moveToNext()){
            String pid = cursor.getString(cursor.getColumnIndex("pid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String account = cursor.getString(cursor.getColumnIndex("account"));
            String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
            PasswordEntity passwordEntity = new PasswordEntity(pid,name,account,pwd);
            passwordEntitiess.add(passwordEntity);
        }
        cursor.close();
        return passwordEntitiess;
    }

    public long getCount() {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from password", null);
        cursor.moveToFirst();
        return cursor.getLong(0);
    }
}
