package com.example.android.analyzer.text.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.android.analyzer.core.arch.BaseFragment
import com.example.android.analyzer.core.ktools.vmb
import com.example.android.analyzer.text.R
import com.example.android.analyzer.text.databinding.FragmentTextSourceDefinitionBinding

interface TextSourceDefinitionView

class TextSourceDefinitionFragment : BaseFragment(), TextSourceDefinitionView {

	private val vmb by vmb<TextSourceDefinitionViewModel, FragmentTextSourceDefinitionBinding>(R.layout.fragment_text_source_definition) { findViewModel(TextSourceDefinitionViewModel::class.java) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		vmb.binding.view = this
		vmb.binding.viewModel = findViewModel(TextSourceDefinitionViewModel::class.java)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return vmb.rootView
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		vmb.binding.setLifecycleOwner(viewLifecycleOwner)
//		vmb.viewModel.token.observe(viewLifecycleOwner, Observer { tokenText ->
//			//			vmb.rootView.textX.text = tokenText
//			run {
//				Timber.d(">>>$tokenText")
//				//vmb.rootView.textX.text = tokenText
//			}
//		})

		view.findViewById<View>(R.id.next_button).setOnClickListener(
			Navigation.createNavigateOnClickListener(R.id.next_action)
		)
	}

}