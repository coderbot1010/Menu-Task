package com.coderbot.menu.data.repository;

import com.coderbot.menu.data.api.webservice.API;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.data.realm.DataBase;
import com.coderbot.menu.domain.mapper.Mappers;
import com.coderbot.menu.domain.repository.Repository;
import java.util.ArrayList;
import javax.inject.Singleton;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Singleton
public class RepositoryImpl implements Repository
{
	private API api;
	private DataBase database;

	public RepositoryImpl(Retrofit retrofit, DataBase database)
	{
		this.database = database;
		api = retrofit.create(API.class);
	}

	@Override
	public Single<ArrayList<MenuItem>> getMenu()
	{
		return api.getMenu().map(Mappers.menuMapper).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
	}

	@Override
	public ArrayList<MenuItem> selectLocally()
	{
		return database.select();
	}

	@Override
	public void storeLocally(ArrayList<MenuItem> items)
	{
		database.insert(items);
	}
}
