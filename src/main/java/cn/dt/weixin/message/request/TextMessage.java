package cn.dt.weixin.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.dt.weixin.message.MessageType;

/**
 * 文本消息
 */
@XStreamAlias("xml")
public class TextMessage extends BaseRequestMessage {
	// 消息内容
	@XStreamAlias("Content")
	private String content;
	

	public TextMessage() {
		super();
		setMsgType(MessageType.text.name());
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}