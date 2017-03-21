package cn.dt.weixin.po;

import java.util.Date;

/**
 * 通知模板
 */
public class NoticeTemplate {
	public String customerID;

	private int sendCount;

	/**
	 * 发送通知类容，配合微信服务号配置模板定义的，如：
	 * "data":{"remark":{"value":"11111","color":"#173177"},
	 * "address":{"value":"新港中路397号","color":"#173177"},
	 * "regdate":{"value":"2014-01-01 8：30-9：00","color":"#173177"},
	 * "examuser":{"value":"张","color":"#173177"},
	 * "first":{"value":"您好，您已成功预约体检","color":"#173177"},
	 * "hosptel":{"value":"86619296","color":"#173177"} }
	 */
	private String message;

	private String openid;

	private Date scheduledDate;// 预定发送时间

	private String failureReasons;// 如果发生失败，此字段为失败原因

	private String templateID;// 通知模板id
	private String url;// 通知超链接（客户点击通知消息后能跳转到这个链接）
	private String topcolor = "#FF0000";// 通知消息颜色

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getFailureReasons() {
		return failureReasons;
	}

	public void setFailureReasons(String failureReasons) {
		this.failureReasons = failureReasons;
	}

}
