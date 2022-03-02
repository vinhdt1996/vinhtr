package com.example.vinhexample.ui.demo

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.vinhexample.R
import com.example.vinhexample.base.BaseFragment
import com.example.vinhexample.databinding.FragmentDemo2Binding
import com.example.vinhexample.ext.visible

class Demo2Fragment : BaseFragment<FragmentDemo2Binding>() {

    override val layoutId: Int
        get() = R.layout.fragment_demo_2

    override val toolbarLayoutId: Int
        get() = R.layout.layout_toolbar

    override fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {
        toolbar?.run {
            findViewById<AppCompatTextView>(R.id.tvTitle)?.text = getString(R.string.demo2)
            findViewById<AppCompatImageButton>(R.id.btnBack)?.run {
                visible()
                setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }
}