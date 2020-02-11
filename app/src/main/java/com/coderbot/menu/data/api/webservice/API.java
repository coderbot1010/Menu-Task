package com.coderbot.menu.data.api.webservice;

import com.coderbot.menu.data.api.response.MenuResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface API
{
	@GET("/bins/kvdzh")
	Single<MenuResponse> getMenu();
}
