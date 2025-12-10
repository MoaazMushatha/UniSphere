package com.example.modernapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modernapp.R
import com.example.modernapp.ui.theme.DarkBlue
import com.example.modernapp.ui.theme.LightBLue
import com.example.modernapp.ui.theme.OvalBackground

@Composable
@Preview

fun ProfileScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBLue)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(DarkBlue)
        ) {
            Image(
                painter = painterResource(R.drawable.arc_3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(R.drawable.user_2),
                contentDescription = null,
                Modifier.align(Alignment.BottomCenter)
//                    .padding(top = 60.dp)
            )
            Text(
                text = "Profile",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 48.dp, start = 32.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(OvalBackground)
                    .clickable { onBackClick() }
                    .align(Alignment.TopStart), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(R.drawable.back), contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Moaaz Mushatha",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBlue,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Moaaz.m.2021@gmial.com",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        ProfileMenuItem(iconRes = R.drawable.btn_1, title = "Notifications")
        ProfileMenuItem(iconRes = R.drawable.btn_2, title = "Calendar")
        ProfileMenuItem(iconRes = R.drawable.btn_3, title = "Gallery")
        ProfileMenuItem(iconRes = R.drawable.btn_4, title = "My playlist")
        ProfileMenuItem(iconRes = R.drawable.btn_5, title = "Share")
        ProfileMenuItem(iconRes = R.drawable.btn_6, title = "Logout", showArrow = false)

        Spacer(modifier = Modifier.height(80.dp))

    }
}

@Composable

fun ProfileMenuItem(
    iconRes: Int,
    title: String,
    showArrow: Boolean = true,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .clickable {},
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = DarkBlue,
            modifier = Modifier.weight(1f)
        )

        if (showArrow) Image(
            painter = painterResource(R.drawable.arrow), contentDescription = null
        )
    }
}

@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBlue
        )
    }
}


