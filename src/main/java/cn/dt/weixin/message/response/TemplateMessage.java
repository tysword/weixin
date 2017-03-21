package cn.dt.weixin.message.response;

import java.util.HashMap;
import java.util.Map;

import cn.dt.weixin.message.MessageType;


public class TemplateMessage extends BaseResponseMessage{
	private String touser;
	private String template_id;
	private String url="http://weixin.qq.com/download";
	private String topcolor="#FF0000";
	private Map<String,TemplateData> data = new HashMap<String, TemplateData>();
	public TemplateMessage() {
		super();
		setMsgtype(MessageType.template);
	}

	public TemplateMessage(String toUser, String template_id, String url, String topcolor, Map<String,TemplateData> data) {
		this();
		setToUser(toUser);
		this.touser = toUser;
		this.template_id = template_id;
		this.url = url;
		this.topcolor = topcolor;
		this.setData(data);
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
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

	public Map<String,TemplateData> getData() {
		return data;
	}

	public void setData(Map<String,TemplateData> data) {
		this.data = data;
	}

}
