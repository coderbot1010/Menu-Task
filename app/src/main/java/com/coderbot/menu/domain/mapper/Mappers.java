package com.coderbot.menu.domain.mapper;

import com.coderbot.menu.data.api.response.MenuResponse;
import com.coderbot.menu.data.entity.MenuItem;
import java.util.ArrayList;
import io.reactivex.functions.Function;

public class Mappers
{
	public static Function<MenuResponse, ArrayList<MenuItem>> menuMapper = response -> {
		ArrayList<MenuItem> items = new ArrayList<>();
		for (MenuResponse.MenuItem item : response.items)
		{
			MenuItem menuItem = new MenuItem();
			menuItem.setId(item.id);
			menuItem.setName(item.name);
			menuItem.setPhotoUrl(item.photoUrl);
			menuItem.setDescription(item.description);
			items.add(menuItem);
		}
		return items;
	};
}
