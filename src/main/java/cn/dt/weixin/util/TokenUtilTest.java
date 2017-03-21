package cn.dt.weixin.util;

import org.junit.Test;

public class TokenUtilTest {

	@Test
	public void test() throws Exception {
		String appId = "wx467e77b44022d060";
		String appSecret = "392f21acd4f3e9b974b1b86cd63d4938";
		TokenUtil t = new TokenUtil(appId, appSecret);
		t.getToken();
		t.getToken();
	}

}
