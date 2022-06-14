package com.cotemig.showtrack.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode

class HomeAdapter (var context: Context, var list: List<Episode>) : BaseAdapter() {
    override fun getCount(): Int {
        return  list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_serie, null)

        val title = view.findViewById<TextView>(R.id.serieTittle)
        val plataform = view.findViewById<TextView>(R.id.seriePlataform)
        val rating = view.findViewById<TextView>(R.id.serieRating)
        val episode = view.findViewById<TextView>(R.id.nextEpText)
        val date = view.findViewById<TextView>(R.id.nextEpDate)
        val duration = view.findViewById<TextView>(R.id.nextEpDuration)
        val banner = view.findViewById<ImageView>(R.id.serieBanner)

        title.text = (list[position].name)
        plataform.text = (list[position].webChannel?.name)
        rating.text = (list[position].rating?.average)
        episode.text = (list[position].embedded?.nextepisode?.name)
        date.text = (list[position].embedded?.nextepisode?.airdate)
        duration.text = (list[position].embedded?.nextepisode?.airtime)
        banner.load(list[position].image?.medium)

        return view
    }

}