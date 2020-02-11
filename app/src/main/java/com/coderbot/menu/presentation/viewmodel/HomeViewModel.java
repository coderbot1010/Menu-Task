package com.coderbot.menu.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.coderbot.menu.data.entity.MenuItem;
import com.coderbot.menu.domain.usecase.GetMenu;
import java.util.ArrayList;
import javax.inject.Inject;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class HomeViewModel extends ViewModel
{
	private GetMenu usecase;
	private MutableLiveData<ArrayList<MenuItem>> menuObserver = new MutableLiveData<>();
	private MutableLiveData<String> errorObserver = new MutableLiveData<>();

	@Inject
	public HomeViewModel(GetMenu usecase)
	{
		this.usecase = usecase;
	}

	public MutableLiveData<ArrayList<MenuItem>> observeMenu()
	{
		return menuObserver;
	}

	public MutableLiveData<String> observeError()
	{
		return errorObserver;
	}

	public void getMenu()
	{
		usecase.run().subscribe(new SingleObserver<ArrayList<MenuItem>>()
		{
			@Override
			public void onSubscribe(Disposable disposable)
			{

			}

			@Override
			public void onSuccess(ArrayList<MenuItem> list)
			{
				menuObserver.postValue(list);
			}

			@Override
			public void onError(Throwable ex)
			{
				errorObserver.postValue(ex.getMessage());
			}
		});
	}
}
