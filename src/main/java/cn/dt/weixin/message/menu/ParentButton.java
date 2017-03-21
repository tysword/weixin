package cn.dt.weixin.message.menu;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentButton extends Button {
	@JsonProperty(value="sub_button")
	private List<Button> subButton = new ArrayList<Button>();

	public List<Button> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<Button> subButton) {
		this.subButton = subButton;
	}

}
