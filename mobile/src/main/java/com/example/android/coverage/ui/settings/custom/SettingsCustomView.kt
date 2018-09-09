package com.example.android.coverage.ui.settings.custom

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.core.PreferencesCore
import com.example.android.core.arch.BaseFragment
import com.example.android.core.ktools.vmb
import com.example.android.coverage.R
import com.example.android.coverage.databinding.FragmentSettingsCustomBinding
import kotlinx.android.synthetic.main.fragment_settings_custom.view.textX
import timber.log.Timber
import java.util.Random
import javax.inject.Inject

interface SettingsCustomView {
	fun nextToken()
}

class SettingsCustomFragment : BaseFragment(), SettingsCustomView {

	@Inject
	lateinit var preferencesCore: PreferencesCore

	private val vmb by vmb<SettingsCustomViewModel, FragmentSettingsCustomBinding>(R.layout.fragment_settings_custom) { SettingsCustomViewModel() }

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		//TODO discuss this weird required extra set with Jakub
		vmb.binding.view = this
		vmb.binding.viewModel = ViewModelProviders.of(this).get(SettingsCustomViewModel::class.java)
		return vmb.rootView
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

	override fun nextToken() {
		Timber.d(">>>nextToken")
		vmb.viewModel.token.value = Random().nextInt().toString()
	}
}