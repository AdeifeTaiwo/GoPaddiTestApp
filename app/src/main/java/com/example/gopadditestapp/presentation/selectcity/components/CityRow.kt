package com.example.gopadditestapp.presentation.selectcity.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.data.model.City
import com.example.gopadditestapp.data.model.cities
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiBlackSecondary
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography

@Composable
fun CityRow(
    city: City,
    onSelectedItem: (City) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .clickable(
                enabled = true,
                onClick = { onSelectedItem(city) }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.weight(0.1f),
            painter = painterResource(R.drawable.ic_location_big),
            contentDescription = "Location Icon"
        )

        Column(modifier = Modifier.weight(0.7f)) {
            Text(
                fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlack100,
                    fontSize = 20.sp
                ),
                text = city.country,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlackSecondary,
                    fontSize = 16.sp
                ),
                text = city.airport,
                fontWeight = FontWeight.Normal
            )
        }

        Column(modifier = Modifier.weight(0.1f)) {
            Text(
                fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlack100,
                    fontSize = 22.sp
                ),
                text = city.flag,
                fontWeight = FontWeight.W700
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlackSecondary,
                    fontSize = 16.sp
                ),
                text = city.countryCode,
                fontWeight = FontWeight.Normal
            )
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
fun PreviewCityRow() {
    GoPaddiTestAppTheme {
        CityRow(
            city = cities[0],

            ) {

        }
    }
}
