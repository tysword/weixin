package cn.dt.weixin.message;

import org.springframework.beans.BeanUtils;

import cn.dt.weixin.message.request.BaseRequestMessage;
import cn.dt.weixin.message.request.EventMessage;
import cn.dt.weixin.message.request.ImageMessage;
import cn.dt.weixin.message.request.LinkMessage;
import cn.dt.weixin.message.request.LocationMessage;
import cn.dt.weixin.message.request.MessageVO;
import cn.dt.weixin.message.request.TextMessage;
import cn.dt.weixin.message.request.VideoMessage;
import cn.dt.weixin.message.request.VoiceMessage;

public class RequestMessageFactory {
	public static BaseRequestMessage convert2RequestMessage(MessageVO vo) {
		switch (MessageType.fromValue(vo.getMsgType())) {
		case text:
			return convert2TextMessage(vo);

		case image:
			return convert2ImageMessage(vo);

		case link:
			return convert2LinkMessage(vo);

		case location:
			return convert2LocationMessage(vo);

		case video:
			return convert2VideoMessage(vo);

		case voice:
			return convert2VoiceMessage(vo);
		case event:
			return convert2EventMessage(vo);
		default:
			break;
		}

		throw new IllegalArgumentException("无法处理消息：" + vo.getMsgType());
	}

	private static BaseRequestMessage convert2EventMessage(MessageVO vo) {
		EventMessage m = new EventMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2VoiceMessage(MessageVO vo) {
		VoiceMessage m = new VoiceMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2VideoMessage(MessageVO vo) {
		VideoMessage m = new VideoMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2LocationMessage(MessageVO vo) {
		LocationMessage m = new LocationMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2LinkMessage(MessageVO vo) {
		LinkMessage m = new LinkMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2ImageMessage(MessageVO vo) {
		ImageMessage m = new ImageMessage();
		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, m, ignoreProperties);

		return m;
	}

	private static BaseRequestMessage convert2TextMessage(MessageVO vo) {
		TextMessage t = new TextMessage();

		String[] ignoreProperties = {};
		BeanUtils.copyProperties(vo, t, ignoreProperties);

		return t;
	}
}
