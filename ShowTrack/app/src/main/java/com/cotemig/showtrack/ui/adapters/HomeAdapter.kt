package com.cotemig.showtrack.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.models.Show

class HomeAdapter (var context: Context, var list: MutableList<Show>) : BaseAdapter() {
    override fun getCount(): Int {
        return  list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

}