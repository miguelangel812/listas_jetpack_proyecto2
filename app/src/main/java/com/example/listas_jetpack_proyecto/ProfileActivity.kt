package com.example.listas_jetpack_proyecto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.listas_jetpack_proyecto.data.Jugador
import com.example.listas_jetpack_proyecto.ui.theme.Listas_jetpack_proyectoTheme

class ProfileActivity : ComponentActivity() {

    private val jugador: Jugador by lazy {
        intent?.getSerializableExtra(JUGADOR_ID) as Jugador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Listas_jetpack_proyectoTheme{
                ProfileVista(jugador = jugador)
            }
        }

    }
    companion object{
        private const val JUGADOR_ID = "Jugador_Id"
        fun newIntent(context: Context, jugador: Jugador) =
            Intent(context, ProfileActivity::class.java).apply{
                putExtra(JUGADOR_ID, jugador)
            }
    }
}