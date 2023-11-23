package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		ResultSet resultSet = null;
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO news (title, content, categoryid) VALUES(?, ?, ?)";
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newsModel.getTitle());
			statement.setString(2, newsModel.getContent());
			statement.setLong(3, newsModel.getCategoryId());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
