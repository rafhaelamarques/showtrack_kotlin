package com.cotemig.showtrack.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val episode = intent.getParcelableExtra<Episode>("details")

        val backBtn = findViewById<ImageButton>(R.id.detailsBack)
        val shareBtn = findViewById<ImageButton>(R.id.shareButton)

        backBtn.setOnClickListener { backToHome() }
        shareBtn.setOnClickListener { shareEpisode(episode?.embedded?.nextepisode?.url.toString()) }


        val banner = findViewById<ImageView>(R.id.detailsBanner)
        val date = findViewById<TextView>(R.id.detailsDate)
        val serie = findViewById<TextView>(R.id.serieTittle)
        val epNumber = findViewById<TextView>(R.id.episodeNumber)
        val epName = findViewById<TextView>(R.id.episodeName)
        val epSummary = findViewById<TextView>(R.id.episodeSummary)

        if (episode?.embedded?.nextepisode?.image != null) {
            banner.load(episode.embedded.nextepisode.image)
        } else {
            banner.load(episode?.image?.original)
        }
        serie.text = episode?.name
        date.text = episode?.embedded?.nextepisode?.airdate
        epNumber.text = ("Episode " + episode?.embedded?.nextepisode?.number + " x Season " + episode?.embedded?.nextepisode?.season)
        epName.text = episode?.embedded?.nextepisode?.name
        if(episode?.embedded?.nextepisode?.summary != null){
            epSummary.text = episode.embedded.nextepisode.summary
        } else {
            epSummary.text = episode?.summary
        }
    }

    private fun shareEpisode(url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.action=Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, url)
        intent.type="text/plain"
        startActivity(Intent.createChooser(intent,"Compartilhar em: "))

    }

    private fun backToHome() {
        finish()
    }
}