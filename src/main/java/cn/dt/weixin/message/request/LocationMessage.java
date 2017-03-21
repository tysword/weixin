package cn.dt.weixin.message.request;

/**
 * 地理消息类
 * 
 * @author tangyu
 * 
 */
public class LocationMessage extends BaseRequestMessage {
	private double locationX; // 地理位置维度
	private double locationY; // 地理位置精度
	private double scale; // 地图缩放大小
	private String label; // 地理位置信息

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
