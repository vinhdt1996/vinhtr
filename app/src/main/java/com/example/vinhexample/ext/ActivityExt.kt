package com.example.vinhexample.ext

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.vinhexample.R
import com.google.android.material.appbar.AppBarLayout

fun AppCompatActivity.addToolbar(
    toolbarLayoutId: Int,
    viewGroup: ViewGroup?,
    toolbarCallback: ((activity: AppCompatActivity?, toolbar: Toolbar?) -> Unit)? = null
) {
    viewGroup?.findViewById<AppBarLayout>(R.id.appBarLayout)?.apply {
        viewGroup.removeView(this)
    }

    val toolbarItem = layoutInflater.inflate(toolbarLayoutId, viewGroup, false) ?: return
    toolbarItem.stateListAnimator = null
    viewGroup?.addView(toolbarItem)

    val toolbar = toolbarItem.findViewById<Toolbar>(R.id.toolbar)

    val stateListAnimator = StateListAnimator()
    stateListAnimator.addState(
        IntArray(0),
        ObjectAnimator.ofFloat(toolbar, "elevation", 0f)
    )
    toolbar.stateListAnimator = stateListAnimator
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowTitleEnabled(false)
    toolbarCallback?.invoke(this, toolbar)
}