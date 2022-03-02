package com.example.vinhexample.ui.demo

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.vinhexample.MainApplication
import com.example.vinhexample.R
import com.example.vinhexample.base.BaseFragment
import com.example.vinhexample.constant.Constant.DEFAULT_EMAIL
import com.example.vinhexample.constant.Constant.DEFAULT_FCM_TOKEN
import com.example.vinhexample.constant.Constant.DEFAULT_PASSWORD
import com.example.vinhexample.databinding.FragmentDemo1Binding
import com.example.vinhexample.ext.gone
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.utils.PopupUtil
import com.example.vinhexample.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Demo1Fragment : BaseFragment<FragmentDemo1Binding>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.fragment_demo_1

    override val toolbarLayoutId: Int
        get() = R.layout.layout_toolbar

    private val viewModel: LoginViewModel by viewModel()

    override fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {
        toolbar?.run {
            findViewById<AppCompatTextView>(R.id.tvTitle)?.text = getString(R.string.demo1)
            findViewById<AppCompatImageButton>(R.id.btnBack)?.gone()
        }
    }

    override fun initViews() {
        binding.fragment = this
    }

    override fun initObservers() {
        viewModel.loginLiveData.observe(this) {
            MainApplication.instance.setCurrentUser(it)
            startActivity(Intent(activity, HomeDemoActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            })
            activity?.finish()
//            Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
        }

        viewModel.errorLiveData.observe(this) {
            PopupUtil.showPopupError(it.first)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGoTo2 -> {
                val action = Demo1FragmentDirections.actionDemo1ToDemo2()
                findNavController().navigate(action)
            }
            R.id.btnLogin -> {
                viewModel.login(LoginParam(DEFAULT_EMAIL, DEFAULT_PASSWORD, DEFAULT_FCM_TOKEN))
            }
        }
    }


}