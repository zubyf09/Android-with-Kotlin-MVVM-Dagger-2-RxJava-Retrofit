package com.sevenpeakssoftware.zubair.ui.cars

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sevenpeakssoftware.zubair.R
import com.sevenpeakssoftware.zubair.databinding.ItemArticleBinding
import com.sevenpeakssoftware.zubair.model.Article

class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {
    private lateinit var articleList: List<Article>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleListAdapter.ViewHolder {
        val binding: ItemArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_article,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleListAdapter.ViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int {
        return if (::articleList.isInitialized) articleList.size else 0
    }

    fun updateArticleList(postList: List<Article>) {
        this.articleList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ArticleViewModel()

        fun bind(article: Article) {
            viewModel.bind(article)
            binding.viewModel = viewModel
        }
    }
}