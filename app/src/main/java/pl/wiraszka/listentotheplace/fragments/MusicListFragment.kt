package pl.wiraszka.listentotheplace.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_music_list.*

import pl.wiraszka.listentotheplace.R
import pl.wiraszka.listentotheplace.adapters.MusicListRecyclerAdapter

class MusicListFragment : Fragment() {

    var musicListRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_music_list, container, false)

        musicListRecycler = view.findViewById<RecyclerView>(R.id.music_list_recycler)

        musicListRecycler!!.layoutManager = LinearLayoutManager(context)
        musicListRecycler!!.adapter = MusicListRecyclerAdapter()

        return view
    }


}
