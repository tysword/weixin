package cn.dt.weixin.message.request;

/**
 * 事件消息
 * 
 * @author tangyu
 * 
 */
public class EventMessage extends BaseRequestMessage {
	private String event; // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)
	private String eventKey; // 事件KEY值，与自定义菜单接口中KEY值对应

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

}
