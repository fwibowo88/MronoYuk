package com.fwibowo.mronoyuk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intentOrder = this.intent;
        textViewOrderWaktu.text = "TBA"
        textViewOrderAsal.text = intentOrder.getStringExtra("Origin")
        textViewOrderTujuan.text = intentOrder.getStringExtra("Destination")
        textViewOrderTotal.text = intentOrder.getStringExtra("Total")

    }
}
