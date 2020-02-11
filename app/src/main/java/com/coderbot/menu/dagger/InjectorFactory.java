package com.coderbot.menu.dagger;

import com.coderbot.menu.presentation.view.home.HomeActivity;
import com.coderbot.menu.presentation.view.home.HomeViewModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class InjectorFactory
{
	@ContributesAndroidInjector(modules = { HomeViewModule.class })
	abstract HomeActivity injectHomeActivity();
}
