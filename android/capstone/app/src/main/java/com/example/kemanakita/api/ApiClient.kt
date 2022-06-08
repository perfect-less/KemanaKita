package com.example.kemanakita.api

import com.example.kemanakita.preferense.Listdetail
import com.example.kemanakita.preferense.ResponseDestination
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {
    @Multipart
    @POST("api/v1/upload")
    fun uploadImage(
        @Part file: MultipartBody.Part,
    ): Call<Listdetail>
}
class ApiConfig {
    fun getApiService(): ApiService {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://34.101.140.28/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}