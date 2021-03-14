package com.lengzhang.android.photogallery.api

import com.google.gson.annotations.SerializedName
import com.lengzhang.android.photogallery.GalleryItem

class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}