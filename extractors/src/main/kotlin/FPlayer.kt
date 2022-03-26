package extractors

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.Request
import okhttp3.internal.EMPTY_REQUEST
import reference.Extractor
import reference.HttpClient
import reference.Video
import reference.VideoServer

class FPlayer : Extractor() {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class FembedResponse(
        val success:Boolean,
        val data:List<FembedData>,
//        val captions : List<SOMETHING> add? maybe?
    ){
        data class FembedData(val file: String, val label:String,val type:String)
    }
    override fun getStreamLinks(name: String, url: String): VideoServer {
        val apiLink = url.replace("/v/", "/api/source/")
        val jsonResponse = HttpClient.newCall(
            Request.Builder().url(apiLink).header("referer", url).post(EMPTY_REQUEST).build()
        ).execute().body!!.string()

        val returnResponse = mutableListOf<Video>()

        if ("\"success\":false" !in jsonResponse) { // if succeeded, then only decode response
            val deserializedJsonResponse = jacksonObjectMapper().readValue<FembedResponse>(jsonResponse)
            deserializedJsonResponse.data.forEach {
                returnResponse.add(
                    Video(
                        name = it.label,
                        url = it.file,
                        isM3U8 = false,
                    )
                )
            }
        }
        return VideoServer(name,returnResponse)
    }
}