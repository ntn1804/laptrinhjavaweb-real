package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.PageAble;

public interface INewsService {
	List<NewsModel> findByCategoryID(Long categoryId);

	NewsModel save(NewsModel newsModel);

	NewsModel update(NewsModel updateNews);
	
	void delete(long[] ids);
	
	List<NewsModel> findAll(PageAble pageAble);
	
	int getTotalItem();
	
	NewsModel findOne(long id);
}
