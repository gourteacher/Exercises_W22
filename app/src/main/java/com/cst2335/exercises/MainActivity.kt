package com.college.exercises

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(){

    val TAG="MainActivity"
    lateinit var listItems:ArrayList<Message>
    lateinit var adapter:MyListAdapter

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItems=ArrayList<Message>()

        var btn=findViewById<Button>(R.id.load)
        btn?.setOnClickListener{btn->updateEntry()}

        //Examples of nullable vars
        //tv should be null here as we are trying to access an invalid view
        //textViewId2 exists in other_layout not in activity_main
        var tv=findViewById<TextView>(R.id.textViewId2)
        //here, if tv is null, setText() is not executed
        tv?.setText("This a textview")     //Nothing happens
        //Here, if tv is null, it will throw an exception
        //tv!!.setText("This a textview")    //An Exception should occur

        adapter=MyListAdapter(this,listItems)
        val lv=findViewById<ListView>(R.id.list)
        lv?.adapter=adapter
    }

    fun updateEntry():Unit{
        val tedit=findViewById<EditText>(R.id.enterTextId)
        if(tedit.text.length!=0){
            var m=Message(tedit.text.toString(),Date())
            listItems.add(m)
            adapter.notifyDataSetChanged()
        }
        tedit.text.clear()
    }

    //Primary constructor defines the 2 properties
    //context and dataSource
    class MyListAdapter(private val context:Context,
                    private val dataSource:ArrayList<Message>) :BaseAdapter() {

        private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItem(p0: Int): Any {
            return dataSource.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val rowView = inflater.inflate(R.layout.row_layout, p2, false)

            var msg = dataSource.get(p0) as Message
            // Get title element
            val titleTextView = rowView.findViewById(R.id.msgTextViewId) as TextView
            titleTextView.text = msg.info

            val datetv = rowView.findViewById(R.id.dateTextViewId) as TextView
            datetv.text = msg.date_str
            return rowView
        }
    }



    class Message(val info:String, d:Date) {
        lateinit var date_str :String

        init {
            //convert date to String
            date_str = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CANADA).format(d)
        }

        override fun toString() : String {
            return "$info : $date_str"
        }
    }
}