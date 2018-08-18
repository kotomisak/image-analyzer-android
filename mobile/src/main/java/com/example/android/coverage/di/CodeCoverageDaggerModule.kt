package com.example.android.coverage.di

import com.example.android.coverage.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CodeCoverageDaggerModule {

	@ContributesAndroidInjector
	abstract fun contributeCreateMainFragment(): MainFragment

}