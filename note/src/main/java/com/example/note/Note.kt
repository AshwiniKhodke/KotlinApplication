package com.example.note

/**
 * Created by intel on 05/02/2018.
 */
class Note {
    var id: Int? = null
    var title: String? = null
    var content: String? = null

    constructor(id: Int, title: String, content: String) {
        this.id = id
        this.title = title
        this.content = content
    }

}