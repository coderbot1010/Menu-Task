package com.coderbot.menu.dagger;

import android.app.Application;

import com.coderbot.menu.application.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = { AndroidInjectionModule.class, ProviderModule.class })
public interface InjectorComponent
{
	void inject(App app);

	@Component.Builder
	interface Builder
	{
		@BindsInstance
		Builder application(Application application);

		InjectorComponent build();
	}
}
