package com.example.task.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
public class User extends SQLiteOpenHelper
{
    private static final String TAG = "User";
    private static final String DataBase_NAME="MyDataBase";
    public static final String TABLE_NAME1="UserCheckList";
    private static final String TABLE_NAME2="UserCheckListAttachment";
    private static final int DATABASE_VERSION=1;
    private Context context;
    public User(Context context)
    {
        super(context,DataBase_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table "+TABLE_NAME2+"(userid TEXT,password TEXT,confirm_pwd TEXT)";
        db.execSQL(qry);
        Log.d(TAG, "onCreate: Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public Boolean emailpassword(String userid,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.rawQuery("select * from "+TABLE_NAME2+" where userid=? and password=?",new String[]{userid,password});

        if(c.getCount()>0)
        {
            return true;
        }

        else
        {
            return false;
        }



    }
    public void userRegistration(String userid,String Pwd,String c_Pwd)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",userid);
        contentValues.put("password",Pwd);
        contentValues.put("confirm_pwd",c_Pwd);
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME2,null,contentValues);
        Toast.makeText(context,"Data inserted..",Toast.LENGTH_LONG).show();
        Log.d(TAG, "userRegistration: Data inserted..");

    }
}
