package com.cotemig.showtrack.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.MazeApi
import com.cotemig.showtrack.models.Serie
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.SearchAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var searchText = findViewById<EditText>(R.id.searchBox)
        var searchBtn = findViewById<ImageButton>(R.id.searchButton)

        searchBtn.setOnClickListener { getSearchResult(serie = searchText.text.toString()) }

    }

    private fun getSearchResult(serie: String) {
        var s = MazeInitializer().getSearchService()
        var call = s.searchSerie(q = serie)

        call.enqueue(object : retrofit2.Callback<List<MazeApi>> {
            override fun onResponse(
                call: Call<List<MazeApi>>,
                response: Response<List<MazeApi>>
            ) {
                response.body()?.let{
                    val listType = object : TypeToken<List<MazeApi>>() {}.type
                    val list: List<MazeApi> = Gson().fromJson(response.body().toString(), listType)
                    showFeed(list)
                }
            }



            override fun onFailure(call: Call<List<MazeApi>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showFeed(list: List<MazeApi>){
        var result = findViewById<ListView>(R.id.listSearch)
        result.adapter = SearchAdapter(this, list)
    }
}