package com.coderbot.menu.presentation.view.details;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.coderbot.menu.R;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.domain.utils.Views;

public class DetailsActivity extends AppCompatActivity
{
	private ImageView photo;
	private TextView description;
	private MenuItem item;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		init();

		if (getIntent() != null && getIntent().hasExtra("MENU_ITEM"))
		{
			item = getIntent().getParcelableExtra("MENU_ITEM");
			setData();
		}
		else
		{
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
			finish();
		}
	}

	private void init()
	{
		photo = findViewById(R.id.photo);
        description = findViewById(R.id.description);
	}

	private void setData()
	{
        description.setText(item.getDescription());
		if (!item.getPhotoUrl().isEmpty())
			Views.ImageLoader.load(this, photo, item.getPhotoUrl(), "");
		else
			photo.setImageResource(R.mipmap.ic_launcher);
	}
}
