package com.fwibowo.mronoyuk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.fwibowo.mronoyuk.R.layout.activity_history
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        listViewHistory.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, orders)

        /*listViewHistory.setOnItemClickListener{parent,view,position,id ->
            Toast.makeText(this,"${orders[position]}",Toast.LENGTH_SHORT).show()
        }*/

        //textView15.text = orders.size.toString();
    }
}
