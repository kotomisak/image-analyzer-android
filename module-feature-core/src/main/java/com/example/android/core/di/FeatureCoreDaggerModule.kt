package com.example.android.core.di

import dagger.Module

@Module(includes = [FeatureCoreModule::class])
abstract class FeatureCoreDaggerModule {

//	@ContributesAndroidInjector
//	abstract fun contrx(): BaseActivity

}