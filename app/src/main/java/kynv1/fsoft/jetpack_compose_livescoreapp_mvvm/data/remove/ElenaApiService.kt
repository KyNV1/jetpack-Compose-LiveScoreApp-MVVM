package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove

import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.models.InplayMatchesResponse
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.models.UpcomingMatchesResponse
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.utils.Constants.GET_INPLAY_FIXTURES
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.utils.Constants.GET_UPCOMING_MATCHES
import retrofit2.http.GET

interface ElenaApiService {
    @GET(GET_INPLAY_FIXTURES)
    suspend fun getInplayMatches(): InplayMatchesResponse

    @GET(GET_UPCOMING_MATCHES)
    suspend fun getUpcomingMatches(): UpcomingMatchesResponse
}