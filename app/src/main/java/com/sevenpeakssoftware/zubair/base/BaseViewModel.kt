package com.sevenpeakssoftware.zubair.base

import android.arch.lifecycle.ViewModel
import com.sevenpeakssoftware.zubair.injection.component.DaggerViewModelInjector
import com.sevenpeakssoftware.zubair.injection.component.ViewModelInjector
import com.sevenpeakssoftware.zubair.injection.module.NetworkModule
import com.sevenpeakssoftware.zubair.ui.cars.ArticleListViewModel
import com.sevenpeakssoftware.zubair.ui.cars.ArticleViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ArticleListViewModel -> injector.inject(this)
            is ArticleViewModel -> injector.inject(this)
        }
    }
}