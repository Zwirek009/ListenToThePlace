package pl.wiraszka.listentotheplace.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.music_list_item.view.*
import pl.wiraszka.listentotheplace.R

class MusicListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val resultImageView: ImageView = itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.result_title)
}