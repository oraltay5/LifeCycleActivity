package com.example.lifecycleactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.lifecycleactivity.databinding.ActivityMainBinding
import com.example.lifecycleactivity.more.MoreFragment
import com.example.lifecycleactivity.network.ProductAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.textView)
        val image = findViewById<AppCompatImageView>(R.id.imageView)
        val b = findViewById<Button>(R.id.button2)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/")
//            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productAPI = retrofit.create(ProductAPI::class.java)

        b.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                val product = productAPI.getProductById()
                runOnUiThread{
                    name.text = product.newsSite
                }
            }
        }
























        val secondActivity = findViewById<Button>(R.id.button)
        secondActivity.setOnClickListener{
            val intent = Intent(this, SecondActivity2::class.java)
            startActivity(intent)
        }

        val moreFragment = findViewById<Button>(R.id.frButton)
        moreFragment.setOnClickListener{
            val intent = Intent(this, MoreFragment::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.group -> finish()
            R.id.newsletter -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.devices -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.posts -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}


