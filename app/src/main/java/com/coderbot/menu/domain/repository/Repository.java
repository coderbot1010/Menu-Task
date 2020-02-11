package com.coderbot.menu.domain.repository;

import com.coderbot.menu.data.entity.MenuItem;

import java.util.ArrayList;

import io.reactivex.Single;

public interface Repository
{
	Single<ArrayList<MenuItem>> getMenu();
}
