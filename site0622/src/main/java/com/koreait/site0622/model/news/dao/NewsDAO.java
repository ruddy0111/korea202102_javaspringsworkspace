package com.koreait.site0622.model.news.dao;

import java.util.List;

import com.koreait.site0622.model.domain.News;

public interface NewsDAO {
	public int insert(News news);//글등록
	public List selectAll();
	public News select(int news_id);
	public int update(News news);
	public int delete(int news_id);
}
