package com.example.vinhexample.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.example.vinhexample.R
import com.example.vinhexample.constant.Constant
import com.example.vinhexample.ext.addToolbar
import com.example.vinhexample.utils.AppEvent
import com.example.vinhexample.utils.PopupEventListener
import com.example.vinhexample.vo.PopUp
import com.example.vinhexample.widget.BottomPopupDialog
import com.example.vinhexample.widget.PopupDialog
import com.google.android.material.appbar.AppBarLayout
import java.util.concurrent.CopyOnWriteArraySet

abstract class BaseActivity<Binding: ViewDataBinding>: AppCompatActivity(), PopupEventListener {

    lateinit var binding: Binding

    abstract val layoutId: Int

    private var listPopupDialogFragment: Set<DialogFragment> = CopyOnWriteArraySet()

    open val toolbarLayoutId: Int = Constant.DEFAULT_TOOLBAR_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppEvent.registerPopupEventListener(this)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        initToolbar()
        initViews()
        initObservers()
    }

    private fun initToolbar(toolbarLayoutId: Int = this.toolbarLayoutId) {
        if (toolbarLayoutId == Constant.DEFAULT_TOOLBAR_ID) return
        addToolbar(
            toolbarLayoutId = toolbarLayoutId,
            viewGroup = binding.root as? ViewGroup,
            toolbarCallback = { curActivity, toolbar ->
                toolbarFunc(curActivity, toolbar)
            }
        )
    }

    override fun onShowPopup(popup: PopUp?) {
        onClosePopup()
        val popupDialogFragment = if (popup?.isBottomSheet == true)
            BottomPopupDialog.newInstance(popup) else PopupDialog.newInstance(popup)
        popupDialogFragment.show(supportFragmentManager, PopupDialog().tag)
        listPopupDialogFragment = listPopupDialogFragment.plus(popupDialogFragment)
    }

    override fun onClosePopup() {
        for (item in listPopupDialogFragment) {
            item.dismissAllowingStateLoss()
            listPopupDialogFragment = listPopupDialogFragment.minus(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppEvent.unregisterPopupEventListener(this)
    }

    open fun toolbarFunc(curActivity: AppCompatActivity?, toolbar: Toolbar?) {}

    open fun initViews(){}

    open fun initObservers(){}

    fun removeToolbar() {
        (binding.root as? ViewGroup)?.findViewById<AppBarLayout>(R.id.appBarLayout)?.apply {
            (binding.root as? ViewGroup)?.removeView(this)
        }
    }
}