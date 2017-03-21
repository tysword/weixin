package cn.dt.weixin.message.response;

import java.util.ArrayList;
import java.util.List;

import cn.dt.weixin.message.MessageType;

/**
 * 文本消息
 * 
 * @author tangyu
 */
public class ArticleMessage extends BaseResponseMessage {
	private News news;

	public ArticleMessage() {
		super();
		setMsgtype(MessageType.news);
	}

	public ArticleMessage(String toUser, List<Article> articles) {
		this();
		setToUser(toUser);
		this.news = new News(articles);

	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}

class News {
	private List<Article> articles = new ArrayList<Article>();

	public News(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}