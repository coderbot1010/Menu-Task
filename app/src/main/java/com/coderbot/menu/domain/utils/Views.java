package com.coderbot.menu.domain.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.coderbot.menu.R;
import com.coderbot.menu.presentation.view.loading.LoadingDialog;

public class Views
{
	public static class LoadingView
	{
		private LoadingDialog loading;

		public LoadingView(Context context)
		{
			loading = new LoadingDialog(context);
		}

		public void show()
		{
			if (loading != null && !loading.isShowing())
			{
				loading.show();
			}
		}

		public void dismiss()
		{
			if (loading != null && loading.isShowing())
			{
				loading.dismiss();
			}
		}
	}

	public static class ImageLoader
	{
		public static void load(Context context, ImageView imageView, String imageURl, String auth)
		{
			glideLoader(context, imageView, new GlideUrl(imageURl, new LazyHeaders.Builder().addHeader("Authorization", auth).build()));
		}

		private static void glideLoader(Context context, ImageView imageView, GlideUrl uri)
		{
			Glide.with(context).load(uri).thumbnail(0.1f).apply(new RequestOptions().placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))).into(imageView);
		}
	}
}
