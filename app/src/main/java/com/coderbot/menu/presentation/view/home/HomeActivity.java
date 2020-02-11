package com.coderbot.menu.presentation.view.home;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.coderbot.menu.R;
import com.coderbot.menu.presentation.view.base.BaseActivity;
import com.coderbot.menu.presentation.viewmodel.HomeViewModel;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity
{
	private HomeViewModel viewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ButterKnife.bind(this);
		viewModel = new ViewModelProvider(this.getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(HomeViewModel.class);
	}

	private void init()
	{

	}

	private void initListeners()
	{

	}
}
