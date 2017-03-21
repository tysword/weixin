package cn.dt.weixin.message.response;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListData {
	@JsonProperty(value = "openid")
	private String[] openid;

	
	public String[] getOpenid() {
		return openid;
	}

	public void setOpenid(String[] openid) {
		this.openid = openid;
	}

	
	@Override
	public String toString() {
		return "UserListData [openid=" + Arrays.toString(openid)
				+ "]";
	}

}
