package com.coderbot.menu.data.api;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface API
{
	@GET("/bins/kvdzh")
	Single<String> getMenu();
}
