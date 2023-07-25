package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


//Giris yapan kullanicinin ana sayfasi
class MainActivity : AppCompatActivity() {


    lateinit var tvWelcome:TextView
    lateinit var ivBackground:ImageView
    lateinit var rgGender:RadioGroup
    lateinit var rgLiterOrMoney:RadioGroup
    lateinit var btnShowResult:Button
    lateinit var etLiterOrMoney:EditText
    lateinit var spFuelTypes:Spinner
    lateinit var spCars:Spinner


    var selectedGenderRadioButton: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcome = findViewById(R.id.tvWelcome)
        ivBackground = findViewById(R.id.ivBackground)
        rgGender = findViewById(R.id.rgGender)
        rgLiterOrMoney = findViewById(R.id.rgLiterOrMoney)
        btnShowResult = findViewById(R.id.btnShowResult)
        etLiterOrMoney = findViewById(R.id.etLiterOrMoney)
        spFuelTypes = findViewById(R.id.spFuelTypes)
        spCars = findViewById(R.id.spCars)



        val carNames = Database.cars.map { it.getListName() }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carNames)
        spCars.adapter = adapter


        ivBackground.setImageResource(R.drawable.main_background2)

       val userEmail = intent.getStringExtra(LoginActivity.EMAIL)

        tvWelcome.text = "Hosgeldiniz, ${userEmail.orEmpty()}"


        spFuelTypes.onItemSelectedListener = object :OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val items = resources.getTextArray(R.array.fuel_types)
                val selected = items.get(position)
                Toast.makeText(this@MainActivity, selected, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
               println("lutfen secim yap....")
            }

        }
        rgLiterOrMoney.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton:RadioButton = findViewById(checkedId)

            etLiterOrMoney.isEnabled = selectedRadioButton.id != R.id.rdbtnFull


        }

        rgGender.setOnCheckedChangeListener { group, checkedId ->
            println("secim degisti--> $checkedId")
            selectedGenderRadioButton = findViewById(checkedId)
        }

        btnShowResult.setOnClickListener {
            selectedGenderRadioButton?.let {
                //doluysa
                val gender = it.text
                AlertDialog.Builder(this).setTitle("Cinsiyet")
                    .setMessage("Secili cinsiyet: $gender")
                    .create().show()

            }?: kotlin.run {
                //alert dialog
                AlertDialog.Builder(this).setTitle("Uyari")
                    .setMessage("Bir cinsiyet secimi yapilmadi, lutfen secim yap!")
                    .create().show()

            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuExit-> finish()
        }
        return super.onOptionsItemSelected(item)
    }



}