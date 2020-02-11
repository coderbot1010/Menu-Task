package com.coderbot.menu.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import com.coderbot.menu.domain.usecase.GetMenu;
import javax.inject.Inject;

public class HomeViewModel extends ViewModel
{
	@Inject
	GetMenu usecase;

	public void getMenu()
	{

	}
}
