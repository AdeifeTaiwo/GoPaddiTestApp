package com.example.gopadditestapp.utils

import android.util.Log
import com.google.gson.Gson
import org.json.JSONException

object StringUtils {
    @JvmStatic
    fun getErrorBodyMessage(errorBodyString: String): String {
        var errorMsg = ""
        try {
            val gson = Gson()
            val apiError = gson.fromJson(errorBodyString, ApiError::class.java)
            val message = apiError.message ?: "Unknown error"
            errorMsg = message
            Log.e("API_ERROR", message)

        } catch (e: JSONException) {
            e.printStackTrace()
            errorMsg = "Something went wrong. Please try again later."
        }
        return errorMsg
    }
}

data class ApiError(
    val errorCode: String?,
    val message: String?
)
