package com.tes.androidtessuitmedia.ui.screen.thirdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tes.androidtessuitmedia.data.remote.response.User
import com.tes.androidtessuitmedia.ui.navigation.Screen
import com.tes.androidtessuitmedia.ui.screen.component.CustomTopAppBar
import com.tes.androidtessuitmedia.ui.screen.component.UserCard
import com.tes.androidtessuitmedia.ui.viewmodel.ThirdScreenViewModel

@Composable
fun ThirdScreen(
    navController: NavController,
    viewModel: ThirdScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val users by viewModel.users.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = false)

    ThirdScreenContent(
        navController = navController,
        users = users,
        isLoading = isLoading,
        onBackClick = {
            navController.navigate(Screen.FirstScreen.route)
        },
        onUserClick = { selectedUserName ->
            navController.previousBackStackEntry?.savedStateHandle?.set("selectedUserName", selectedUserName)
            navController.popBackStack()
        }
    )
}

@Composable
fun ThirdScreenContent(
    navController: NavController,
    users: List<User>,
    isLoading: Boolean,
    onBackClick: () -> Unit,
    onUserClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                onBackButtonClick = onBackClick,
                title = "Third Screen"
            )
        },
        modifier = Modifier
    ) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    progress = 0.85f,
                    modifier = Modifier.align(Alignment.Center)
                )
            }else{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding)
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp)
                    ) {
                        items(users){ user ->
                            UserCard(
                                user = user,
                                onClick =  { onUserClick("${user.first_name} ${user.last_name}") }
                            )
                        }
                    }
                }
            }
        }
    }
}