package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.PageAble;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDao;

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		return newsDao.findByCategoryID(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newId = newsDao.save(newsModel);
		return newsDao.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			// b1. delete comment (khóa ngoại new_id)
			
			// b2. delete news
			newsDao.delete(id);
		}

	}

	@Override
	public List<NewsModel> findAll(PageAble pageAble) {
		return newsDao.findAll(pageAble);
	}

	@Override
	public int getTotalItem() {
		return newsDao.getTotalItem();
	}

	@Override
	public NewsModel findOne(long id) {
		return newsDao.findOne(id);
	}

}
