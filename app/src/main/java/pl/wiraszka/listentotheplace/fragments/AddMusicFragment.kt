package pl.wiraszka.listentotheplace.fragments


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
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

            add_title_input.text.clear()
            add_performer_input.text.clear()
            add_latitude_input.text.clear()
            add_longtitude_input.text.clear()

            Snackbar.make(view!!, "Audio track added :)", Snackbar.LENGTH_LONG).show()
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
