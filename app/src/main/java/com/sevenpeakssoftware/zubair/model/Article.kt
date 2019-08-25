package com.sevenpeakssoftware.zubair.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Article(
        @field:PrimaryKey
        val id: Int,
        val title: String,
        val dateTime:String,
        val ingress:String,
        val image:String,
        val created:Double,
        val changed:Double
)