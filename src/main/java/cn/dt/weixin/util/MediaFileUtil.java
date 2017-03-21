package cn.dt.weixin.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import cn.dt.weixin.message.MediaMessage;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MediaFileUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

	public static MediaMessage uploadMedia(MediaMessage m, String token) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair(WeixinConstant.ACCESS_TOKEN_KEY, token));
		params.add(new BasicNameValuePair("type", m.getType()));
		URI uri = new URIBuilder().setScheme("http").setHost(WeixinConstant.HOST_MEDIA)
				.setPath(WeixinConstant.PATH_MEDIA_UPLOAD).setParameters(params).build();

		FileBody bin = new FileBody(m.getFile());
		HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).build();

		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(reqEntity);

		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			ObjectMapper mapper = new ObjectMapper();
			MediaMessage rm = mapper.readValue(EntityUtils.toString(responseEntity), MediaMessage.class);
			if (rm.getErrcode() == null || rm.getErrcode().length() == 0) {
				m.setMediaId(rm.getMediaId());
				m.setUploadSuccess(true);
			} else {
				m.setErrcode(rm.getErrcode());
				m.setErrmsg(rm.getErrmsg());
				m.setUploadSuccess(false);

				log.error(String.format("上传文件失败：%s:%s", m.getErrcode(), m.getErrmsg()));
			}
		}

		return m;
	}
}
