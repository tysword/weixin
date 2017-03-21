//package cn.dt.weixin.service.impl;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import cn.dt.basic.constant.SendStatus;
//import cn.dt.basic.util.DateUtils;
//import cn.dt.weixin.handler.dao.INoticeTemplateDAO;
//import cn.dt.weixin.handler.dao.IRequestMessageDAO;
//import cn.dt.weixin.handler.dao.IWeiXinCustomerDAO;
//import cn.dt.weixin.message.RequestMessageFactory;
//import cn.dt.weixin.message.request.BaseRequestMessage;
//import cn.dt.weixin.message.request.MessageVO;
//import cn.dt.weixin.message.response.TemplateData;
//import cn.dt.weixin.message.response.TemplateMessage;
//import cn.dt.weixin.po.NoticeTemplate;
//import cn.dt.weixin.po.WeiXinCustomer;
//import cn.dt.weixin.service.IWeixinService;
//import cn.dt.weixin.user.User;
//import cn.dt.weixin.util.SendTemplateUtil;
//import cn.dt.weixin.util.UserUtil;
//import net.sf.json.JSONObject;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Service
//public class WeixinService implements IWeixinService {
//
//	@Autowired
//	private IRequestMessageDAO dao;
//	@Autowired
//	private INoticeTemplateDAO noticeTemplateDAO;
//	
//	@Autowired
//	private IWeiXinCustomerDAO weiXinCustomerDAO;
//
//	public String handleRequest(MessageVO vo) {
//		if(vo.getEvent()!=null&&"subscribe".equals(vo.getEvent())){//订阅的时候把当前用户插入到
//			WeiXinCustomer c = weiXinCustomerDAO.findByOpenid(vo.getFromUserName());
//			try {
//				User user = UserUtil.getUser(vo.getFromUserName());
//				if(c!=null){//如果该用户之前关注过，只需要修改状态就行
//					BeanUtils.copyProperties(user, c);
//					c.setStatus("A");
//					c.setCreateDate(new Date());
//					weiXinCustomerDAO.save(c);
//				}else{
//					c = new WeiXinCustomer();
//					BeanUtils.copyProperties(user, c);
//					weiXinCustomerDAO.save(c);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return sentAttention(vo);
//		}else if(vo.getEvent()!=null&&"unsubscribe".equals(vo.getEvent())){//取消订阅事件
//			WeiXinCustomer c = weiXinCustomerDAO.findByOpenid(vo.getFromUserName());
//			c.setStatus("D");
//			c.setCustomerID(null);
//			weiXinCustomerDAO.save(c);
//		}else if(vo.getEvent()!=null&&"CLICK".equals(vo.getEvent())){//用户点击菜单事件
//			return sentClikeMenu(vo);
//		}else {
//			BaseRequestMessage r = RequestMessageFactory.convert2RequestMessage(vo);
//			dao.save(r);
//			
//			return "<xml><ToUserName><![CDATA["
//			+ vo.getFromUserName()
//			+ "]]></ToUserName><FromUserName>"
//			+ "<![CDATA["
//			+ vo.getToUserName()
//			+ "]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[text]]></MsgType>"
//			+ "<Content><![CDATA[你好,你的消息已经收到!]]></Content></xml>";
//		}
//		return "";
//	}
//
//	private String sentAttention(MessageVO vo) {
//		return "<xml><ToUserName><![CDATA["
//				+ vo.getFromUserName()
//				+ "]]></ToUserName><FromUserName>"
//				+ "<![CDATA["
//				+ vo.getToUserName()
//				+ "]]></FromUserName><CreateTime>"+
//				DateUtils.formBeanDateToPODate(DateUtils.getStringDateShort())+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>3</ArticleCount><Articles>"
//				+"<item><Title><![CDATA[【福利来啦】对话杨丽萍，《云南映象》绽放软件园 门票大放送]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=201167013&idx=1&sn=8a299710b2f9c09032dbfb3b86ea432b]]></Url>"
//				+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaKWX7W8I6jTQQfYMjEWfNfu2FRjht3NwpScP7g5y10J9kcu4xpicj2u828lFLxutdOprAA4jrPxP8w/0]]></PicUrl>" 
//				+"</item>"
//				
//				+"<item><Title><![CDATA[爽到爆！原价300元的颈肩腰综合舒缓调理现仅需180元！]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=201083969&idx=1&sn=3073cedc204a3ce87c04fd2a092ef288]]></Url>"
//				+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaLHOStgdZruTWNdRxIpsfHG0I1RAvsOtY6dcAQNtQKGticRFLibxUFebaiaqleMLxBHJTzQWxmkTUyiaA/0]]></PicUrl>" 
//				+"</item>"
//				
//				+"<item><Title><![CDATA[玩大发了，360元的德国云图深度体检只需68元！]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=201002461&idx=2&sn=e22461f90bd008a8ba1bc0712c2205f1]]></Url>"
//				+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaJouxFkQARQmq8wMv5D1tdNbUudSVpADg1z67xa38ZKCQcibZlB7jHRfELl9AAqWB7ODALD9FhtlyQ/0]]></PicUrl>" 
//				+"</item>"
//				+ "</Articles></xml>";
//	}
//
//	@Override 
//	public List<NoticeTemplate> getScheduledNoticeTemplates() {
//		return noticeTemplateDAO.getScheduledNoticeTemplates(new Date());
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public void sendNoticeTemplate(NoticeTemplate nt) {
//		Map<String,TemplateData> data = new HashMap<String, TemplateData>();
//		String message = nt.getMessage();
//		JSONObject json = JSONObject.fromObject(message);
//		Iterator<String> it = json.keys();
//		while (it.hasNext()) {  
//             String key = (String) it.next();  
//             String value = json.getString(key);  
//             ObjectMapper mapper = new ObjectMapper();  
//             try {
//				TemplateData t = mapper.readValue(value.toString(), TemplateData.class);
//				data.put(key, t);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//        }
//		TemplateMessage t = new TemplateMessage(nt.getOpenid(),nt.getTemplateID(),nt.getUrl(),nt.getTopcolor(),data);
//		try {
//			Map<?, ?> map = SendTemplateUtil.sendMessage(t);
//			nt.setSendCount(nt.getSendCount() + 1);
//			if (!map.get("errcode").equals(0)) {//发送失败，返回原因
//				nt.setSendStatus(SendStatus.FAIL);
//				nt.setFailureReasons(map.toString());
//			}else {//发送成功
//				nt.setSendStatus(SendStatus.SUCCESS);
//			}
//			noticeTemplateDAO.save(nt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	private String sentClikeMenu(MessageVO vo){
//		if("KEY_001".equals(vo.getEventKey())){//走进你好
//			return "<xml><ToUserName><![CDATA["
//			+ vo.getFromUserName()
//			+ "]]></ToUserName><FromUserName>"
//			+ "<![CDATA["
//			+ vo.getToUserName()
//			+ "]]></FromUserName><CreateTime>"+
//			DateUtils.formBeanDateToPODate(DateUtils.getStringDateShort())+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles>"
//			+"<item><Title><![CDATA[走进你好健康管理中心]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=200355003&idx=1&sn=0fa5f2ca59460f46a33b173b385f36ec#rd]]></Url>"
//			+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaKc2TurtpFJyMlTkhRZAGgxc08O55KPBgLUVZXUzDYeYG35nrEvrmq3qhmibt4C3HFKibjMbV140wkQ/0]]></PicUrl>" 
//			+"<Description><![CDATA[欢迎走进你好健康管理!你好健康管理隶属于北医三院上地健康中心—你好健康医疗。]]></Description></item>"
//			+""
//			+ "</Articles></xml>";
//		}else if ("KEY_002".equals(vo.getEventKey())) {//无创健康调养
//			return "<xml><ToUserName><![CDATA["
//			+ vo.getFromUserName()
//			+ "]]></ToUserName><FromUserName>"
//			+ "<![CDATA["
//			+ vo.getToUserName()
//			+ "]]></FromUserName><CreateTime>"+
//			DateUtils.formBeanDateToPODate(DateUtils.getStringDateShort())+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles>"
//			+"<item><Title><![CDATA[你好·特色调养工作室]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=200355413&idx=1&sn=8c3d8b63372529bd50a264d00dde57af#rd]]></Url>"
//			+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaKc2TurtpFJyMlTkhRZAGgxYBrFYxsI6zIhUXXEYslgf9XCYo8DVe2LdhmcCyPFLnS4pV5IeU93wg/0]]></PicUrl>" 
//			+"<Description><![CDATA[引进世界先进的慢病管理服务与质控标准、机构运营管理经验，配备专业的医护服务团队和世界进口的技术设备并制定全面系统的无创健康调养方案。]]></Description></item>"
//			+""
//			+ "</Articles></xml>";
//		}else if ("KEY_003".equals(vo.getEventKey())) {//软件园服务项目
//			return "<xml><ToUserName><![CDATA["
//			+ vo.getFromUserName()
//			+ "]]></ToUserName><FromUserName>"
//			+ "<![CDATA["
//			+ vo.getToUserName()
//			+ "]]></FromUserName><CreateTime>"+
//			DateUtils.formBeanDateToPODate(DateUtils.getStringDateShort())+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles>"
//			+"<item><Title><![CDATA[中关村软件园服务项目]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=200355351&idx=1&sn=2707da7c1e6fbdf6e39fd34b78389003#rd]]></Url>"
//			+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaKc2TurtpFJyMlTkhRZAGgxaDf0jXicpKTak3LDaDwcsJF2HGpjQlorCJnnoHAQHdCgmx15jx7m2ag/0]]></PicUrl>" 
//			+"<Description><![CDATA[中关村软件园服务项目]]></Description></item>"
//			+""
//			+ "</Articles></xml>";
//		}else if ("KEY_004".equals(vo.getEventKey())) {//长阳社区服务项目
//			return "<xml><ToUserName><![CDATA["
//			+ vo.getFromUserName()
//			+ "]]></ToUserName><FromUserName>"
//			+ "<![CDATA["
//			+ vo.getToUserName()
//			+ "]]></FromUserName><CreateTime>"+
//			DateUtils.formBeanDateToPODate(DateUtils.getStringDateShort())+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles>"
//			+"<item><Title><![CDATA[社区服务项目]]></Title><Url><![CDATA[http://mp.weixin.qq.com/s?__biz=MzA4MjcyNDkzMg==&mid=200355358&idx=1&sn=3021f12a8d25c0c22d95ba51cd9be639#rd]]></Url>"
//			+"<PicUrl><![CDATA[https://mmbiz.qlogo.cn/mmbiz/2pArOgr07iaKc2TurtpFJyMlTkhRZAGgxsTVIXu2G0RzTuqZEZBhGzkAyYiaibIclmWxo3qUXI5wicXTk246srkgUw/0]]></PicUrl>" 
//			+"<Description><![CDATA[社区服务项目]]></Description></item>"
//			+""
//			+ "</Articles></xml>";
//		}
//		return "";
//	}
//
//	@Override
//	public synchronized void  sendNoticeTemplateSYNC() {
//		List<NoticeTemplate> nts = getScheduledNoticeTemplates();
//		for (NoticeTemplate nt : nts) {
//			sendNoticeTemplate(nt);
//		}
//		
//	}
//}
