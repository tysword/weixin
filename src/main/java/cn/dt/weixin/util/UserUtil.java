package cn.dt.weixin.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.dt.weixin.message.response.UserList;
import cn.dt.weixin.user.User;

public class UserUtil {
	private static Logger log = LoggerFactory.getLogger(UserUtil.class);

	public static synchronized User getUser(String openID, String token) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		formparams.add(new BasicNameValuePair("access_token", token));
		formparams.add(new BasicNameValuePair("openid", openID));
		formparams.add(new BasicNameValuePair("lang", WeixinConstant.LOCAL));

		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_USER_INFO).setParameters(formparams).build();
		HttpGet httpget = new HttpGet(uri);

		CloseableHttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			long len = entity.getContentLength();
			if (len != -1 && len < 2048) {
				ObjectMapper mapper = new ObjectMapper();
				User user = mapper.readValue(EntityUtils.toString(entity, "UTF-8"), User.class);
				if (user.getErrcode() == null || user.getErrcode().length() == 0) {
					return user;
				}
			}
		}

		log.error("获取用户信息失败!");
		throw new RuntimeException("获取用户信息失败!");
	}

	public static synchronized UserList getUsers(String nextOpenid, String token) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		formparams.add(new BasicNameValuePair("access_token", token));
		formparams.add(new BasicNameValuePair("next_openid", nextOpenid));

		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_USER_GET).setParameters(formparams).build();
		HttpGet httpget = new HttpGet(uri);

		CloseableHttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			long len = entity.getContentLength();
			if (len != -1) {
				ObjectMapper mapper = new ObjectMapper();
				UserList list = mapper.readValue(EntityUtils.toString(entity), UserList.class);

				return list;
			}
		}

		log.error("获取用户信息失败!");
		throw new RuntimeException("获取用户信息失败!");
	}
}
