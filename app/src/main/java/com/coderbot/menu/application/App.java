package com.coderbot.menu.application;

import android.app.Activity;
import android.app.Application;
import com.coderbot.menu.dagger.DaggerInjectorComponent;
import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;

public class App extends Application implements HasActivityInjector
{
	@Inject
	DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

	@Override
	public DispatchingAndroidInjector<Activity> activityInjector()
	{
		return activityDispatchingAndroidInjector;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		Realm.init(this);
		DaggerInjectorComponent.builder().application(this).build().inject(this);
	}
}
