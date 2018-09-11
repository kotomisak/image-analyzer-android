package com.example.android.coverage.ui.settings.system

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.preference.ListPreference
import android.support.v7.preference.PreferenceFragmentCompat
import android.support.v7.preference.PreferenceManager
import com.example.android.coverage.R

class SettingsSystemFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

	lateinit var sharedPreferences: SharedPreferences

	override fun onCreatePreferences(p0: Bundle?, p1: String?) {
		addPreferencesFromResource(R.xml.preferences);
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
		onSharedPreferenceChanged(sharedPreferences, getString(R.string.settings_arch_key));
	}

	override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
		if (sharedPreferences != null) {
			val preference = findPreference(key)
			if (preference is ListPreference) {
				val prefIndex = preference.findIndexOfValue(sharedPreferences.getString(key, ""))
				if (prefIndex >= 0) {
					preference.setSummary(preference.entries[prefIndex])
				}
			} else {
				preference.summary = sharedPreferences.getString(key, "")

			}
		}
	}

//	override fun onPreferenceTreeClick(preference: Preference?): Boolean {
//		return when (preference.key) {
//			getString(R.string.pref_key_change_password) -> {
//				startActivity(Intent(activity, ChangePasswordActivity::class.java))
//				true
//			}
//			else -> {
//				super.onPreferenceTreeClick(preference)
//			}
//		}
//	}

	override fun onResume() {
		super.onResume()
		sharedPreferences.registerOnSharedPreferenceChangeListener(this)
	}

	override fun onPause() {
		super.onPause()
		sharedPreferences.registerOnSharedPreferenceChangeListener(this)
	}
}