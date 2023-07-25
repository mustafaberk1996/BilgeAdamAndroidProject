package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {

    companion object{
        const val EMAIL = "email"
    }

    var btnSignUp:Button? = null
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        println("onCreate")

        btnSignUp = findViewById(R.id.btnSignUp)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)



        btnSignUp!!.setOnClickListener {
            //Toast.makeText(this,"Bilge Adam Akademi",Toast.LENGTH_LONG).show()

            if (!etEmail.text.isNullOrEmpty() && !etPassword.text.isNullOrEmpty()){

                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra(EMAIL, etEmail.text.toString())
                startActivity(intent)

                etEmail.text.clear()
                etPassword.text.clear()
                Toast.makeText(this,R.string.welcome,Toast.LENGTH_SHORT).show()
            }else{
              AlertDialog.Builder(this)
                    .setTitle("Uyari")
                    .setMessage("Bos Alan Birakmayiniz")
                    .setCancelable(false)
                    .setPositiveButton("Tamam") { dialog, which ->
                        Toast.makeText(this,"Mesaj Alindi",Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }.setNegativeButton("Iptal"){dialog,which->
                        //dialog.dismiss()
                    }.setNeutralButton("Neutral Button"){dialog,which->
                        dialog.dismiss()
                    }.setIcon(R.drawable.baseline_warning_24)
                    .create().show()
            }

        }
    }

    override fun onStop() {
        println("onStop")
        super.onStop()
    }

    override fun onStart() {
        println("onStart")
        super.onStart()
    }

    override fun onPause() {
        println("onPause")
        super.onPause()
    }

    override fun onRestart() {
        println("onRestart")
        super.onRestart()
    }
    override fun onResume() {
        println("onResume")
        super.onResume()
    }

    override fun onDestroy() {
        println("onDestroy")
        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.menuSearch-> println("clicked! menu search")
                R.id.menuFlight-> println("clicked! menu flight")
                R.id.menuFacebook-> println("clicked! menu facebook")
                R.id.menuGoogle-> println("clicked! menu google")
            }

        return super.onOptionsItemSelected(item)
    }




}