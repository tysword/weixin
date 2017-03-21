package cn.dt.weixin.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class MessageVO {

	// 基本消息属性
	@XStreamAlias("URL")
	private String url; // 链接信息

	@XStreamAlias("ToUserName")
	private String toUserName;// 开发者微信号

	@XStreamAlias("FromUserName")
	private String fromUserName; // 发送方帐号（一个OpenID）

	@XStreamAlias("CreateTime")
	private long createTime; // 消息创建时间 （整型）

	@XStreamAlias("MsgType")
	private String msgType;// 消息类型（text/image/location/link）

	@XStreamAlias("MsgId")
	private long msgId;// 消息id，64位整型

	// 文本消息
	@XStreamAlias("Content")
	private String content; // 文本消息类容

	// 图片消息
	@XStreamAlias("PicUrl")
	private String picUrl; // 图片url

	// 地理位置信息
	@XStreamAlias("LocationX")
	private double locationX; // 地理位置维度
	
	@XStreamAlias("LocationY")
	private double locationY; // 地理位置精度
	
	@XStreamAlias("Scale")
	private double scale; // 地图缩放大小
	
	@XStreamAlias("Label")
	private String label; // 地理位置信息

	// 链接消息
	@XStreamAlias("Title")
	private String title; // 消息标题
	@XStreamAlias("Description")
	private String description; // 消息描述

	// 事件推送
	@XStreamAlias("Event")
	private String event; // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)
	
	@XStreamAlias("EventKey")
	private String eventKey; // 事件KEY值，与自定义菜单接口中KEY值对应

	// 声音消息
	@XStreamAlias("MediaId")
	private String mediaId;
	@XStreamAlias("Format")
	private String format;

	// 视频消息
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;
	// @XStreamAlias("mediaId") private String mediaId;

	// 扫描消息
	@XStreamAlias("ScanCodeInfo")
	private ScanCodeInfo scanCodeInfo;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

	@Override
	public String toString() {
		return "MessageVO [url=" + url + ", toUserName=" + toUserName + ", fromUserName=" + fromUserName
				+ ", createTime=" + createTime + ", msgType=" + msgType + ", msgId=" + msgId + ", content=" + content
				+ ", picUrl=" + picUrl + ", locationX=" + locationX + ", locationY=" + locationY + ", scale=" + scale
				+ ", label=" + label + ", title=" + title + ", description=" + description + ", event=" + event
				+ ", eventKey=" + eventKey + ", mediaId=" + mediaId + ", format=" + format + ", thumbMediaId="
				+ thumbMediaId + ", scanCodeInfo=" + scanCodeInfo + "]";
	}

}
