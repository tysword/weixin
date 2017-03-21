package cn.dt.weixin.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserList {
	private int total;

	private int count;

	private UserListData data;

	@JsonProperty(value = "next_openid")
	private String nextOpenid;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserListData getData() {
		return data;
	}

	public void setData(UserListData data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

	@Override
	public String toString() {
		return "UserList [total=" + total + ", count=" + count + ", data="
				+ data + "]";
	}

}
