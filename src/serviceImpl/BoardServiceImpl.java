package serviceImpl;

import java.util.*;

import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private List<ArticleBean> list;
	
	public BoardServiceImpl() {
		list = new ArrayList<ArticleBean>();
	}
	@Override
	public void add(ArticleBean param) {
		list.add(param);
	}

	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean article = new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				article=list.get(i);
				break;
			}
		}
		return article;
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> listSome = new ArrayList<ArticleBean>();
			for(int i=0;i<list.size();i++){
				if(param.getSeq().equals(list.get(i).getSeq())){
					listSome.add(list.get(i));
				}
			}
		return listSome;
	}

	@Override
	public List<ArticleBean> list() {
		return list;
	}

	@Override
	public void update(ArticleBean param) {
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				String a =(param.getUid().equals(""))?list.get(i).getUid():param.getUid();
				String b =(param.getTitle().equals(""))?list.get(i).getTitle():param.getTitle();
				String c =(param.getContents().equals(""))?list.get(i).getContents():param.getContents();
				list.get(i).setUid(a);
				list.get(i).setTitle(b);
				list.get(i).setContents(c);
			}
		}
	}

	@Override
	public void delete(ArticleBean param) {
		Iterator<ArticleBean> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
				break;
			}
		}
	}
}


