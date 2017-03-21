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

import cn.dt.weixin.message.response.BaseResponseMessage;

public class SendMessageUtil {
	private static Logger log = LoggerFactory.getLogger(SendMessageUtil.class);

	public static void sendMessage(BaseResponseMessage message, String token) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair(WeixinConstant.ACCESS_TOKEN_KEY, token));

		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_MESSAGE_SEND).setParameters(params).build();

		String json = convert2MessageJson(message);
		System.err.println(json);
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
				System.out.println(map);
				if (!map.get(WeixinConstant.ERRCODE_KEY).equals(0)) {
					log.error(String.format("发送信息错误:%s-%s", map.get(WeixinConstant.ERRCODE_KEY), map.get("errmsg")));
					throw new RuntimeException("发送信息错误");
				}
			}
		}
	}

	public static String convert2MessageJson(BaseResponseMessage message) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(message);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("发送信息错误！");
		}
	}
}
