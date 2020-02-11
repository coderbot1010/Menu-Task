package com.coderbot.menu.domain.repository;

import io.reactivex.Single;

public interface Repository
{
	Single<String> getMenu();
}
