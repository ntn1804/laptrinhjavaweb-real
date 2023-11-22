package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsService {
	public List<NewsModel> findByCategoryID(Long categoryId);
}
