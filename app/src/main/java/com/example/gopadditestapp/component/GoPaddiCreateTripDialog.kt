package com.example.gopadditestapp.component


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral100
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral400
import com.example.gopadditestapp.ui.theme.SatoshiTypography

//


@Composable
fun GopaddiCreateTripDialog(
    onClickStartDate: (() -> Unit)? = null,
    onClickEndDate: (() -> Unit)? = null,
    onCreateTrip: (() -> Unit)? = null,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 32.dp)
            .background(color = Color.White, RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 42.dp),
        ) {
            IconWithActionTextOutlinedCard(
                icon = R.drawable.ic_location,
                headerText = "Where To?",
                subHeaderText = "Select City"
            ) {

            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                IconWithActionTextOutlinedCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_calendar,
                    headerText = "Start Date?",
                    subHeaderText = "Enter Date"
                ) {

                }
                Spacer(modifier = Modifier.width(4.dp))
                IconWithActionTextOutlinedCard(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_calendar,
                    headerText = "End Date?",
                    subHeaderText = "Enter Date"
                ) {

                }
            }
            Spacer(modifier = Modifier.padding(top = 12.dp))
            GoPaddiBlueButton(
                buttonText = "Create Trip",
                enabled = true
            ) {
                onCreateTrip?.invoke()
            }
        }
    }
}

@Preview(
    showBackground = true,

    )
@Composable
fun PreviewGoPaddiCreateTripDialog() {
    GopaddiCreateTripDialog {

    }
}

@Composable
fun IconWithActionTextOutlinedCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    headerText: String,
    subHeaderText: String,
    onClick: () -> Unit
) {

    Surface(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(2.dp),
        color = GoPaddiNeutral100,
        border = BorderStroke(width = 1.dp, color = GoPaddiNeutral400)
    ) {

        Row(
            Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(icon), contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                    style = SatoshiTypography.titleMedium.copy(
                        color = GoPaddiBlack100,
                        fontSize = 14.sp
                    ),
                    text = headerText,
                    fontWeight = FontWeight.W200
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                    style = SatoshiTypography.titleMedium.copy(
                        color = GoPaddiBlack100,
                        fontSize = 14.sp
                    ),
                    text = subHeaderText,
                    fontWeight = FontWeight.W700
                )
            }
        }
    }

}

@Preview(
    showBackground = true,

    )
@Composable
fun PreviewIconWithActionTextOutlinedCard() {
    IconWithActionTextOutlinedCard(
        icon = R.drawable.ic_location,
        headerText = "Where To?",
        subHeaderText = "Select City"
    ) {

    }
}



