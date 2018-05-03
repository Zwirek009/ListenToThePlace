package pl.wiraszka.listentotheplace.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.wiraszka.listentotheplace.R
import pl.wiraszka.listentotheplace.holders.MusicListHolder
import pl.wiraszka.listentotheplace.models.AudioTrack

class MusicListRecyclerAdapter() : RecyclerView.Adapter<MusicListHolder>() {

    val currentResults: ArrayList<AudioTrack> = ArrayList<AudioTrack>()

    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(holder: MusicListHolder, position: Int) {
        var audioTrack = currentResults[position]

        holder?.updateWithAudioTrack(audioTrack)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListHolder {
        var musicListItem = LayoutInflater.from(parent?.context).inflate(R.layout.music_list_item, parent, false)
        return MusicListHolder(musicListItem)
    }

}