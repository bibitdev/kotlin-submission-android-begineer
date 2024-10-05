package com.bibitdev.submissionandroidbegineerapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlayerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_player_detail)
        // Ambil data dari Intent
        val playerName = intent.getStringExtra("EXTRA_NAME")
        val playerDescription = intent.getStringExtra("EXTRA_DESCRIPTION")
        val playerPhoto = intent.getIntExtra("EXTRA_PHOTO", 0)

        // Set data ke view
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)

        tvName.text = playerName
        tvDescription.text = playerDescription
        imgPhoto.setImageResource(playerPhoto)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"

                val name: TextView = findViewById(R.id.tv_item_name)
                val desc: TextView = findViewById(R.id.tv_item_description)

                val shareText = "Check out this amazing players: ${name.text} - ${desc.text}"
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                startActivity(Intent.createChooser(shareIntent, "Share via"))

            }
        }
        return super.onOptionsItemSelected(item)
    }
}


