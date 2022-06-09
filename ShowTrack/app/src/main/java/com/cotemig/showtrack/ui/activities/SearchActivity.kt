package com.cotemig.showtrack.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.MazeApi
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.SearchAdapter
import retrofit2.Call
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var searchText = findViewById<EditText>(R.id.searchBox)
        var searchBtn = findViewById<ImageButton>(R.id.searchButton)

        searchBtn.setOnClickListener { getSearchResult(show = searchText.text.toString()) }

    }

    private fun getSearchResult(show: String) {
        var s = MazeInitializer().getSearchService()
        var call = s.searchSerie(q = show)

        call.enqueue(object : retrofit2.Callback<List<MazeApi>> {
            override fun onResponse(
                call: Call<List<MazeApi>>,
                response: Response<List<MazeApi>>
            ) {
                response.body()?.let{
//                    val listType = object : TypeToken<List<MazeApi>>() {}.type
                    var list = ('{' + response.body().toString() + '}')
//                    val list: List<MazeApi> = Gson().fromJson(response.body().toString(), listType)
                    showFeed(it)
                }
            }

            override fun onFailure(call: Call<List<MazeApi>>, t: Throwable) {
                Toast.makeText(
                    this@SearchActivity,
                    "Error",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun showFeed(list: List<MazeApi>){
        var result = findViewById<ListView>(R.id.listSearch)
        result.adapter = SearchAdapter(this, list)
    }
}