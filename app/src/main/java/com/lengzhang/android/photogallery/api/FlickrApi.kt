package com.lengzhang.android.photogallery.api

import com.lengzhang.android.photogallery.FlickrResponse
import retrofit2.Call
import retrofit2.http.GET

private const val apiKey = "f608b045255d6b1bc207d7a7b60a7a95"

interface FlickrApi {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=" + apiKey +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    fun fetchPhotos(): Call<FlickrResponse>
}