package com.example.docreserva.ui.theme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.docreserva.ui.theme.fragment.HomeFragment

class HomeActivity : ComponentActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, HomeActivity::class.java)

            context.startActivity(starter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = Color.White
            ) {
                HomeFragment()

            }
        }


    }
}