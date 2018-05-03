package pl.wiraszka.listentotheplace.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_music_list.*

import pl.wiraszka.listentotheplace.R
import pl.wiraszka.listentotheplace.adapters.MusicListRecyclerAdapter
import pl.wiraszka.listentotheplace.providers.AudioTrackDataProvider

class MusicListFragment : Fragment() {

    private var musicListProvider : AudioTrackDataProvider = AudioTrackDataProvider()
    var musicListRecycler: RecyclerView? = null
    var refresher: SwipeRefreshLayout? = null
    var adapter: MusicListRecyclerAdapter = MusicListRecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_music_list, container, false)

        musicListRecycler = view.findViewById<RecyclerView>(R.id.music_list_recycler)
        refresher = view.findViewById<SwipeRefreshLayout>(R.id.refresher)

        musicListRecycler!!.layoutManager = LinearLayoutManager(context)
        musicListRecycler!!.adapter = adapter

        refresher?.setOnRefreshListener {
            refresher?.isRefreshing = true
            getAllAudioTracks()
        }

        getAllAudioTracks()

        return view
    }

    private fun getAllAudioTracks(){
        refresher?.isRefreshing = true

        try {
            musicListProvider.getAll({ audioTrackQueryData ->
                adapter.currentResults.clear()
                adapter.currentResults.addAll(audioTrackQueryData.audioTracks)
                activity!!.runOnUiThread {
                    adapter.notifyDataSetChanged()
                    refresher?.isRefreshing = false
                }
            })
        }
        catch(ex: Exception){
            // show alert to the user
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("Oh crap! Something went wrong :(")
            val dialog = builder.create()
            dialog.show()
        }
    }


}
