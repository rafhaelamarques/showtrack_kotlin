package com.cotemig.showtrack.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.HomeAdapter
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<RelativeLayout>(R.id.buttonPanel)
        addButton.setOnClickListener { addSerie() }

        getNextEpisode()
    }

    private fun addSerie() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }

    private fun getNextEpisode() {
        val id = intent.getSerializableExtra("id")

        val cards: MutableList<Episode> = mutableListOf()

        val s = MazeInitializer().getEpisodeService()
        val call = s.episodeSchedule(2993)

        call.enqueue(object : retrofit2.Callback<Episode> {
            override fun onResponse(
                call: Call<Episode>,
                response: Response<Episode>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        cards.add(response.body()!!)
                        showCard(cards)
                    }
                }
            }
            override fun onFailure(call: Call<Episode>, t: Throwable) {
                Toast.makeText(
                    this@HomeActivity,
                    "Ops",
                    Toast.LENGTH_LONG
                ).show()
                throw  t
            }
        })
    }

    private fun showCard(episode: List<Episode>){
        val cards = findViewById<ListView>(R.id.listCards)
        cards.adapter = HomeAdapter(this, episode)
        
        cards.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("details", cards)
            startActivity(intent)
        }
    }
}