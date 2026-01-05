package com.example.gopadditestapp.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoPaddiAppBarBlack(
    @DrawableRes icon: Int = R.drawable.arrow_left,
    titleText: String = "",
    onClickLeftIcon: () -> Unit
) {

    CenterAlignedTopAppBar(
        modifier = Modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            GoPaddiTopAppBar(icon = icon, titleText) {
                onClickLeftIcon()
            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                   "",
                    style = TextStyle(
                        fontWeight = FontWeight(500),
                        fontSize = 20.sp,
                        color = Color.Transparent
                    )
                )
            }
        },
        actions = {}
    )
}

@Composable
fun GoPaddiTopAppBar(
    @DrawableRes icon: Int = R.drawable.arrow_left,
    title: String,
    onClickLeftIcon: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        TextButton(
            contentPadding = ButtonDefaults.TextButtonContentPadding, onClick = onClickLeftIcon
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = icon),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 20.sp
            ),
            text = title,
            fontWeight = FontWeight.W700
        )
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun PreviewAppBar() {
    GoPaddiTestAppTheme {
        GoPaddiTopAppBar(title = "Plan A Trip") { }
    }
}