package cn.dt.weixin.message.request;

/**
 * 图像消息
 * 
 * @author tangyu
 * 
 */
public class ImageMessage extends BaseRequestMessage {
	private String picUrl; // 图片url

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
