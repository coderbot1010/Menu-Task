package com.coderbot.menu.presentation.view.home;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.coderbot.menu.R;
import com.coderbot.menu.presentation.view.base.BaseActivity;
import com.coderbot.menu.presentation.viewmodel.HomeViewModel;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity
{
	@Inject
	HomeViewModel viewModel;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		init();
		initListeners();

		loading.show();
		viewModel.getMenu();
	}

	private void init()
	{

	}

	private void initListeners()
	{
		viewModel.observeMenu().observe(this, menuItems -> {
			loading.dismiss();
			System.out.println(menuItems.toString());
		});

		viewModel.observeError().observe(this, error -> {
			loading.dismiss();
			Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
		});
	}
}
