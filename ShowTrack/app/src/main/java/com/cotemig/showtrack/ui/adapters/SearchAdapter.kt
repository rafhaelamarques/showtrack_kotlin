package com.cotemig.showtrack.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Serie

class SearchAdapter (var context: Context, var list: List<Serie>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_search_serie, null)

        var title = view.findViewById<TextView>(R.id.tittleSearch)
        var plataform = view.findViewById<TextView>(R.id.plataformSearch)
        var rating = view.findViewById<TextView>(R.id.ratingSearch)
        var summary = view.findViewById<TextView>(R.id.summarySearch)
        var banner = view.findViewById<ImageView>(R.id.bannerSearch)

        title.text = (list[position].name)
        plataform.text = (list[position].plataform)
        rating.text = (list[position].rating)
        summary.text = (list[position].summary)
        banner.load(list[position].image)

        return view
    }
}