package com.coderbot.menu.data.repository;

import com.coderbot.menu.domain.repository.Repository;

import io.reactivex.Single;

public class RepositoryImpl implements Repository
{
	@Override
	public Single<String> getMenu()
	{
		return Single.create(emitter -> {

		});
	}
}
