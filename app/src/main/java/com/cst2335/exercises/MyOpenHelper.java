package com.cst2335.exercises;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyOpenHelper extends SQLiteOpenHelper {

    public static final String filename = "MyDatabase";
    public static final int version = 1;
    public static final String TABLE_NAME = "MyData";
    public static final String COL_ID = "_id";
    public static final String COL_MESSAGE = "Message";
    public static final String COL_SEND_RECEIVE = "SendOrReceive";
    public static final String COL_TIME_SENT = "TimeSent";

    public MyOpenHelper(Context context) {
        super(context, filename, null, version);
    }

    // should be the creation statement
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table MyData ( _id INTEGER PRIMARY KEY AUTOINCREMENT, Message TEXT, SendOrReceive INTEGER, TimeSent TEXT );
        String result = String.format(" %s %s %s", "FirstString" , "10", "10.0" );

        //                                      //TABLE_NAME               take care of id numbers
        db.execSQL( String.format( "Create table %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s  INTEGER, %s TEXT );"
                , TABLE_NAME, COL_ID,                       COL_MESSAGE, COL_SEND_RECEIVE, COL_TIME_SENT ) );
    }

    // delete current table, create a new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "Drop table if exists " + TABLE_NAME ); //deletes the current data
        //create a new table:

        this.onCreate(db); //calls function on line 26
    }
}
