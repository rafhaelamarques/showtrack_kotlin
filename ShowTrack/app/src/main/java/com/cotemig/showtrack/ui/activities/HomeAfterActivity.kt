package com.cotemig.showtrack.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.services.MazeInitializer
import retrofit2.Call
import retrofit2.Response

class HomeAfterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_after)

        getNextEpisode()
    }

    private fun getNextEpisode() {
        val id = intent.getSerializableExtra("id")

//        val s = MazeInitializer().getEpisodeService()
//        val call = s.episodeSchedule(id)
//
//        call.enqueue(object : retrofit2.Callback<List<Episode>> {
//            override fun onResponse(
//                call: Call<List<Episode>>,
//                response: Response<List<Episode>>
//            ) {
//                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    if (responseBody != null) {
////                        showCard(response.body()!!)
//                    }
//                }
//            }
//            override fun onFailure(call: Call<List<Episode>>, t: Throwable) {
//                Toast.makeText(
//                    this@HomeAfterActivity,
//                    "Ops",
//                    Toast.LENGTH_LONG
//                ).show()
//                throw  t
//            }
//        })
    }

    private fun showCard(episode: List<Episode>){
//        val cards = findViewById<ListView>(R.id.listCards)
//        cards.adapter = HomeAdapter(this, cards)
    }
}