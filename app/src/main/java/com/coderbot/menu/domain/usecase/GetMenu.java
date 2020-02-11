package com.coderbot.menu.domain.usecase;

import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.domain.repository.Repository;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

@Singleton
public class GetMenu
{
	private Repository repository;

	@Inject
	public GetMenu(Repository repository)
	{
		this.repository = repository;
	}

	public Single<ArrayList<MenuItem>> run()
	{
		return Single.create(emitter -> repository.getMenu().subscribe(new SingleObserver<ArrayList<MenuItem>>()
		{
			@Override
			public void onSubscribe(Disposable disposable)
			{

			}

			@Override
			public void onSuccess(ArrayList<MenuItem> list)
			{
				emitter.onSuccess(list);
			}

			@Override
			public void onError(Throwable ex)
			{
				emitter.onError(ex);
			}
		}));
	}
}
