package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.repository.InplayMatchesRepository
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.viewmodel.states.MatchesState
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class InplayMatchesViewModel @Inject constructor(
    private val inplayMatchesRepository: InplayMatchesRepository,
) : ViewModel() {
    private val _inplayMatchesState = MutableStateFlow<MatchesState>(MatchesState.Empty)
     val inplayMatchesState: StateFlow<MatchesState> = _inplayMatchesState

    init {
        getAllInPlayMatches()
    }
    private fun getAllInPlayMatches() {
        _inplayMatchesState.value = MatchesState.Loading
        viewModelScope.launch {
            // Thực hiện các hoạt động bất đồng bộ ở đây
            try {
                val inplayMatchesResponse = inplayMatchesRepository.getAllInPlayMatches()
                _inplayMatchesState.value = MatchesState.Success(data = inplayMatchesResponse)
            } catch (ex: Exception) {
                _inplayMatchesState.value = MatchesState.Error(" No internet connnection")
            } catch (ex: IOException) {
                _inplayMatchesState.value = MatchesState.Error(" somthing went wron ")
            }
        }
    }

}