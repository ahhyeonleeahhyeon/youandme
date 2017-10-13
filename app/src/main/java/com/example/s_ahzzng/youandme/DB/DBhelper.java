package com.example.s_ahzzng.youandme.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by s_ahzzng on 2017-10-07.
 */

public class DBhelper extends SQLiteOpenHelper {

    int number = 0;
    public DBhelper(Context context, String name , SQLiteDatabase.CursorFactory factory , int version)
    {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //DB 새로 생성 할때 호출되는 함수 , 사용하지 않음
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //버전 업그레이드 할 때 쓰이는 함수
    }
    public void student_register(String name, String age, String email, String home, String school,String gender, String photourl)
    {
        //읽고 쓰기가 가능하게 DB를 열기
        //int temp  = Integer.parseInt(age);// 나이는 숫자니까 String 에서 int로 변환
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='user'", null);
        cursor.moveToFirst();
        if(cursor.getCount() == 0)//테이블이 없으면 테이블 만들자
        {
            db.execSQL("create table user(name char(10), age char(3), email char(20), home char(20), school char(20), gender char(3), photourl char(30));");

        }
        db.execSQL("INSERT INTO user VALUES('" + name + "', '" + age + "','" + email + "','" + home + "','" + school + "','" + gender + "','" + photourl + "');");
        db.close();
    }

    public SQLiteDatabase home_list_show()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='homelist'", null);
        cursor.moveToFirst();

        if(cursor.getCount() == 0)
        {
            db.execSQL("create table homelist(number int, home_url int, home_name char(40), address char(50), host char(10));");
        }
        return db;
    }

    public void home_list_insert(int photourl, String nickname , String address , String host) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='homelist'", null);
        cursor.moveToFirst();
        number++;
        if (cursor.getCount() == 0)//테이블이 없으면 테이블 만들자
        {
            db.execSQL("create table homelist(number int, home_url int, home_name char(40), address char(50), host char(10));");

        }
        Cursor cursor1 = db.rawQuery("SELECT * FROM homelist", null);
        db.execSQL("INSERT INTO homelist VALUES("+number+"," + photourl + ",'"+nickname+"','" + address + "','" + host + "');");
        db.close();
    }

    public Cursor home_list_select(String number) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='homelist'", null);
        cursor.moveToFirst();
        int num = Integer.parseInt(number);
        if (cursor.getCount() == 0)//테이블이 없으면 테이블 만들자
        {
            db.execSQL("create table homelist(number int, home_url int, address char(50));");
        }
        Cursor cursor1 = db.rawQuery("SELECT * FROM homelist WHERE number ="+num+"", null);
        cursor1.moveToFirst();

        return cursor1;
    }



}
