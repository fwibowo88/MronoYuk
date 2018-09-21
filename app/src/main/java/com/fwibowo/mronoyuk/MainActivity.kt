package com.fwibowo.mronoyuk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var places = ArrayList<Place>();
var discounts = ArrayList<Discount>();
var orders = ArrayList<Order>();
var tmpSpinner = ArrayList<String>();


fun GeneratePlaces()
{
    places.add(Place(0.0, "UBAYA"))
    places.add(Place(9.8, "TP1"))
    places.add(Place(5.6, "PS ATOM"))
    places.add(Place(6.2, "ITC"))
    places.add(Place(8.3, "BG Junction"))
    places.add(Place(11.5, "Ciputra World"))
    places.add(Place(3.2,"INDOMARET RUNGKUT"))
}

fun GenerateDiscount()
{
    discounts.add(Discount("SBYHEMAT",15.0))
    discounts.add(Discount("SBYOKE",10.0))
    discounts.add(Discount("HEMATBGT",50.0))
}

fun GenerateSpinner()
{
    for (place in places)
    {
        tmpSpinner.add(place.Name)
    }
}

fun findDiscount(inDiscount:String):Double
{
    var res = 0.0
    for(x in discounts)
    {
        if(inDiscount == x.Key)
        {
            res = x.Value;
        }
    }
    return res
}

fun calculateFare(price:Double, distance:Double, discount:Double):Double
{

    var result = price * distance - discount;
    return result
}

fun loadAppData()
{
    GeneratePlaces();
    GenerateSpinner();
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        loadAppData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tmpSpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMainFrom.adapter = adapter


        buttonMainHistory.setOnClickListener{
            
            //var intentHistory = Intent(this,HistoryActivity::class.java)
            //startActivity(intentHistory)
        }

        buttonMainMrono.setOnClickListener{
            var intentMrono =Intent(this,OrderActivity::class.java)
            startActivity(intentMrono)
        }


    }

}
