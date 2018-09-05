package com.example.android.coverage.ui.settings

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.core.PreferencesCore
import com.example.android.core.arch.BaseFragment
import com.example.android.core.ktools.vmb
import com.example.android.coverage.R
import com.example.android.coverage.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.view.textX
import timber.log.Timber
import javax.inject.Inject

interface SettingsView

class SettingsFragment : BaseFragment(), SettingsView {

	@Inject
	lateinit var preferencesCore: PreferencesCore

	private val vmb by vmb<SettingsViewModel, FragmentSettingsBinding>(R.layout.fragment_settings) { SettingsViewModel() }

	init {

	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?): View? {

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_settings, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		vmb.binding.setLifecycleOwner(viewLifecycleOwner)
		vmb.viewModel.token.observe(viewLifecycleOwner, Observer { tokenText ->
			//			vmb.rootView.textX.text = tokenText
			run {
				Timber.d(">>>$tokenText")
				vmb.rootView.textX.text = tokenText
			}
		})
	}

}