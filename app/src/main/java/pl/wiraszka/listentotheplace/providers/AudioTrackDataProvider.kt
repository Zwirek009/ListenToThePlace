package pl.wiraszka.listentotheplace.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import pl.wiraszka.listentotheplace.models.AudioTrack
import pl.wiraszka.listentotheplace.models.AudioTrackToPost
import pl.wiraszka.listentotheplace.models.AudioTracksResult
import pl.wiraszka.listentotheplace.models.Urls
import java.io.Reader

class AudioTrackDataProvider {

    init{
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "ListenToThePlace Android app")
    }

    fun getAll(responseHandler: (result: AudioTracksResult) -> Unit?){
        Urls.basicAudiotrackEndpoint().httpGet()
                .responseObject(AudioTrackDataDeserializer()){_, response, result ->
                    if(response.statusCode != 200){
                        throw Exception("Unable to get all audio tracks")
                    }
                    val(data,_) = result
                    responseHandler.invoke(data as AudioTracksResult)
                }
    }

    fun postNewAudioTrack(audioTrack: AudioTrackToPost)
    {
        Urls.basicAudiotrackEndpoint().httpPost()
                .body(Gson().toJson(audioTrack))
                .header("Content-Type" to "application/json", "Accept" to "application/json")
                .response( { _, response, _ ->
                    if(response.statusCode != 201) {
                        throw Exception("Unable to post an audio track")
                    }
        })
    }

    class AudioTrackDataDeserializer : ResponseDeserializable<AudioTracksResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, AudioTracksResult::class.java)
    }
}