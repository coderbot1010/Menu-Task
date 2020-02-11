package com.coderbot.menu.presentation.view.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.coderbot.menu.domain.utils.Views;
import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity
{
	public Views.LoadingView loading;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		AndroidInjection.inject(this);
		loading = new Views.LoadingView(this);
	}
}
