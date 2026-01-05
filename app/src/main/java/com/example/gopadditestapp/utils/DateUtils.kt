package com.example.gopadditestapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

object DateUtilsKt {
@RequiresApi(Build.VERSION_CODES.O)
fun daysBetween(
    start: String,
    end: String,
    year: Int = LocalDate.now().year
): Long {

    val formatter = DateTimeFormatter.ofPattern(
        "d MMM, yyyy",
        Locale.getDefault()
    )
    val startDate = LocalDate.parse(start, formatter)
    val endDate = LocalDate.parse(end, formatter)

    return ChronoUnit.DAYS.between(startDate, endDate)
}
}