package com.coderbot.menu.data.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class MenuResponse
{
	public ArrayList<MenuItem> items;

	public class MenuItem
	{
		@SerializedName("id")
		public long id;

		@SerializedName("name")
		public String name;

		@SerializedName("photoUrl")
		public String photoUrl;

		@SerializedName("description")
		public String description;
	}
}
