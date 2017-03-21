package cn.dt.weixin.message.menu;

public class ViewButton extends SubButton {
	private static final String TYPE_VIEW = "view";
	private String url;

	public ViewButton() {
		super();
		setType(TYPE_VIEW);
	}

	public ViewButton(String name, String url) {
		this();
		setName(name);
		setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
