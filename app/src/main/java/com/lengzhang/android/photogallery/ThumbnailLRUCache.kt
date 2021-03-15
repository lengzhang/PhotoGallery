package com.lengzhang.android.photogallery

import android.graphics.Bitmap
import android.util.LruCache

class ThumbnailLRUCache(maxSize: Int = defaultLruCacheSize) : LruCache<String, Bitmap>(maxSize) {

    override fun sizeOf(key: String?, value: Bitmap?): Int =
        (value?.rowBytes ?: 0) * (value?.height ?: 0) / 1024

    fun getBitmap(url: String): Bitmap? = get(url)

    fun putBitmap(url: String, bitmap: Bitmap) {
        put(url, bitmap)
    }

    companion object {
        val defaultLruCacheSize: Int
            get() {
                val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
                val cacheSize = maxMemory / 8
                return cacheSize
            }
    }
}