package cn.dt.weixin.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.dt.weixin.message.MessageType;

public class VideoMessage extends BaseResponseMessage {
	private Video video;

	public VideoMessage() {
		super();
		setMsgtype(MessageType.video);
	}

	public VideoMessage(String toUser, String mediaId, String thumbMediaId,
			String title, String description) {
		this();
		setToUser(toUser);
		setVideo(new Video(mediaId, thumbMediaId, title, description));
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}

class Video {
	@JsonProperty(value = "media_id")
	private String mediaId;

	@JsonProperty(value = "thumb_media_id")
	private String thumbMediaId;

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "description")
	private String description;

	public Video(String mediaId, String thumbMediaId, String title,
			String description) {
		this.mediaId = mediaId;
		this.thumbMediaId = thumbMediaId;
		this.title = title;
		this.description = description;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

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