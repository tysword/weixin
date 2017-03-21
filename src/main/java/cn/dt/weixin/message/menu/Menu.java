package cn.dt.weixin.message.menu;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu {

	@JsonProperty(value = "button")
	private List<Button> buttons = new ArrayList<Button>();

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
