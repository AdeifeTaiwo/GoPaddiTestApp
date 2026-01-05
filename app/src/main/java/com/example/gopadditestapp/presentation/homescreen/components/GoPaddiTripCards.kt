package com.example.gopadditestapp.presentation.homescreen.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.GoPaddiBlueButton
import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.data.model.sampleTripList
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral100
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral400
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography

@Composable
fun GoPaddiTripCard(
    modifier: Modifier = Modifier,
    tripInfo: TripInformation = sampleTripList[0],
    onPreview:()-> Unit ={}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(2.dp),
        color = GoPaddiNeutral100,
        border = BorderStroke(width = 1.dp, color = GoPaddiNeutral400)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                painter = painterResource(R.drawable.vintage_trees),
                contentDescription = "Vintage Tress",
            )

            Column {
                Text(
                    fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                    style = SatoshiTypography.titleMedium.copy(
                        color = GoPaddiBlack100,
                        fontSize = 20.sp
                    ),
                    text = tripInfo.tripDescription,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                        style = SatoshiTypography.titleMedium.copy(
                            color = GoPaddiBlack100,
                            fontSize = 16.sp
                        ),
                        text = tripInfo.tripDate,
                        fontWeight = FontWeight.W700
                    )

                    Text(
                        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                        style = SatoshiTypography.titleMedium.copy(
                            color = GoPaddiBlack100,
                            fontSize = 16.sp
                        ),
                        text = tripInfo.tripDuration,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            GoPaddiBlueButton(enabled = true) {
                onPreview()
            }

        }

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
fun PreviewGoPaddiTripCard() {
    GoPaddiTestAppTheme {
        GoPaddiTripCard()
    }
}