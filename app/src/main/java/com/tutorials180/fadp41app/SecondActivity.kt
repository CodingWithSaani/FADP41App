package com.tutorials180.fadp41app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if(intent.extras != null) {
            val name = intent.getStringExtra("n")
            val age = intent.getIntExtra("a", 0)

            Toast.makeText(
                SecondActivity@ this, "" +
                        "Name is : $name and age is: $age", Toast.LENGTH_SHORT
            ).show()
        }
        else
        {
            Toast.makeText(SecondActivity@this, "Nothing retrieved from intent", Toast.LENGTH_SHORT).show();
        }

    }
}