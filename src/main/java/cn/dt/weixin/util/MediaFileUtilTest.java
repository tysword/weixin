package cn.dt.weixin.util;

import java.io.File;

import cn.dt.weixin.message.MediaMessage;

import org.junit.Test;

public class MediaFileUtilTest {

	@Test
	public void testUploadMedia() throws Exception {
		File f = new File("c:\\b.mp4");
		MediaMessage m = new MediaMessage();
		m.setFile(f);
		m.setType(MediaMessage.TYPE_VIDEO);

//		m = MediaFileUtil.uploadMedia(m);

		System.out.println(m);

	}

}
