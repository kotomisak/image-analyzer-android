package com.example.android.text

import android.support.test.rule.ActivityTestRule
import com.example.android.analyzer.testutils.CountingAppExecutorsRule
import com.example.android.analyzer.testutils.DataBindingIdlingResourceRule
import com.example.android.analyzer.testutils.SingleFragmentActivity
import com.example.android.analyzer.testutils.TaskExecutorWithIdlingResourceRule
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
class TextSourceDefinitionInstrumentedTest {

	@Rule
	@JvmField
	val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)


	@Rule
	@JvmField
	val executorRule = TaskExecutorWithIdlingResourceRule()

	@Rule
	@JvmField
	val countingAppExecutors = CountingAppExecutorsRule()

	@Rule
	@JvmField
	val dataBindingIdlingResourceRule = DataBindingIdlingResourceRule(activityRule)



	@Test
	fun wrongEmailFormat_shouldDisableLoginButton() {

//		login {
//			email("wrong.email.com")
//			asssertLoginButtonDisabled()
//		}

	}
}