package com.cotemig.showtrack.models

import com.google.gson.internal.LinkedTreeMap

class MazeApi  (json: LinkedTreeMap<String, Serie>)  {
    var serie: Serie? = null

    init {
        this.serie = json["show"]
    }
}