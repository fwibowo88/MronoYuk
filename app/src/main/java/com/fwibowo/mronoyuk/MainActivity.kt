package com.fwibowo.mronoyuk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMainHistory.setOnClickListener{
            var intentHistory = Intent(this,HistoryActivity::class.java)
            startActivity(intentHistory)

        }

        buttonMainMrono.setOnClickListener{
            var intentMrono =Intent(this,OrderActivity::class.java)
            startActivity(intentMrono)
        }
    }
}
