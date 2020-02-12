package com.coderbot.menu;

import android.content.Context;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.data.realm.DataBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTests
{
	@Mock
	private Context context;

	private DataBase database;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		RealmConfiguration testConfig = new RealmConfiguration.Builder().inMemory().name("test-realm").build();
		Realm.setDefaultConfiguration(testConfig);
		database = new DataBase();
	}

	@Test
	public void testMocks()
	{
		Assert.assertNotNull(context);
		Assert.assertNotNull(database);
	}

	@Test
	public void testDatabaseOperations()
	{
		ArrayList<MenuItem> items = new ArrayList<>();
		items.add(new MenuItem(100, "name", "image", "test"));
		items.add(new MenuItem(101, "name", "image", "test"));
		items.add(new MenuItem(102, "name", "image", "test"));

		database.insert(items);

		ArrayList<MenuItem> selectedItems = database.select();

		Assert.assertNotNull(selectedItems);
		Assert.assertEquals(items.size(), selectedItems.size());
		Assert.assertEquals(items.get(0).getId(), selectedItems.get(0).getId());
	}
}
