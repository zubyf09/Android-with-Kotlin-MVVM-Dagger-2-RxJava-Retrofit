package com.sevenpeakssoftware.zubair.ui.cars

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.sevenpeakssoftware.zubair.R
import com.sevenpeakssoftware.zubair.base.BaseViewModel
import com.sevenpeakssoftware.zubair.model.Article
import com.sevenpeakssoftware.zubair.model.ArticleDao
import com.sevenpeakssoftware.zubair.network.ArticleApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArticleListViewModel(private val articleDao: ArticleDao) : BaseViewModel() {
    @Inject
    lateinit var articleApi: ArticleApi
    val articleListAdapter: ArticleListAdapter = ArticleListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadArticles() }

    private lateinit var subscription: Disposable

    init {
        loadArticles()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }


    private fun loadArticles() {
        subscription = Observable.fromCallable { articleDao.all }
            .concatMap { dbArticleList ->
                if (dbArticleList.isEmpty())
                    articleApi.getArticles().concatMap { apiArticleResponse ->
                        articleDao.insertAll(apiArticleResponse.content)
                        Observable.just(apiArticleResponse)
                    }
                else
                    Observable.just(dbArticleList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveArticleListStart() }
            .doOnTerminate { onRetrieveArticleListFinish() }
            .subscribe(
                { result -> onRetrieveArticleListSuccess(result as List<Article>) },
                { onRetrieveArticleListError() }
            )
    }

    private fun onRetrieveArticleListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveArticleListFinish() {
        loadingVisibility.value = View.GONE
    }


    private fun onRetrieveArticleListSuccess(articleList: List<Article>) {


        articleListAdapter.updateArticleList(articleList)
    }

    private fun onRetrieveArticleListError() {
        errorMessage.value = R.string.post_error
    }
}