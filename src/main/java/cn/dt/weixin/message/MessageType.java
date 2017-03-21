package cn.dt.weixin.message;

public enum MessageType {
	text, image, voice, video, location, link, event, music, news,template;

	public static MessageType fromValue(String msgType) {
		for (MessageType m : values()) {
			if (m.name().equals(msgType))
				return m;
		}

		throw new IllegalArgumentException("无法找到消息类型：" + msgType);
	}
}
