package com.example.androiddevprojects

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevprojects.ui.theme.AndroidDevProjectsTheme

class thirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevProjectsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeQuadrantApp() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Compose Quadrant",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) {innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column(Modifier.fillMaxSize()) {
                    Row(Modifier.weight(1f)) {
                        ComposeInfoCard(
                            title = stringResource(id = R.string.Text_composable_text),
                            description = stringResource(id = R.string.Text_composable_value),
                            backgroundColor = colorResource(id = R.color.first_quadrant),
                            modifier = Modifier.weight(1f)
                        )
                        ComposeInfoCard(
                            title = stringResource(id = R.string.Image_composable_text),
                            description = stringResource(id = R.string.Image_composable_value),
                            backgroundColor = colorResource(id = R.color.second_quadrant),
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(Modifier.weight(1f)) {
                        ComposeInfoCard(
                            title = stringResource(id = R.string.Column_composable_text),
                            description = stringResource(id = R.string.Column_composable_value),
                            backgroundColor = colorResource(id = R.color.third_quadrant),
                            modifier = Modifier.weight(1f)
                        )
                        ComposeInfoCard(
                            title = stringResource(id = R.string.Row_composable_text),
                            description = stringResource(id = R.string.Row_composable_value),
                            backgroundColor = colorResource(id = R.color.fourth_quadrant),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Button(onClick = {
                    val intent = Intent(context, fifthActivity::class.java)
                    context.startActivity(intent)
                },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "Next",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}

@Composable
fun ComposeInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    AndroidDevProjectsTheme {
        ComposeQuadrantApp()
    }
}