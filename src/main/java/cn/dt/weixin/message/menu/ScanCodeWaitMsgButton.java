package cn.dt.weixin.message.menu;

public class ScanCodeWaitMsgButton extends SubButton {
	public static final String TYPE_KEY = "scancode_waitmsg";

	private String key;

	public ScanCodeWaitMsgButton() {
		super();
		setType(TYPE_KEY);
	}

	public ScanCodeWaitMsgButton(String name, String key) {
		this();
		setName(name);
		setKey(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
