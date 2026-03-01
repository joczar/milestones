package io.github.joczar.milestones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import io.github.joczar.milestones.data.repository.GoalRepository
import io.github.joczar.milestones.ui.goals.GoalListViewModel
import io.github.joczar.milestones.ui.goals.GoalListViewModelFactory
import io.github.joczar.milestones.ui.theme.MilestonesTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: GoalListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as MilestonesApp
        val repository = GoalRepository(
            app.database.goalDao(),
            app.database.stepDao()
        )

        val factory = GoalListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[GoalListViewModel::class.java]

        setContent {
            MilestonesTheme {
                GoalListScreen(viewModel)
            }
        }
    }
}

@Composable
fun GoalListScreen(viewModel: GoalListViewModel) {
    val goals by viewModel.goals.collectAsState(initial = emptyList())

    LazyColumn {
        items(goals) { goal ->
            Text(text = goal.title)
        }
    }
}