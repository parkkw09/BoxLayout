package app.peter.boxlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.peter.boxlayout.ui.theme.BoxLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {


    Column {
        Box(contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.size(width = 400.dp, height = 400.dp)) {
            val height = 200.dp
            val width = 200.dp
            TextCell(text = "1", modifier = Modifier.size(width = width, height = height))
            TextCell(text = "2", modifier = Modifier.size(width = width, height = height))
            TextCell(text = "3", modifier = Modifier.size(width = width, height = height))
        }
        Box(modifier = Modifier.size(width = 290.dp, height = 90.dp)) {
            Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "TopCenter", modifier = Modifier.align(Alignment.TopCenter))
            Text(text = "TopEnd", modifier = Modifier.align(Alignment.TopEnd))

            Text(text = "CenterStart", modifier = Modifier.align(Alignment.CenterStart))
            Text(text = "Center", modifier = Modifier.align(Alignment.Center))
            Text(text = "CenterEnd", modifier = Modifier.align(Alignment.CenterEnd))

            Text(text = "BottomStart", modifier = Modifier.align(Alignment.BottomStart))
            Text(text = "BottomCenter", modifier = Modifier.align(Alignment.BottomCenter))
            Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
        }
        Box(modifier = Modifier
            .size(200.dp)
            .clip(CutCornerShape(30.dp))
            .background(color = Color.Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxLayoutTheme {
        MainScreen()
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier, fontSize: Int = 150) {
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)

    Surface {
        Text(text = text,
            modifier = cellModifier.then(modifier),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}