package com.lengzhang.android.photogallery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PhotoPageActivity : AppCompatActivity() {

    private var currentFragment: PhotoPageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_page)

        val fm = supportFragmentManager
        currentFragment = fm.findFragmentById(R.id.fragment_container) as PhotoPageFragment?

        if (currentFragment == null) {
            val fragment = PhotoPageFragment.newInstance(intent.data as Uri)
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
            currentFragment = fragment
        }
    }

    override fun onBackPressed() {
        val webView = currentFragment?.getWebView()

        if (webView?.canGoBack() == true) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        fun newIntent(context: Context, photoPageUri: Uri): Intent {
            return Intent(context, PhotoPageActivity::class.java).apply {
                data = photoPageUri
            }
        }
    }
}