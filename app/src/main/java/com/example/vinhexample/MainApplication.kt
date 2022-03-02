package com.example.vinhexample

import android.app.Application
import com.example.vinhexample.di.appModule
import com.example.vinhexample.di.localModule
import com.example.vinhexample.di.remoteModule
import com.example.vinhexample.di.repositoryModule
import com.example.vinhexample.model.User
import com.example.vinhexample.utils.PrefUtil
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    companion object {
        lateinit var instance: MainApplication
            private set
    }

    private val prefUtil: PrefUtil by inject()

    var user: User? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        Stetho.initializeWithDefaults(this)

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(localModule, remoteModule, repositoryModule, appModule))
        }
    }

    fun isNetworkConnected(): Boolean {
        return prefUtil.isNetworkConnected()
    }

    fun setCurrentUser(user: User?) {
//        prefUtil.user = user
        this.user = user
    }

//    fun getUser(): User? = prefUtil.user
//
//    fun clearPref() = prefUtil.clearAllData()

}