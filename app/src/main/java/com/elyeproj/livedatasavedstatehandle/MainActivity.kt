package com.elyeproj.livedatasavedstatehandle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    private val textDataObserver =
        Observer<String> { data -> text_view.text = data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.textDataNotifier.observe(this, textDataObserver)
        btn_fetch.setOnClickListener { viewModel.fetchValue() }
    }
}
