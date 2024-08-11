package com.tes.androidtessuitmedia.ui.screen.secondScreen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tes.androidtessuitmedia.ui.navigation.Screen
import com.tes.androidtessuitmedia.ui.screen.component.CustomTopAppBar
import com.tes.androidtessuitmedia.ui.theme.green
import com.tes.androidtessuitmedia.ui.viewmodel.SecondScreenViewModel
import com.tes.androidtessuitmedia.ui.viewmodel.ViewModelFactory

@Composable
fun SecondScreen(
    navController: NavController,
    userName: String,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    viewModel: SecondScreenViewModel = viewModel(
        factory = ViewModelFactory(context)
    )
) {

    val selectedUserName by viewModel.selectedUserName

    LaunchedEffect(userName) {
        viewModel.setUserName(userName)
        val userNameFromThirdScreen = navController.currentBackStackEntry?.savedStateHandle?.get<String>("selectedUserName")
        userNameFromThirdScreen?.let {
            viewModel.setSelectedUserName(it)
        }
    }

   SecondScreenContent(
       userName = userName,
       selectedUserName = selectedUserName ?: "Selected User Name",
       onBackClick = {
           navController.navigate(Screen.FirstScreen.route)
       },
       onChooseUserClick = {
           navController.navigate(Screen.ThirdScreen.route)
       }
   )
}

@Composable
fun SecondScreenContent(
    userName: String,
    selectedUserName: String,
    onBackClick: () -> Unit,
    onChooseUserClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                onBackButtonClick = onBackClick,
                title = "Second Screen"
            )
        },
        modifier = Modifier
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Welcome",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = userName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = if(selectedUserName.isNullOrEmpty()) "Selected User Name" else selectedUserName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onChooseUserClick,
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = green
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Choose a User",
                    color = Color.White
                )
            }
        }
    }
}