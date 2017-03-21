package cn.dt.weixin.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.dt.weixin.message.MessageType;

public class ImageMessage extends BaseResponseMessage {
	private Image image;

	public ImageMessage() {
		super();
		setMsgtype(MessageType.image);
	}

	public ImageMessage(String toUser, String mediaId) {
		this();
		setToUser(toUser);
		image = new Image(mediaId);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}

class Image {
	@JsonProperty(value = "media_id")
	private String mediaId;

	public Image(String mediaId2) {
		this.mediaId = mediaId2;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
