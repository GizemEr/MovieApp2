package com.example.movieapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        showUser()
    }

    private fun showUser(){
        val preferences = getSharedPreferences("MovieApp",Context.MODE_PRIVATE)
        val email = preferences.getString("email","User Not Found")

        Toast.makeText(this,"Email = $email",Toast.LENGTH_SHORT).show()
        movienameTextView.text = email
    }
}
