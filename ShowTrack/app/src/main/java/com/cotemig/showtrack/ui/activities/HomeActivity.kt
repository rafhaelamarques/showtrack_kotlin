package com.cotemig.showtrack.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.HomeAdapter
import retrofit2.Call
import retrofit2.Response
import java.io.Serializable

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<RelativeLayout>(R.id.buttonPanel)
        addButton.setOnClickListener { addSerie() }

        val id = intent.getSerializableExtra("id")
        if (id != null) {
            getNextEpisode()
        }
    }

    private fun addSerie() {
        val intent = Intent(this, SearchActivity::class.java)
        intent.setClassName(this,"com.cotemig.showtrack.ui.activities.SearchActivity")
        startActivity(intent)
    }

    private fun getNextEpisode() {
        val id = intent.getSerializableExtra("id")

        val cards: MutableList<Episode> = mutableListOf()

        val s = MazeInitializer().getEpisodeService()
        val call = s.episodeSchedule(id as Int?)

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
                    "Erro ao carregar lista",
                    Toast.LENGTH_LONG
                ).show()
                throw  t
            }
        })
    }

    private fun showCard(episode: List<Episode>){
        val cards = findViewById<ListView>(R.id.listCards)
        cards.adapter = HomeAdapter(this, episode)

        cards.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("details", episode[i])
            startActivity(intent)
        }
    }
}