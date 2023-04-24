package com.example.stateinjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateinjetpack.ui.theme.StateInJetPackTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorBox(modifier = Modifier.fillMaxSize())
        }
    }
}
@Composable
fun ColorBox(modifier: Modifier=Modifier){
    val color= remember {
        mutableStateOf(Color.Yellow)
    }
    Box(modifier = Modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }
    ) {
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateInJetPackTheme {
        ColorBox(modifier = Modifier.fillMaxSize())
    }
}