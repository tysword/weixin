package cn.dt.weixin.message.menu;

public abstract class Button {
	private String name;

	public Button() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}