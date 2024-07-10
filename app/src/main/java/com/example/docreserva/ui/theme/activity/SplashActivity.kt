package com.example.docreserva.ui.theme.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.docreserva.R
import com.example.docreserva.helper.NavigationStack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF248479)
            ) {
                NavigationStack(this)

            }
        }

    }


}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
 fun SplashScreenView(navController: NavController) {


    CoroutineScope(Dispatchers.Main).launch {
        delay(2000)
        navController.navigate(NavigationStack.Login.route)

    }
    Column {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 150.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.splash_screen_image),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp)

        )
    }
}

