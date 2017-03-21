package cn.dt.weixin.message;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaMessage {
	public static final String TYPE_IMAGE = "image";
	public static final String TYPE_VOICE = "voice";
	public static final String TYPE_VIDEO = "video";
	public static final String TYPE_THUMB = "thumb";

	// 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
	private String type;

	// 上传成功媒体信息
	@JsonProperty(value = "media_id")
	private String mediaId;
	@JsonProperty(value = "created_at")
	private String createAt;

	// 上传失败错误信息
	private String errcode;
	private String errmsg;

	// 上传的文件
	private File file;

	private boolean uploadSuccess;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isUploadSuccess() {
		return uploadSuccess;
	}

	public void setUploadSuccess(boolean uploadSuccess) {
		this.uploadSuccess = uploadSuccess;
	}

	@Override
	public String toString() {
		return "MediaMessage [createAt=" + createAt + ", errcode=" + errcode
				+ ", errmsg=" + errmsg + ", file=" + file + ", mediaId="
				+ mediaId + ", type=" + type + ", uploadSuccess="
				+ uploadSuccess + "]";
	}

}
