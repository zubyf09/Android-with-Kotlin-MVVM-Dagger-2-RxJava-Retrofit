package com.sevenpeakssoftware.zubair.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction

@Dao
interface ArticleDao {
    @get:Query("SELECT * FROM Article")
    val all: List<Article>

    @Insert
    fun insert(vararg users: Article)
    
    @Transaction
    @Insert
    fun insertAll(articles: List<Article>)




//    @Insert
//    fun insertAll(vararg users: ArticleResponse)
}