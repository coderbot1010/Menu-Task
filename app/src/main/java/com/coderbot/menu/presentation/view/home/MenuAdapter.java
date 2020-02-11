package com.coderbot.menu.presentation.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coderbot.menu.R;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.domain.utils.Views;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
	private Context context;
	private MenuSelectionListener listener;
	private ArrayList<MenuItem> menu = new ArrayList<>();

	MenuAdapter(Context context, MenuSelectionListener listener)
	{
		this.context = context;
		this.listener = listener;
	}

	void setData(ArrayList<MenuItem> menu)
	{
		this.menu = new ArrayList<>();
		this.menu.addAll(menu);
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_menu_item, parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
	{
		ViewHolder viewHolder = (ViewHolder) holder;
		MenuItem item = getItem(position);

		viewHolder.name.setText(item.getName());
		if (!item.getPhotoUrl().isEmpty())
			Views.ImageLoader.load(context, viewHolder.photo, item.getPhotoUrl(), "");
		else
			viewHolder.photo.setImageResource(R.drawable.ic_menu);
	}

	@Override
	public int getItemCount()
	{
		return menu.size();
	}

	private MenuItem getItem(int position)
	{
		return menu.get(position);
	}

	class ViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView photo;
		private TextView name;

		ViewHolder(View itemView)
		{
			super(itemView);
			photo = itemView.findViewById(R.id.photo);
			name = itemView.findViewById(R.id.name);

			itemView.setOnClickListener(v -> listener.onItemSelected(getItem(getLayoutPosition())));
		}
	}
}