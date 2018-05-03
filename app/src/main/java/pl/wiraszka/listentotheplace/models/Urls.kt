package pl.wiraszka.listentotheplace.models

object Urls {
    val ListenToThePlaceUrl = "http://192.168.56.1:48100/api/audiotrack"

    fun getAllAudioTracksUrl() : String{
        return ListenToThePlaceUrl + "/audiotrack"
    }
}