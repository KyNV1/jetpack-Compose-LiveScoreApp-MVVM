package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.repository

import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.ElenaApiService
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.models.Match
import javax.inject.Inject

class InplayMatchesRepository @Inject constructor(
    private  val elenaApiService: ElenaApiService
) {
    suspend fun getAllInPlayMatches():List<Match> = elenaApiService.getInplayMatches().data
}