package com.cotemig.showtrack.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.HomeAdapter
import retrofit2.Call
import retrofit2.Response

class HomeAfterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_after)

        getNextEpisode()
    }

    private fun getNextEpisode() {
        val id = intent.getIntArrayExtra("id")

        val s = MazeInitializer().getEpisodeService()
        val call = s.episodeSchedule(id?.first())

        call.enqueue(object : retrofit2.Callback<Episode> {
            override fun onResponse(
                call: Call<Episode>,
                response: Response<Episode>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        showCard(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<Episode>, t: Throwable) {
                Toast.makeText(
                    this@HomeAfterActivity,
                    "Ops",
                    Toast.LENGTH_LONG
                ).show()
                throw  t
            }
        })
    }

    private fun showCard(episode: Episode){
//        val cards = findViewById<ListView>(R.id.listCards)
//        cards.adapter = HomeAdapter(this, cards)
    }
}