package com.example.android.coverage

import android.app.Application
import android.support.annotation.Nullable
import android.util.Log
import android.util.Log.INFO
import com.example.android.core.ApplicationInterface
import com.example.android.core.FeatureCore
import timber.log.Timber
import timber.log.Timber.DebugTree

class CodeCoverageApplication : Application(), ApplicationInterface {
	override fun navigateHome() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onCreate() {
		super.onCreate()

		if (BuildConfig.DEBUG) {
			Timber.plant(DebugTree())
		} else {
			Timber.plant(CrashReportingTree())
		}

		FeatureCore.init(this)
	}

	/** A tree which logs important information for crash reporting.  */
	private class CrashReportingTree : Timber.Tree() {
		override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
			if (priority == Log.VERBOSE || priority == Log.DEBUG) {
				return
			}

			//TODO FakeCrashLibrary.log(priority, tag, message)

			if (t != null) {
				if (priority == Log.ERROR) {
					//TODO FakeCrashLibrary.logError(t)
				} else if (priority == Log.WARN) {
					//TODO FakeCrashLibrary.logWarning(t)
				}
			}
		}

		fun isLoggable(priority: Int, @Nullable tag: String): Boolean {
			return priority >= INFO
		}
	}
}