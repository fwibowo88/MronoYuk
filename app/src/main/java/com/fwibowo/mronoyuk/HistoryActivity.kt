package com.fwibowo.mronoyuk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.fwibowo.mronoyuk.R.layout.activity_history
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*

var tmpHistory = ArrayList<String>();

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        tmpHistory.clear()

        for(key in orders)
        {
            tmpHistory.add(key.Time + " | " +key.Price)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        listViewHistory.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tmpHistory)

        listViewHistory.setOnItemClickListener{parent,view,position,id ->
            Toast.makeText(this, "Posisi : "+position.toString(),Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Jumlah Array : " +orders.count().toString(),Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Index Array 0 - List : " +orders[0].Time,Toast.LENGTH_SHORT).show()

            var intentListHistory = Intent(this,OrderActivity::class.java)
            intentListHistory.putExtra("Time", orders[position].Time)
            intentListHistory.putExtra("Origin",orders[position].From)
            intentListHistory.putExtra("Destination",orders[position].To)
            intentListHistory.putExtra("Total",orders[position].Price.toString())
            startActivity(intentListHistory)
        }


    }
}
