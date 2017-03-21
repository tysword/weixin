package cn.dt.weixin.service;

import java.util.List;

import cn.dt.weixin.message.request.MessageVO;
import cn.dt.weixin.po.NoticeTemplate;

public interface IWeixinService {
	public String handleRequest(MessageVO vo);

	public List<NoticeTemplate> getScheduledNoticeTemplates();

	public void sendNoticeTemplate(NoticeTemplate nt);

	public void sendNoticeTemplateSYNC();
} 
