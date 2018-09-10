package com.example.android.core.arch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.example.android.core.di.Injectable
import javax.inject.Inject

abstract class BaseFragment : Fragment(), Injectable {

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	inline fun <reified VM : ViewModel> findViewModel(viewModel: Class<VM>, ofLifecycleOwner: Fragment = this, factory: ViewModelProvider.Factory = viewModelFactory) = ViewModelProviders.of(ofLifecycleOwner, factory).get(viewModel)
}