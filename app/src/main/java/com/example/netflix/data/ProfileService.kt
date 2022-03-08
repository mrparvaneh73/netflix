package com.example.netflix.data

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProfileService {
    @GET("uploads/{photoName}")
    fun getImage(@Path("photoName") photoName: String): Call<ResponseBody>

    @Multipart
    @POST("users/{photoname}")
    fun sendImage(
        @Path("photoname") photoName: String,
        @Part   image: MultipartBody.Part
    ): Call<Any>
}
