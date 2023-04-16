package com.databinding.kotlinmvvm.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.databinding.kotlinmvvm.R

class bindingsadapter
{
    companion object{
        @JvmStatic
        @BindingAdapter("myImage")
        fun setImage_url(view:ImageView,url:String) = Glide.with(view.context).load(url).placeholder(
            R.mipmap.ic_launcher_round).into(view)
    }
}