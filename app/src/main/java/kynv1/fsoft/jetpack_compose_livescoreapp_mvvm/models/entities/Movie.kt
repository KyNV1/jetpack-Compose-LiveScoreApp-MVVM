package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.models.entities

import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.models.Keyword
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.models.Review
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.models.Video

data class Movie(
    var page: Int,
    var keywords: List<Keyword>? = ArrayList(),
    var videos: List<Video>? = ArrayList(),
    var reviews: List<Review>? = ArrayList(),
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String?,
    val genre_ids: List<Int>,
    val id: Long,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Float
)
