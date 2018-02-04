package com.example.androidsqlite

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by intel on 02/02/2018.
 */
@Entity
class Mobile {
    @PrimaryKey
    var mbId : Long? = null

    @ColumnInfo(name = "mob_typ")
    var typ : String? = null

    @ColumnInfo(name = "mob_mnFr")
    var mnFr : String? = null

    @ColumnInfo(name = "is_qwerty")
    var isQw: Boolean? = null
}