package cn.dt.weixin.util;

public class WeixinConstant {
	public static final String HOST_API = "api.weixin.qq.com";

	public static final String HOST_MEDIA = "file.api.weixin.qq.com";

	public static final String PATH_TOKEN = "/cgi-bin/token";

	public static final String PATH_USER_INFO = "/cgi-bin/user/info";
	public static final String PATH_USER_GET = "/cgi-bin/user/get";

	public static final String PATH_TEMPLATE_SEND = "/cgi-bin/message/template/send";
	public static final String PATH_TEMPLATE_INDUSTRY = "/cgi-bin/message/template/api_set_industry";
	public static final String PATH_TEMPLATE_ID_SHORT = "/cgi-bin/message/template/api_add_template";
	public static final String PATH_MESSAGE_SEND = "/cgi-bin/message/custom/send";

	public static final String PATH_MENU_CREATE = "/cgi-bin/menu/create";
	public static final String PATH_MENU_GET = "/cgi-bin/menu/get";

	public static final String PATH_MEDIA_UPLOAD = "/cgi-bin/media/upload";

	public static final String PATH_METERIAL_BATCHGET = "/cgi-bin/material/batchget_material";
	
	public static final String ACCESS_TOKEN_KEY = "access_token";
	public static final String ERRCODE_KEY = "errcode";


	public static final long KEEP_MILLISECOND = 5000 * 1000; // 微信官方token效期为7200秒，每天可请求20次，考虑冗余时间，将请求设置为5000秒
	public static final String LOCAL = "zh_CN";

}