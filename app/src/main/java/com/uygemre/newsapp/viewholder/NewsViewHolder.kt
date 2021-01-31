package com.uygemre.newsapp.viewholder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.uygemre.newsapp.R
import com.uygemre.newsapp.adapter.NewsRecyclerViewClickListener
import com.uygemre.newsapp.dto.NewsDTO
import com.uygemre.newsapp.model.IBaseModel
import com.uygemre.newsapp.ui.NewsDetailActivity

class NewsViewHolder(var view: View) : BaseViewHolder(view) {

    private var newsNameTextView = view.findViewById<TextView>(R.id.txtName)
    private var newsDescriptionTextView = view.findViewById<TextView>(R.id.txtDescription)
    private var newsImageImageview = view.findViewById<ImageView>(R.id.imageNews)
    private var newsContainer = view.findViewById<RelativeLayout>(R.id.newsContainer)

    override fun bindView(
        baseModel: IBaseModel,
        position: Int,
        click: NewsRecyclerViewClickListener
    ) {
        val item = baseModel as NewsDTO
        item.let {
            newsNameTextView.text = item.name
            newsDescriptionTextView.text = item.description
            Glide.with(view.context).load(item.image).into(newsImageImageview)
        }

        newsContainer.setOnClickListener {
            val bundle = Bundle()
            click.onClickListener(position, baseModel)
            val urlIntent = Intent(
                view.context,
                NewsDetailActivity::class.java
            )

            urlIntent.putExtra("url", item.url)
            startActivity(view.context, urlIntent, bundle)
        }
    }
}