package com.example.movieapplication.model

import android.os.Build
import android.os.Handler
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

object MovieLoader{

    @RequiresApi(Build.VERSION_CODES.N)
    fun loadMovie(id: Long): MovieDTO?{
        try {
            val uri = URL("https://api.themoviedb.org/3/movie/${id}?api_key=60898dfa429c5c8d1deb207e46423f7e&language=ru-Ru")

                lateinit var urlConnection: HttpsURLConnection
                try {
                    urlConnection = uri.openConnection()as HttpsURLConnection
                    urlConnection.requestMethod = "GET"
                    urlConnection.addRequestProperty("API_Key", "60898dfa429c5c8d1deb207e46423f7e")
                    urlConnection.readTimeout = 10000
                    val bufferedReader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val lines = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
                        getLinesForOld(bufferedReader)
                    }else{
                        getLines(bufferedReader)
                    }
                    return Gson().fromJson(lines, MovieDTO::class.java)
                } catch (e: Exception){
                    e.printStackTrace()
                }finally {
                    urlConnection.disconnect()
                }
        }catch (e: MalformedURLException){
            Log.e("", "Fail URI", e)
            e.printStackTrace()
        }
        return null
    }


    private fun getLinesForOld(reader: BufferedReader): String {
        val rawData = StringBuilder(1024)
        var tempVariable: String?

        while (reader.readLine().also { tempVariable = it } != null) {
            rawData.append(tempVariable).append("\n")
        }
        reader.close()
        return rawData.toString()
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String{
        return reader.lines().collect(Collectors.joining("\n"))
    }

}