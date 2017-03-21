package cn.dt.weixin.message.response;

import cn.dt.weixin.message.MessageType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author tangyu
 * 
 */
public class MusicMessage extends BaseResponseMessage {

	private Music music; // 音乐

	public MusicMessage() {
		super();
		setMsgtype(MessageType.music);
	}

	public MusicMessage(String toUser, String title, String description,
			String musicUrl, String hQMusicUrl, String thumbMediaId) {
		this();
		setToUser(toUser);
		this.music = new Music(title, description, musicUrl, hQMusicUrl,
				thumbMediaId);
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}

class Music {
	private String title;// 音乐名称

	private String description; // 音乐描述

	@JsonProperty(value = "musicurl")
	private String musicUrl; // 音乐链接
	@JsonProperty(value = "hqmusicurl")
	private String hQMusicUrl; // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	@JsonProperty(value = "thumb_media_id")
	private String thumbMediaId;

	public Music(String title, String description, String musicUrl,
			String hQMusicUrl, String thumbMediaId) {
		super();
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hQMusicUrl = hQMusicUrl;
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

}