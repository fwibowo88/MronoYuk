package com.fwibowo.mronoyuk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

var places = ArrayList<Place>();
var discounts = ArrayList<Discount>();
var generateSpinner = ArrayList<String>();


fun GeneratePlaces()
{
    var place1 = Place(0.0, "UBAYA")
    var place2 = Place(9.8, "TP1")
    var place3 = Place(5.6, "PS ATOM")
    var place4 = Place(6.2, "ITC")
    var place5 = Place(8.3, "BG Junction")
    var place6 = Place(11.5, "Ciputra World")
    places.add(place1);
    places.add(place2);
    places.add(place3);
    places.add(place4);
    places.add(place5);
    places.add(place6);
}

fun GenerateDiscount()
{
    var Disc1 = Discount("SBYHEMAT",15.0)
    var Disc2 = Discount("SBYOKE",10.0)
    var Disc3 = Discount("HEMATBGT",50.0)
    discounts.add(Disc1)
    discounts.add(Disc2)
    discounts.add(Disc3)
}

fun GenerateSpinner()
{
    for (place in places)
    {
        generateSpinner.add(place.Name)
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

fun initApp()
{
    GeneratePlaces();
    GenerateSpinner();
    val adapter
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        initApp();
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
