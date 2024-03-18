package kynv1.fsoft.jetpack_compose_livescoreapp_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.ui.theme.JetpackComposeLiveScoreAppMVVMTheme
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.viewmodel.InplayMatchesViewModel
import kynv1.fsoft.jetpack_compose_livescoreapp_mvvm.viewmodel.states.MatchesState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLiveScoreAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun LiveScore(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopAppBar()
        FetchData()
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
        }
        Text(text = "LiveScores", style = MaterialTheme.typography.h4)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.modeicon),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun TopAppbarPreview() {
    TopAppBar()
}

@Composable
fun FetchData(
    modifier: Modifier = Modifier,
    inplayMatchesViewModel: InplayMatchesViewModel = viewModel(),
) {
    Column(modifier = modifier) {
        val state = inplayMatchesViewModel.inplayMatchesState.collectAsState()
        when (state.value) {
            is MatchesState.Empty -> Text(text = "no data available")
            is MatchesState.Loading -> Text(text = "Loading....")
            is MatchesState.Success -> Text(text = "Successful!")
            is MatchesState.Error -> Text(text = (state.value as MatchesState.Error).errorMessage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LiveScorePreview() {
    JetpackComposeLiveScoreAppMVVMTheme {
        LiveScore()
    }
}