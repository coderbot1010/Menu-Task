package com.coderbot.menu.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MenuItem extends RealmObject implements Parcelable
{
	@PrimaryKey
	private long id;
	private String name;
	private String photoUrl;
	private String description;

	public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
	{
		public MenuItem createFromParcel(Parcel in)
		{
			return new MenuItem(in);
		}

		public MenuItem[] newArray(int size)
		{
			return new MenuItem[size];
		}
	};

	public MenuItem()
	{

	}

	public MenuItem(long id, String name, String photoUrl, String description)
	{
		this.id = id;
		this.name = name;
		this.photoUrl = photoUrl;
		this.description = description;
	}

	public MenuItem(Parcel in)
	{
		this.id = in.readLong();
		this.name = in.readString();
		this.photoUrl = in.readString();
		this.description = in.readString();
	}

	@Override
	public int describeContents()
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeLong(this.id);
		dest.writeString(this.name);
		dest.writeString(this.photoUrl);
		dest.writeString(this.description);
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhotoUrl()
	{
		return photoUrl != null ? photoUrl : "";
	}

	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}
