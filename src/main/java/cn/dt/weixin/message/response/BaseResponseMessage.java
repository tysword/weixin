package cn.dt.weixin.message.response;

import cn.dt.weixin.message.MessageType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息基类（公众帐号 -> 普通用户）
 */

public abstract class BaseResponseMessage {
	@JsonProperty(value = "touser")
	private String toUser;
	@JsonProperty(value = "msgtype")
	@JsonIgnore
	private MessageType msgtype;

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public MessageType getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(MessageType msgtype) {
		this.msgtype = msgtype;
	}

}
