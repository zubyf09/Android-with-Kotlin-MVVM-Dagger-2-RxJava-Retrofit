package com.sevenpeakssoftware.zubair.ui.cars

import android.arch.lifecycle.MutableLiveData
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import com.sevenpeakssoftware.zubair.base.BaseViewModel
import com.sevenpeakssoftware.zubair.model.Article
import com.sevenpeakssoftware.zubair.utils.getFormatedDate


class ArticleViewModel : BaseViewModel() {
    private val title = MutableLiveData<String>()
    private val ingress = MutableLiveData<String>()
    private val image = MutableLiveData<String>()
    private val date = MutableLiveData<String>()

    fun bind(article: Article) {
        title.value = article.title
        ingress.value = article.ingress
        image.value = article.image
        date.value = article.dateTime
    }

    fun getTitle(): MutableLiveData<String> {
        return title
    }

    fun getIngress(): MutableLiveData<String> {
        return ingress
    }

    fun getImage(): MutableLiveData<String> {
        return image
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate(): MutableLiveData<String> {

        val modifiedDate = getFormatedDate(date.value.toString())
        date.value = modifiedDate;

        return date
    }
}