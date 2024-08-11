package com.tes.androidtessuitmedia.ui.screen.firstScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tes.androidtessuitmedia.R
import com.tes.androidtessuitmedia.ui.navigation.Screen
import com.tes.androidtessuitmedia.ui.theme.green
import com.tes.androidtessuitmedia.ui.viewmodel.FirstScreenViewModel
import com.tes.androidtessuitmedia.ui.viewmodel.ViewModelFactory
import androidx.compose.material3.Text as Text
import androidx.compose.ui.platform.LocalContext

@Composable
fun FirstScreen(
    navController: NavController,
    context: Context = LocalContext.current,
    viewModel: FirstScreenViewModel = viewModel(
        factory = ViewModelFactory(context)
    )
) {


    FirstScreenContent(
        name = viewModel.name.value,
        palindrome = viewModel.palindrome.value,
        onNameChange = { viewModel.onNameChange(it) },
        onPalindromChange = { viewModel.onPalindromeChange(it) },
        onPalindromeClick = { viewModel.checkPalindrome(context) },
        onNextClick = {
            navController.navigate(Screen.SecondScreen.createRoute(viewModel.name.value))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreenContent(
    name: String,
    palindrome: String,
    onNameChange: (String) -> Unit,
    onPalindromChange: (String) -> Unit,
    onPalindromeClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(33.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_photo),
                contentDescription = "ic_photo"
            )
            Spacer(modifier = Modifier.padding(bottom = 51.dp))
            TextField(
                value = name,
                onValueChange = onNameChange,
                placeholder = {
                    Text(
                        text = "Name",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.White)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                value = palindrome,
                onValueChange = onPalindromChange,
                placeholder = {
                    Text(
                        text = "Palindrome",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.White)
            )
            Spacer(modifier = Modifier.padding(22.dp))
            Button(
                onClick = {
                    if (palindrome.isNotEmpty()) {
                        onPalindromeClick()
                    }else{
                        Toast.makeText(context, "Not input text", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = green
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "CHECK",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    if (name.isNotEmpty()) {
                        onNextClick()
                    }else{
                        Toast.makeText(context, "Please input your name", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = green
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "NEXT",
                    color = Color.White
                )
            }
        }
    }
}