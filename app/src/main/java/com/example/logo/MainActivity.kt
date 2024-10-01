package com.example.logo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logo.ui.theme.LogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LogoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LogoScreen(modifier: Modifier = Modifier) {
    var selectedImage by remember { mutableStateOf<Painter?>(null) }
    val image1 = painterResource(id = R.drawable.nike)
    val image2 = painterResource(id = R.drawable.adidas)
    val image3 = painterResource(id = R.drawable.puma)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(350.dp)
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            if (selectedImage != null) {
                Image(
                    painter = selectedImage!!,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text("Логотип", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { selectedImage = image1 },
                modifier = Modifier.size(100.dp), // Квадратная форма кнопок
                shape = RoundedCornerShape(0.dp) // Прямые углы для квадратных кнопок
            ) {
                Text("Кнопка 1")
            }
            Button(
                onClick = { selectedImage = image2 },
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(0.dp)
            ) {
                Text("Кнопка 2")
            }
            Button(
                onClick = { selectedImage = image3 },
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(0.dp)
            ) {
                Text("Кнопка 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogoScreenPreview() {
    LogoTheme {
        LogoScreen()
    }
}
