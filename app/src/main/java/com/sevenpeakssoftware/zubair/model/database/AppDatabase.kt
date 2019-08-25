package com.sevenpeakssoftware.zubair.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.sevenpeakssoftware.zubair.model.Article
import com.sevenpeakssoftware.zubair.model.ArticleDao

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}