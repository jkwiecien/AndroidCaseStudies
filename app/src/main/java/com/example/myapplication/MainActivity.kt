package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.lists.ShoppingListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        MeasurementWidgetActivity.start(this)
//        startActivity(Intent(this, TranslucentStatusBarActivity::class.java))
        ShoppingListActivity.start(this)
    }
}
