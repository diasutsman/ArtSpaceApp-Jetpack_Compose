package com.dias.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dias.artspaceapp.data.Artwork
import com.dias.artspaceapp.data.DataSource
import com.dias.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
            ),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        var index by remember { mutableStateOf(0) }
        val artwork = DataSource.artworks[index]
        ArtworkWall(artwork = artwork)
        ArtworkDescriptor(artwork = artwork)
        DisplayController(
            onNext = { index = (index + 1) % DataSource.artworks.size },
            onPrevious = { index = if (index == 0) DataSource.artworks.size - 1 else index - 1 }
        )
    }
}

@Composable
fun ArtworkWall(artwork: Artwork) {
    val image = painterResource(id = artwork.imageId)
    val aspectRatio = image.intrinsicSize.width / image.intrinsicSize.height
    Surface(
        elevation = 16.dp,
    ) {
        Image(
            painter = image,
            contentDescription = artwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                )
                .padding(32.dp)
                .aspectRatio(aspectRatio)
        )
    }

}

@Composable
fun ArtworkDescriptor(artwork: Artwork) {
    Surface(
        elevation = 16.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                artwork.title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
            )
            Text(
                stringResource(R.string.artist_name_year, artwork.artist, artwork.year),
                fontSize = 18.sp,
            )
        }
    }
}

@Composable
fun DisplayController(onPrevious: () -> Unit, onNext: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Button(
            onClick = onPrevious,
            content = { Text("Previous") },
            modifier = Modifier.weight(1f).padding(16.dp)
        )

        Button(
            onClick = onNext,
            content = { Text("Next") },
            modifier = Modifier.weight(1f).padding(16.dp)
        )
    }
}
