package com.example.vinhexample.ui.main

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.vinhexample.MainApplication
import com.example.vinhexample.R
import com.example.vinhexample.base.BaseFragment
import com.example.vinhexample.databinding.FragmentLoginBinding
import com.example.vinhexample.ext.handleErrorAuth
import com.example.vinhexample.param.LoginParam
import com.example.vinhexample.utils.PopupUtil
import com.example.vinhexample.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_login

    private val viewModel: LoginViewModel by viewModel()

    override fun initViews() {
        binding.fragment = this
    }

    override fun initObservers() {
        viewModel.loginLiveData.observe(this) {
            MainApplication.instance.setToken(it?.token)
            findNavController().popBackStack()
        }
    }

    private fun handleLogin() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString()
        val error = context?.handleErrorAuth(email, password)
        error?.let {
            PopupUtil.showPopupError(error)
            return@handleLogin
        }
        viewModel.login(LoginParam(email, password))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> handleLogin()
        }
    }
}