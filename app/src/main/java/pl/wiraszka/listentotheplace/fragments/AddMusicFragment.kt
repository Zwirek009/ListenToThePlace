package pl.wiraszka.listentotheplace.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_add_music.*

import pl.wiraszka.listentotheplace.R
import pl.wiraszka.listentotheplace.models.AudioTrackToPost
import pl.wiraszka.listentotheplace.providers.AudioTrackDataProvider

class AddMusicFragment : Fragment() {

    private var musicListProvider : AudioTrackDataProvider = AudioTrackDataProvider()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add_audio_track.setOnClickListener{
            postNewAudioTrack()
        }
    }

    private fun postNewAudioTrack() {
        try {
            val audioTrack = AudioTrackToPost()

            audioTrack.name = add_title_input.text.toString()
            audioTrack.performer = add_performer_input.text.toString()
            audioTrack.latitude = add_latitude_input.text.toString().toDouble()
            audioTrack.longtitude = add_longtitude_input.text.toString().toDouble()

            musicListProvider.postNewAudioTrack(audioTrack)
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
