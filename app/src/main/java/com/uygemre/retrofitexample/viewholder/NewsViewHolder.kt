package viewholder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.uygemre.retrofitexample.R
import com.uygemre.retrofitexample.adapter.NewsRecyclerViewClickListener
import com.uygemre.retrofitexample.dto.NewsDTO
import com.uygemre.retrofitexample.model.IBaseModel
import com.uygemre.retrofitexample.ui.NewsDetailActivity
import com.uygemre.retrofitexample.viewholder.BaseViewHolder

class NewsViewHolder(var view: View) : BaseViewHolder(view) {

    var newsNameTextView = view.findViewById<TextView>(R.id.txtName)
    var newsDescriptionTextView = view.findViewById<TextView>(R.id.txtDescription)
    var newsImageImageview = view.findViewById<ImageView>(R.id.imageNews)
    var newsContainer: ConstraintLayout = view.findViewById<ConstraintLayout>(R.id.newsContainer)

    override fun bindView(
        baseModel: IBaseModel,
        position: Int,
        click: NewsRecyclerViewClickListener
    ) {
        val item = baseModel as NewsDTO
        item.let {
            newsNameTextView.text = item    .name
            newsDescriptionTextView.text = item.description
            Glide.with(view.context).load(item.image).override(300, 300).into(newsImageImageview)
        }

        newsContainer.setOnClickListener {
            var bundle: Bundle = Bundle()
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
