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
            //Toast.makeText(this,"${tmpHistory[position]}",Toast.LENGTH_SHORT).show()
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()

            var intentListHistory = Intent(this,OrderActivity::class.java)
            for(x in 0 .. orders.count())
            {
                if(orders[x].toString() == position.toString())
                {
                    intentListHistory.putExtra("Time",orders[x].Time)
                    intentListHistory.putExtra("Origin",orders[x].From)
                    intentListHistory.putExtra("Destination",orders[x].To)
                    intentListHistory.putExtra("Total",orders[x].Price)
                }
                break;
            }
            startActivity(intentListHistory)
        }


    }
}
