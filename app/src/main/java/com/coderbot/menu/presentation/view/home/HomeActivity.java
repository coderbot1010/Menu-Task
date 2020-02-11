package com.coderbot.menu.presentation.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coderbot.menu.R;
import com.coderbot.menu.presentation.view.base.BaseActivity;
import com.coderbot.menu.presentation.view.details.DetailsActivity;
import com.coderbot.menu.presentation.viewmodel.HomeViewModel;
import java.util.ArrayList;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity
{
	@Inject
	HomeViewModel viewModel;

	RecyclerView items;
	private MenuAdapter adapter;

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
		items = findViewById(R.id.items);
		items.setHasFixedSize(true);
		items.setNestedScrollingEnabled(false);
		items.setLayoutManager(new LinearLayoutManager(this));
		adapter = new MenuAdapter(this, item -> startActivity(new Intent(this, DetailsActivity.class).putExtra("MENU_ITEM", item)));
		items.setAdapter(adapter);
		adapter.setData(new ArrayList<>());
	}

	private void initListeners()
	{
		viewModel.observeMenu().observe(this, menuItems -> {
			loading.dismiss();
			adapter.setData(menuItems);
		});

		viewModel.observeError().observe(this, error -> {
			loading.dismiss();
			Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
		});
	}
}
