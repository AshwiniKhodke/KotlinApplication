package com.example.androidsqlite

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by intel on 02/02/2018.
 */
@Dao
interface MobileDAO {
    @Insert
    fun savedMobile(mob:Mobile)

    @Query("select * from Mobile")
    fun mobiles():List<Mobile>
}