package com.tes.androidtessuitmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.tes.androidtessuitmedia.ui.screen.component.UserCard
import com.tes.androidtessuitmedia.ui.screen.firstScreen.FirstScreen
import com.tes.androidtessuitmedia.ui.screen.secondScreen.SecondScreen
import com.tes.androidtessuitmedia.ui.theme.AndroidTesSuitMediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTesSuitMediaTheme {
                App()
            }
        }
    }
}