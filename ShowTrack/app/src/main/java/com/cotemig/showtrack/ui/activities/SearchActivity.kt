package com.cotemig.showtrack.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.MazeResult
import com.cotemig.showtrack.services.MazeInitializer
import com.cotemig.showtrack.ui.adapters.HomeAdapter
import com.cotemig.showtrack.ui.adapters.SearchAdapter
import retrofit2.Call
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchText = findViewById<EditText>(R.id.searchBox)
        val searchBtn = findViewById<ImageButton>(R.id.searchButton)

        searchBtn.setOnClickListener { getSearchResult(show = searchText.text.toString()) }
    }

    private fun getSearchResult(show: String) {
        val s = MazeInitializer().getSearchService()
        val call = s.searchSerie(q = show)

        call.enqueue(object : retrofit2.Callback<List<MazeResult>> {
            override fun onResponse(
                call: Call<List<MazeResult>>,
                response: Response<List<MazeResult>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        showResult(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<List<MazeResult>>, t: Throwable) {
                Toast.makeText(
                    this@SearchActivity,
                    "Erro ao pesquisar",
                    Toast.LENGTH_LONG
                ).show()
                throw  t
            }
        })
    }

    fun showResult(list: List<MazeResult>) {
        val result = findViewById<ListView>(R.id.listSearch)
        val listCard = findViewById<ListView>(R.id.listCards)
        val listShowIds: ArrayList<Int> = arrayListOf<Int>()
        val backBtn = findViewById<ImageButton>(R.id.searchBackButton)

        listCard.adapter = HomeAdapter(this, listShowIds)
        listCard.setOnItemClickListener { adapterView, view, i, l ->
            listShowIds.add(list[i].show.id)
            backBtn.setOnClickListener { backToHome(listShowIds) }
        }
        result.adapter = SearchAdapter(this, list)
    }

    private fun backToHome(ids: ArrayList<Int>) {
        val intent = Intent(this, HomeAfterActivity::class.java)
        intent.putIntegerArrayListExtra("id", ids)
        startActivity(intent)
    }
}