package com.sevenpeakssoftware.zubair.model

import com.google.gson.annotations.SerializedName


import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

data class ArticleResponse(
        @SerializedName("status_code") var statusCode: String,
        @SerializedName("content") var content: List<Article>
)