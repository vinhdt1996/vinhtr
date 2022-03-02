package com.example.vinhexample.ui.main

import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.vinhexample.R
import com.example.vinhexample.base.BaseFragment
import com.example.vinhexample.databinding.FragmentRegisterBinding
import com.example.vinhexample.ext.isValidEmail
import com.example.vinhexample.ext.isValidPassword
import com.example.vinhexample.param.RegisterParam
import com.example.vinhexample.utils.PopupUtil
import com.example.vinhexample.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(), View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_register

    private val viewModel: RegisterViewModel by viewModel()

    override fun initViews() {
        binding.fragment = this
    }

    override fun initObservers() {
        viewModel.registerLiveData.observe(this) {
            Toast.makeText(activity, "${it?.message}", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

    private fun handleRegister() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString()
        val error = when {
            email.isEmpty() -> getString(R.string.err_email_empty)
            !email.isValidEmail() -> getString(R.string.err_email_invalid)
            password.isEmpty() -> getString(R.string.err_password_empty)
            !password.isValidPassword() -> getString(R.string.err_password_invalid)
            else -> null
        }
        error?.let {
            PopupUtil.showPopupError(error)
            return@handleRegister
        }
        viewModel.register(RegisterParam(email, password))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegister -> handleRegister()
        }
    }
}