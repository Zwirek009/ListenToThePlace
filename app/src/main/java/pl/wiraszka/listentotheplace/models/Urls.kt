package pl.wiraszka.listentotheplace.models

object Urls {
    val ListenToThePlaceUrl = "http://10.0.2.2:48100/api"   // Android emulator localhost

    fun getAllAudioTracksUrl() : String{
        return ListenToThePlaceUrl + "/audiotrack"
    }
}