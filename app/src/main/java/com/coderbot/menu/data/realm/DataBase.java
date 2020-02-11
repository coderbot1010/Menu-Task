package com.coderbot.menu.data.realm;

import com.coderbot.menu.data.entity.MenuItem;
import java.util.ArrayList;
import javax.inject.Singleton;
import io.realm.Realm;
import io.realm.RealmResults;

@Singleton
public class DataBase
{
	private Realm realm = Realm.getDefaultInstance();

	public ArrayList<MenuItem> select()
	{
		realm.beginTransaction();
		RealmResults<MenuItem> items = realm.where(MenuItem.class).findAll();
		realm.commitTransaction();
		return new ArrayList<>(items);
	}

	public void insert(ArrayList<MenuItem> items)
	{
		realm.beginTransaction();
		realm.insert(items);
		realm.commitTransaction();
	}
}
