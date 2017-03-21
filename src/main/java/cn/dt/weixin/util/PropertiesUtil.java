package cn.dt.weixin.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 对属性文件操作的工具类 获取，新增，修改 注意： 以下方法读取属性文件会缓存问题,在修改属性文件时，不起作用， 　InputStream in =
 * PropertiesUtils.class.getResourceAsStream("/config.properties"); 　解决办法：
 * 　String savePath =
 * PropertiesUtils.class.getResource("/config.properties").getPath();
 */
public class PropertiesUtil {
	/**
	 * 获取属性文件的数据 根据key获取值
	 * 
	 * @param fileName
	 *            文件名　(注意：加载的是src下的文件,如果在某个包下．请把包名加上)
	 * @param key
	 * @return
	 */
	public static String findPropertiesKey(String key, String src) {

		try {
			Properties prop = getProperties(src);
			return prop.getProperty(key);
		} catch (Exception e) {
			return "";
		}

	}

//	public static void main(String[] args) {
//		// Properties prop = new Properties();
//		// InputStream in = PropertiesUtil.class
//		// .getResourceAsStream("/app.properties");
//		// try {
//		// prop.load(in);
//		// Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
//		// while (itr.hasNext()) {
//		// Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
//		// System.err.println((e.getKey().toString() + "" + e.getValue()
//		// .toString()));
//		// }
//		// } catch (Exception e) {
//		//			
//		// }
//		String findPropertiesKey = findPropertiesKey("settle_url",
//				"/app.properties");
//		System.out.println("----->" + findPropertiesKey);
//
//	}

	/**
	 * 返回　Properties
	 * 
	 * @param fileName
	 *            文件名　(注意：加载的是src下的文件,如果在某个包下．请把包名加上)
	 * @param
	 * @return
	 */
	public static Properties getProperties(String src) {
		Properties prop = new Properties();
		String savePath = PropertiesUtil.class.getResource(src).getPath();
		// 以下方法读取属性文件会缓存问题
		// InputStream in = PropertiesUtils.class
		// .getResourceAsStream("/config.properties");
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					savePath));
			prop.load(in);
		} catch (Exception e) {
			return null;
		}
		return prop;
	}

	/**
	 * 写入properties信息
	 * 
	 * @param key
	 *            名称
	 * @param value
	 *            值
	 */
	public static void modifyProperties(String key, String value, String src) {
		try {
			// 从输入流中读取属性列表（键和元素对）
			Properties prop = getProperties(src);
			prop.setProperty(key, value);
			String path = PropertiesUtil.class.getResource(src).getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			prop.store(outputFile, "modify");
			outputFile.close();
			outputFile.flush();
		} catch (Exception e) {
		}
	}
}
