package cn.dt.weixin.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.dt.weixin.message.MessageType;

public class VoiceMessage extends BaseResponseMessage {
	private Voice voice;

	public VoiceMessage() {
		super();
		setMsgtype(MessageType.voice);
	}

	public VoiceMessage(String toUser, String mediaId) {
		this();
		setToUser(toUser);
		voice = new Voice(mediaId);
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}

class Voice {
	@JsonProperty(value = "media_id")
	private String mediaId;

	public Voice(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
