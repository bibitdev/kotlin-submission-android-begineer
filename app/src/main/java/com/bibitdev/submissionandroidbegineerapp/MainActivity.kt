package com.bibitdev.submissionandroidbegineerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlayers: RecyclerView
    private val list = ArrayList<Player>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)
        list.addAll(getListPlayers())
        showRecyclerList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_menu -> {
                val aboutMe = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutMe)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPlayers(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNationality = resources.getStringArray(R.array.data_nationality)
        val dataDateOfBirth = resources.getStringArray(R.array.data_dates_of_birth)
        val dataPosition = resources.getStringArray(R.array.data_possition)
        val listPlayer = ArrayList<Player>()
        for (i in dataName.indices) {
            val player = Player(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataNationality[i], dataDateOfBirth[i], dataPosition[i])
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayers.adapter = listPlayerAdapter
    }
}
