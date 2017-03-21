package cn.dt.weixin.message.request;

/**
 * 链接消息
 * 
 * @author tangyu
 * 
 */

public class LinkMessage extends BaseRequestMessage {
	private String title; // 消息标题
	private String description; // 消息描述

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
