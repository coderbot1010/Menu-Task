package com.coderbot.menu.dagger;

import com.coderbot.menu.data.realm.DataBase;
import com.coderbot.menu.data.repository.RepositoryImpl;
import com.coderbot.menu.domain.repository.Repository;
import com.coderbot.menu.domain.usecase.GetMenu;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.coderbot.menu.domain.utils.Constants.URL;

@Module
class ProviderModule
{
	@Singleton
	@Provides
	DataBase provideDatabase()
	{
		return new DataBase();
	}

	@Singleton
	@Provides
	Retrofit provideRetrofit()
	{
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
		return new Retrofit.Builder().baseUrl(URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
	}

	@Singleton
	@Provides
	Repository provideRepository(Retrofit retrofit, DataBase database)
	{
		return new RepositoryImpl(retrofit, database);
	}

	@Singleton
	@Provides
	GetMenu provideGetMenuUseCase(Repository repository)
	{
		return new GetMenu(repository);
	}
}
