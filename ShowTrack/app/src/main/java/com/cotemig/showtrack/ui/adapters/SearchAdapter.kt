package com.cotemig.showtrack.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import coil.load
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.MazeResult

class SearchAdapter (var context: Context, var list: List<MazeResult>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search_serie, null)

        val title = view.findViewById<TextView>(R.id.tittleSearch)
        val plataform = view.findViewById<TextView>(R.id.plataformSearch)
        val rating = view.findViewById<TextView>(R.id.ratingSearch)
        val summary = view.findViewById<TextView>(R.id.summarySearch)
        val banner = view.findViewById<ImageView>(R.id.bannerSearch)

        title.text = (list[position].show.name)
        plataform.text = (list[position].show.webChannel?.name)
        rating.text = (list[position].show.rating?.average)
        summary.text = (list[position].show.summary)
        banner.load(list[position].show.image?.medium)

        return view
    }
}