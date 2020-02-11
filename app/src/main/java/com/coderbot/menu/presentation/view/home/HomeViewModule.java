package com.coderbot.menu.presentation.view.home;

import com.coderbot.menu.domain.usecase.GetMenu;
import com.coderbot.menu.presentation.viewmodel.HomeViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeViewModule
{
	@Provides
	HomeViewModel provideViewModel(GetMenu usecase)
	{
		return new HomeViewModel(usecase);
	}
}
