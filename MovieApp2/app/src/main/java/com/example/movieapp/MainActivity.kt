package com.example.movieapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        signİnButton.setOnClickListener {
            val email:String=emailEditText.text.toString()
            val password:String=passwordEditText.text.toString()
            saveUser(email,password)
            navigateDetailActivity()
        }
    }

    private fun navigateDetailActivity(){
        val detailIntent = Intent(this, MovieDetailActivity::class.java)
        startActivity(detailIntent)
    }

    private fun saveUser(email:String,password:String){
        val preferences = getSharedPreferences ("MovieApp",Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("email",email)
        editor.putString("password",password)
        editor.apply()

        val savedEmail = preferences.getString("email","default text")

        Toast.makeText(this ,"User saved : Email - > $savedEmail",Toast.LENGTH_SHORT).show()
    }
}