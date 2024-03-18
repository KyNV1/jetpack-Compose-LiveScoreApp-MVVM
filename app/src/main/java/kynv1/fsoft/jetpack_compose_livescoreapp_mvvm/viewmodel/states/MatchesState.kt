package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.viewmodel.states

import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.data.remove.models.Match

sealed class MatchesState {
    object Empty : MatchesState()
    object Loading : MatchesState()
    class Success(val data: List<Match>) : MatchesState()
    class Error(val errorMessage: String) : MatchesState()
}