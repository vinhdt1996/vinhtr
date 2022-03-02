package com.example.vinhexample.ui.main

import android.view.View
import com.example.vinhexample.R
import com.example.vinhexample.base.BaseFragment
import com.example.vinhexample.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_login

//    override val toolbarLayoutId: Int
//        get() = R.layout.layout_toolbar
//
//    override fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {
//        toolbar?.run {
//            findViewById<AppCompatTextView>(R.id.tvTitle)?.text = getString(R.string.login)
//            findViewById<AppCompatImageButton>(R.id.btnBack)?.run {
//                visible()
//                setOnClickListener {
//                    findNavController().popBackStack()
//                }
//            }
//        }
//    }

    override fun onClick(v: View?) {

    }
}