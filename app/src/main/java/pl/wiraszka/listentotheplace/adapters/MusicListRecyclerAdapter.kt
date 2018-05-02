package pl.wiraszka.listentotheplace.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.wiraszka.listentotheplace.R
import pl.wiraszka.listentotheplace.holders.MusicListHolder

class MusicListRecyclerAdapter() : RecyclerView.Adapter<MusicListHolder>() {

    override fun getItemCount(): Int {
        return 15 // temporary
    }

    override fun onBindViewHolder(holder: MusicListHolder, position: Int) {
        // here we will update our view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListHolder {
        var musicListItem = LayoutInflater.from(parent?.context).inflate(R.layout.music_list_item, parent, false)
        return MusicListHolder(musicListItem)
    }

}