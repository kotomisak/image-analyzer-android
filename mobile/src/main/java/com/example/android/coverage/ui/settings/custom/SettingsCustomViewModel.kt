package com.example.android.coverage.ui.settings.custom

import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import com.example.android.core.FeatureCore
import com.example.android.core.arch.ObservableViewModel
import com.example.android.core.entity.AppVersion
import javax.inject.Inject

class SettingsCustomViewModel : ObservableViewModel() {

	@Inject
	lateinit var appVersion: AppVersion

	val token: MutableLiveData<String> = MutableLiveData()

	val notificationsEnabled: Boolean @Bindable get() = FeatureCore.notificationsEnabled

	val appVersionString = "${appVersion.versionName} (${appVersion.versionCode})"

	init {
		token.value = "testicek"
	}

//	val token : String = "ddd"

//	fun getToken(): LiveData<String> {
//		val ret = MutableLiveData<String>()
//		ret.value = "..."
//		return ret
//	}

}