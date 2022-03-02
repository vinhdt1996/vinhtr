package com.example.vinhexample.utils

import androidx.databinding.ViewDataBinding
import com.example.vinhexample.R
import com.example.vinhexample.databinding.LayoutPopupBinding
import com.example.vinhexample.listener.PopUpListener
import com.example.vinhexample.vo.PopUp

object PopupUtil {
    fun showLoading() {
        AppEvent.notifyShowPopUp()
    }

    fun hideAllPopup() {
        AppEvent.notifyClosePopUp()
    }

    fun showPopupError(msg: String) {
        AppEvent.notifyShowPopUp(
            PopUp(
                R.layout.layout_popup,
                callback = { binding: ViewDataBinding?, _, _ ->
                    (binding as? LayoutPopupBinding)?.apply {
                        title = "Error"
                        message = msg
                        center = "Close"
                        clickListener = PopUpListener(
                            clickCenterListener = { AppEvent.notifyClosePopUp() }
                        )
                    }
                }
            )
        )
    }
}