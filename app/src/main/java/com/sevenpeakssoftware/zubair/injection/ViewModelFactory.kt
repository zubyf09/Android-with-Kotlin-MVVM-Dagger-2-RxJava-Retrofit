package com.sevenpeakssoftware.zubair.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import com.sevenpeakssoftware.zubair.model.database.AppDatabase
import com.sevenpeakssoftware.zubair.ui.cars.ArticleListViewModel

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleListViewModel::class.java)) {
            val db = Room.databaseBuilder(
                activity.applicationContext,
                AppDatabase::class.java,
                "articles"
            ).build()
            @Suppress("UNCHECKED_CAST")
            return ArticleListViewModel(db.articleDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}