package cn.dt.weixin.message.response;

import cn.dt.weixin.message.MessageType;

/**
 * 文本消息
 * 
 */
public class TextMessage extends BaseResponseMessage {
	private Text text;

	public TextMessage() {
		super();
		setMsgtype(MessageType.text);
	}

	public TextMessage(String toUserOpenId, String content) {
		this();
		setToUser(toUserOpenId);
		text = new Text(content);
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
}

class Text {
	// 回复的消息内容
	private String content;

	public Text(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}