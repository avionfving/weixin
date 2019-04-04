package edu.gdkm.weixin.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import edu.gdkm.weixin.domain.InMessage;
import edu.gdkm.weixin.domain.event.EventInMessage;
import edu.gdkm.weixin.domain.image.ImageInMessage;
import edu.gdkm.weixin.domain.link.LinkInMessage;
import edu.gdkm.weixin.domain.location.LocationInMessage;
import edu.gdkm.weixin.domain.shortvideo.ShortVideoInMessage;
import edu.gdkm.weixin.domain.text.TextInMessage;
import edu.gdkm.weixin.domain.video.VideoInMessage;
import edu.gdkm.weixin.domain.voice.VoiceInMessage;

public class MessageTypeMapper {
	
	private static Map<String, Class<? extends InMessage>> typeMap = new ConcurrentHashMap<>();
	
	// 通过一个Map记录了消息类型和类的关系
	static {
		typeMap.put("text", TextInMessage.class);
		typeMap.put("image", ImageInMessage.class);
		typeMap.put("voice", VoiceInMessage.class);
		typeMap.put("video", VideoInMessage.class);
		typeMap.put("shortvideo", ShortVideoInMessage.class);
		typeMap.put("location", LocationInMessage.class);
		typeMap.put("link", LinkInMessage.class);
		typeMap.put("event", EventInMessage.class);
	}
	
	// 通过消息类型获取对应的类
		@SuppressWarnings("unchecked")
		public static <T extends InMessage> Class<T> getClass(String type) {
			return (Class<T>) typeMap.get(type);
	}
	
}
