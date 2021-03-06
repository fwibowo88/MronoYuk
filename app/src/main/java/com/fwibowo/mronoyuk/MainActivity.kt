package com.fwibowo.mronoyuk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

var places = ArrayList<Place>();
var discounts = ArrayList<Discount>();
var orders = ArrayList<Order>();
var price:Double = 3000.0
var discValue:Double = 0.0

fun GeneratePlaces()
{
    places.add(Place(0.0, "UBAYA"))
    places.add(Place(9.8, "TP1"))
    places.add(Place(5.6, "PS Atom"))
    places.add(Place(6.2, "ITC"))
    places.add(Place(8.3, "BG Junction"))
    places.add(Place(11.5, "Ciputra World"))
    places.add(Place(3.2,"Indomaret Rungkut"))
}

fun GenerateDiscount()
{
    discounts.add(Discount("SBYHEMAT",15.0))
    discounts.add(Discount("SBYOKE",10.0))
    discounts.add(Discount("HEMATBGT",50.0))
}

fun FindDiscount(xCode : String):Double
{
    var result = 0.0
    for(x in discounts)
    {
        if(xCode.capitalize() == x.Key)
        {
            result = x.Value;
        }
    }
    return result
}

fun loadAppData()
{
    GeneratePlaces();
    GenerateDiscount();
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        loadAppData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FILL DATA TO SPINNER ORIGIN
        val adapterFrom = ArrayAdapter(this, android.R.layout.simple_spinner_item, places)
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMainFrom.adapter = adapterFrom

        //FILL DATA TO SPINNER DESTINATION
        val adapterTo = ArrayAdapter(this, android.R.layout.simple_spinner_item, places)
        adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMainTo.adapter = adapterTo

        buttonMainHistory.setOnClickListener{
            var intentHistory = Intent(this,HistoryActivity::class.java)
            startActivity(intentHistory)
        }

        buttonHomeCode.setOnClickListener {
            discValue = FindDiscount(editTextHomeCode.text.toString());
            if(discValue > 0) {
                Toast.makeText(this,"Selamat Promo " +editTextHomeCode.text.toString() + " Diterima",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Kode tidak Valid !",Toast.LENGTH_SHORT).show()
            }
        }

        buttonMainMrono.setOnClickListener{
            if(spinnerMainFrom.selectedItem.toString().trim() == spinnerMainTo.selectedItem.toString().trim())
            {
                Toast.makeText(this,"Lokasi Penjemputan & Tujuan Sama",Toast.LENGTH_SHORT).show()
            }
            else
            {
                var origin = spinnerMainFrom.selectedItem.toString().trim()
                var destination = spinnerMainTo.selectedItem.toString().trim()

                var tmpOrigin = Place(0.0,"UNKNOWN")
                var tmpDestination = Place(0.0,"UNKNOWN")
                var totalPrice = 0.0
                var distance = 0.0

                for(x in places)
                {
                    if(x.Name == origin)
                    {
                        tmpOrigin.Name = x.Name
                        tmpOrigin.Location = x.Location
                    }

                    if(x.Name == destination)
                    {
                        tmpDestination.Name = x.Name
                        tmpDestination.Location = x.Location
                    }
                }
                distance = tmpOrigin.Location - tmpDestination.Location
                if(distance < 0)
                {
                    distance = distance * -1
                }

                totalPrice = distance * price

                if(discValue > 0)
                {
                    totalPrice = totalPrice - (totalPrice * discValue / 100.0)
                }


                var fixPrice = totalPrice.roundToInt();

                val formatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")
                val currentTime_1 = Date()
                val dateString = formatter.format(currentTime_1)

                orders.add(Order(tmpOrigin.Name,tmpDestination.Name,distance,fixPrice,dateString))


                var intentMrono = Intent(this,OrderActivity::class.java)
                intentMrono.putExtra("Time",dateString)
                intentMrono.putExtra("Origin",tmpOrigin.Name)
                intentMrono.putExtra("Destination",tmpDestination.Name)
                intentMrono.putExtra("Total",fixPrice.toString())
                startActivity(intentMrono)

            }
        }
    }
}
