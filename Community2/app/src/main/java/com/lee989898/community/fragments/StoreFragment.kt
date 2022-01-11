package com.lee989898.community.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.lee989898.community.R


class StoreFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_store, container, false)

        val webView: WebView = view.findViewById(R.id.storeWebView)
        webView.loadUrl("https://www.inflearn.com/")


        // Inflate the layout for this fragment
        return view
    }


}