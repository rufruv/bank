package serviceImpl;

import java.util.*;

import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private Vector<ArticleBean> list;
	
	public BoardServiceImpl() {
		list = new Vector<ArticleBean>(100,100);
	}
	@Override
	public void add(ArticleBean param) {
	
	}

	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean article = new ArticleBean();
		
		return article;
	}

	@Override
	public Vector<ArticleBean> findSome(ArticleBean param) {
		Vector<ArticleBean> list = new Vector<ArticleBean>();
		
		return list;
	}

	@Override
	public Vector<ArticleBean> list() {
		Vector<ArticleBean> list = new Vector<ArticleBean>();
		
		return list;
	}

	@Override
	public void update(ArticleBean param) {

	}

	@Override
	public void delete(ArticleBean param) {

	}

}
