package com.example.myapplication

object Database {

    val names = mutableListOf<String>("Mustafa","Berk","")

    val cars = mutableListOf(

        Car(1,"BMW","34FF42",FuelType.GAS),
        Car(1,"Mercedes","24HG25",FuelType.BENZIN),


    )

}

data class Car(val id:Int, val name:String, val plaka:String, val fuelType:FuelType){

    fun getListName() = "$name,$plaka"
}

enum class FuelType{
    GAS,
    MAZOT,
    BENZIN
}