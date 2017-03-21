package cn.dt.weixin.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.dt.weixin.message.menu.Menu;

public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

	public static void setMenu(Menu menu, String token) throws Exception {
		String json = convert2MenuJson(menu);

		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair(WeixinConstant.ACCESS_TOKEN_KEY, token));

		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_MENU_CREATE).setParameters(params).build();

		StringEntity entity = new StringEntity(json, "UTF-8");

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			long len = responseEntity.getContentLength();
			if (len != -1 && len < 2048) {
				ObjectMapper mapper = new ObjectMapper();
				Map<?, ?> map = mapper.readValue(EntityUtils.toString(responseEntity), Map.class);
				if (!map.get(WeixinConstant.ERRCODE_KEY).equals(0)) {
					log.error("创建微信菜单错误，错误信息：" + EntityUtils.toString(responseEntity));
					throw new RuntimeException("创建微信菜单错误");
				}
			}
		}
	}

	public static void getMenu(String token) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(WeixinConstant.ACCESS_TOKEN_KEY, token));
		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_MENU_GET).setParameters(params).build();
		HttpPost httpPost = new HttpPost(uri);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			long len = responseEntity.getContentLength();
			if (len != -1 && len < 2048) {
				ObjectMapper mapper = new ObjectMapper();
				Map<?, ?> map = mapper.readValue(EntityUtils.toString(responseEntity, "UTF-8"), Map.class);
				System.out.println(map);
			}
		}
	}

	public static String convert2MenuJson(Menu menu) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(menu);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("菜单信息错误！");
		}
	}
}
