package com.example.modernapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.modernapp.R
import com.example.modernapp.ui.components.AnimatedItem
import com.example.modernapp.ui.theme.DarkBlue
import com.example.modernapp.ui.theme.LightBLue
import kotlinx.coroutines.delay

@SuppressLint("RememberReturnType")
@Composable
fun IntroScreen(onGetSatedClick: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(100)
        isVisible = true
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Box(
//            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(R.drawable.women),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(R.drawable.arc_1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBLue)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Spacer(modifier = Modifier.height(32.dp))

            AnimatedItem(visible = isVisible, delay = 300) {
                Text(
                    text = "Welcome\nto RevStorm Compony",
                    color = Color.Black,
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            AnimatedItem(visible = isVisible, delay = 300) {
                Text(
                    text = "Moaaz android Dev\n" +
                            "Moaaz Software testing\n" +
                            "Moaaz flutter Dev\n" +
                            "Moaaz ios Dev\n",
                    color = Color.Gray,
                    lineHeight = 32.sp,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 32.dp),
//                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            AnimatedItem(visible = isVisible, delay = 600) {
                Button(
                    onClick = onGetSatedClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .zIndex(1f),          // يضع الزر فوق أي عناصر تتراكب
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        "Get Started",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntroScreenPreview() {
    IntroScreen(
        onGetSatedClick = {

        }
    )
}
