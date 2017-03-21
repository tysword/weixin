package cn.dt.weixin.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TokenUtil {
	private static final String TOKEN2 = "token";
	private static final String TIMESTRING = "timestring";
	private String appId;
	private String appSecret;
	private String token = "";
	private long lastGetTime = 0;
	private static ConcurrentMap<String, Object> tokenCache = new ConcurrentHashMap<>();

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public long getLastGetTime() {
		return lastGetTime;
	}

	public void setLastGetTime(long lastGetTime) {
		this.lastGetTime = lastGetTime;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenUtil(String appId, String appSecret) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public synchronized String getToken() throws Exception {
		getTokenProperties(); // 从配置文件获取上次获得的token信息

		if (token == null || token.length() <= 0
				|| ((System.currentTimeMillis() - lastGetTime) >= WeixinConstant.KEEP_MILLISECOND)) {
			token = getNewToken();
			setTokenProperties(); // 将获得结果写入配置文件
		} else {
			setTokenProperties(); // 将获得结果写入配置文件
		}

		System.out.println("token:" + token);
		return token;
	}

	private void setTokenProperties() {
		tokenCache.put(TOKEN2, token);
		tokenCache.put(TIMESTRING, lastGetTime);
	}

	private String getNewToken()
			throws URISyntaxException, IOException, ClientProtocolException, JsonParseException, JsonMappingException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		formparams.add(new BasicNameValuePair("grant_type", "client_credential"));
		formparams.add(new BasicNameValuePair("appid", getAppId()));
		formparams.add(new BasicNameValuePair("secret", getAppSecret()));

		URI uri = new URIBuilder().setScheme("https").setHost(WeixinConstant.HOST_API)
				.setPath(WeixinConstant.PATH_TOKEN).setParameters(formparams).build();
		HttpGet httpget = new HttpGet(uri);

		CloseableHttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			long len = entity.getContentLength();
			if (len != -1 && len < 2048) {
				ObjectMapper mapper = new ObjectMapper();
				Map<?, ?> map = mapper.readValue(EntityUtils.toString(entity), Map.class);
				if (map.get(WeixinConstant.ERRCODE_KEY) == null) {
					lastGetTime = System.currentTimeMillis();
					token = (String) map.get(WeixinConstant.ACCESS_TOKEN_KEY);
					return token;
				}
			}
		}

		throw new RuntimeException("微信认证失败!");
	}

	private void getTokenProperties() {
		if (tokenCache.containsKey(TIMESTRING))
			lastGetTime = (Long) tokenCache.get(TIMESTRING);
		else {
			lastGetTime = 0;
		}

		token = (String) tokenCache.get(TOKEN2);
	}
}
