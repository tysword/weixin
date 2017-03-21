package cn.dt.weixin.message.menu;

public class ClickButton extends SubButton {
	public static final String TYPE_KEY = "click";

	private String key;

	public ClickButton() {
		super();
		setType(TYPE_KEY);
	}

	public ClickButton(String name, String key) {
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
