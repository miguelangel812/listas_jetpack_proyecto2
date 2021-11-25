package com.example.listas_jetpack_proyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.listas_jetpack_proyecto.data.DataJugadores
import com.example.listas_jetpack_proyecto.data.DataJugadores.lista_jugadores
import com.example.listas_jetpack_proyecto.data.Jugador

@Composable
fun ProfileVista(jugador: Jugador){

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints() {
            Surface{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                    ProfileHeader(jugador = jugador, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(jugador = jugador, containerHeight =this@BoxWithConstraints.maxHeight )
                }
            }

        }
    }

}
@Composable
private fun ProfileHeader(
    jugador: Jugador,
    containerHeight: Dp
){
    Image(modifier = Modifier
        .heightIn(max = containerHeight / 2)
        .fillMaxWidth(),
        painter = painterResource(id = jugador.jugImageId),
        contentScale = ContentScale.Fit,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(jugador: Jugador,containerHeight: Dp){
    Column{
        Title(jugador = jugador)
        ProfileProperty(label= stringResource(id = R.string.posicion),value=jugador.pos)
        ProfileProperty(label= stringResource(id = R.string.dorsal),value=jugador.dorsal)
        ProfileProperty(label= stringResource(id = R.string.edad),value=jugador.edad)
        Trayectoria(label= stringResource(id = R.string.descripcion),value=jugador.des,id = jugador.id.toInt())
        Spacer(modifier = Modifier.height((containerHeight - 350.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(jugador: Jugador){

    Column(modifier = Modifier
        .padding(16.dp)) {
        Text(
            text = jugador.nombre,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}
@Composable
private fun ProfileProperty(label:String,value:String){

    Column(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp,bottom = 16.dp)) {

        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}
@Composable
private fun Trayectoria(label:String,value:String,id: Int){

    Column(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp,bottom = 16.dp)) {

        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Bold

        )
        TextFieldDemo(value,id)
    }
}
@Composable
fun TextFieldDemo(value: String,id: Int) {
    Column(modifier = Modifier
        //.padding(start = 16.dp, end = 16.dp,bottom = 16.dp)
        .background(color = Color.White)
    ) {
        val texto = remember { mutableStateOf(value) }
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            ),
            value = texto.value,
            onValueChange = { texto.value = it }

        )
        lista_jugadores[id].des = texto.value
    }
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
            lista_jugadores.toMutableList().removeAt(id).id
        }) {
        Text(text = "Eliminar")
    }
}

/*
TextFieldDemo(
            text = value,
            modifier = Modifier.height(100.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
*/