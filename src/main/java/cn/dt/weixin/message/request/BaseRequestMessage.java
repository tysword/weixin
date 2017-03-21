package cn.dt.weixin.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class BaseRequestMessage {
	@XStreamAlias("ToUserName")
	private String toUserName; // 开发者微信号
	// 发送方帐号（一个OpenID）
	@XStreamAlias("FromUserName")
	private String fromUserName;
	// 消息创建时间 （整型）
	@XStreamAlias("CreateTime")
	private long createTime;
	// 消息类型（text/image/location/link）
	@XStreamAlias("MsgType")
	private String msgType;
	// 消息id，64位整型
	@XStreamAlias("MsgId")
	private long msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "BaseRequestMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", msgId=" + msgId + "]";
	}

}
