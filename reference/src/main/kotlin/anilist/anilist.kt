package anilist

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Suppress("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Media(
    val id: Int?,
    val isAdult: Boolean?,
    val status: String?,
    val chapters: Int?,
    val episodes: Int?,
    val nextAiringEpisode: AnilistEpisode?,
    val title : AnilistTitle?,
    val startDate:AnilistDate?,
    val endDate:AnilistDate?,
    val genres:List<String>?,
    val seasonYear:Int?,
    val idMal: Int?,
    val countryOfOrigin: String?,
    val format: String?,
    val season:String?,
){
    data class AnilistEpisode(val airingAt: Int?,val episode: Int?)
    data class AnilistTitle(val english: String?, val romaji: String?, val userPreferred: String?)
    data class AnilistDate(val day:Int?,val month:Int?, val year: Int?)
}