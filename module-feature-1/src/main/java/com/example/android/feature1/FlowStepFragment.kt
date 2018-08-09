/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.feature1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.android.core.FeatureCore

/**
 * Presents how multiple steps flow could be implemented.
 */
class FlowStepFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		setHasOptionsMenu(true)

		//val step = arguments?.getInt("step")

		val step = arguments?.let {

			val safeArgs = FlowStepFragmentArgs.fromBundle(it)
			safeArgs.step
		}

		return when (step) {
			2 -> inflater.inflate(R.layout.flow_step_two_fragment, container, false)
			else -> inflater.inflate(R.layout.flow_step_one_fragment, container, false)
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		arguments?.let { it ->

			when (FlowStepFragmentArgs.fromBundle(it).step) {
				2 -> {
					view.findViewById<View>(R.id.next_button).setOnClickListener { FeatureCore.applicationInterface.navigateHome() }
				}
				else -> {
					view.findViewById<View>(R.id.next_button).setOnClickListener(
						Navigation.createNavigateOnClickListener(R.id.next_action)
					)
				}
			}
		}

	}
}
