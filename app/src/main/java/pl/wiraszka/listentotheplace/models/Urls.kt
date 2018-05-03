package pl.wiraszka.listentotheplace.models

object Urls {
    val ListenToThePlaceUrl = "192.168.0.1:48100/api"

    fun getAllAudioTracksUrl() : String{
        return ListenToThePlaceUrl + "/audiotrack"
    }
}