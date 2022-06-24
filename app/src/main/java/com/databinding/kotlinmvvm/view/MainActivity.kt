package com.databinding.kotlinmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.databinding.kotlinmvvm.R
import com.databinding.kotlinmvvm.databinding.ActivityMainBinding
import com.databinding.kotlinmvvm.handler.MainHandler
import com.databinding.kotlinmvvm.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel: MyViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.handler = MainHandler(this)
        viewmodel = ViewModelProvider(this).get(MyViewModel::class.java)
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerVw.layoutManager = linearLayoutManager
    }
}