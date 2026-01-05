package com.example.gopadditestapp.presentation.selectdate.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral600
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography

@Composable
fun SelectedDateContainer(
    modifier: Modifier = Modifier,
    headerText: String = "----------",
    selectedDate: String
){
    Column(modifier = modifier) {


        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_regular)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 16.sp
            ),
            text = headerText,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(2.dp),
            color = Color.White,
            border = BorderStroke(width = 1.dp, color = GoPaddiNeutral600)
        ) {

            Row(
                Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                    Text(
                        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                        style = SatoshiTypography.titleMedium.copy(
                            color = GoPaddiBlack100,
                            fontSize = 14.sp
                        ),
                        text = selectedDate.ifEmpty { "Select Date" },
                        fontWeight = FontWeight.W700
                    )

                Image(painter = painterResource(R.drawable.ic_calendar), contentDescription = "")

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
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
fun PreviewelectedDateContainer() {
    GoPaddiTestAppTheme {
        SelectedDateContainer(
            modifier = Modifier,
            headerText = "Start Date",
            selectedDate = "4th Feb, 2021"
        )
    }
}