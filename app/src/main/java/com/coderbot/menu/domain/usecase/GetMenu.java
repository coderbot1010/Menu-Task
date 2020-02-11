package com.coderbot.menu.domain.usecase;

import com.coderbot.menu.domain.repository.Repository;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetMenu
{
	private Repository repository;

	@Inject
	public GetMenu(Repository repository)
	{
		this.repository = repository;
	}
}
