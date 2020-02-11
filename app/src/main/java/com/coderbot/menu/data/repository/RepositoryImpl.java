package com.coderbot.menu.data.repository;

import com.coderbot.menu.data.api.webservice.API;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.domain.mapper.Mappers;
import com.coderbot.menu.domain.repository.Repository;
import java.util.ArrayList;
import javax.inject.Singleton;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Singleton
public class RepositoryImpl implements Repository
{
	private API api;

	public RepositoryImpl(Retrofit retrofit)
	{
		api = retrofit.create(API.class);
	}

	@Override
	public Single<ArrayList<MenuItem>> getMenu()
	{
		return api.getMenu().map(Mappers.menuMapper).subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
	}
}
