package com.example.listas_jetpack_proyecto

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listas_jetpack_proyecto.data.Jugador
import com.example.listas_jetpack_proyecto.ui.theme.Listas_jetpack_proyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Listas_jetpack_proyectoTheme {
                MyApp{
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (Jugador) -> Unit){
    Scaffold(
        content = {
            Image(painter = painterResource(id = R.drawable.escudo), contentDescription = null,contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxHeight())
            HomeContent(navigateToProfile = navigateToProfile)
        }
    )
}

