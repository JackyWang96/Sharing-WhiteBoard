package draw;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class paint implements Serializable {
	
	private String drawStyle;
	private Point beginPoint, endPoint;
	
	public paint(Point bEPoint, Point eNPoint){
		beginPoint = bEPoint;
		endPoint = eNPoint;
	}
	
	public void setStyle(String nowStyle){
		drawStyle = nowStyle;
	}
	
	public String getStyle(){
		return drawStyle;
	}
	
	public void setBPoint(Point nowPoint){
		beginPoint = nowPoint;
	}
	
	public Point getBPoint(){
		return beginPoint;
	}
	
	public void setEPoint(Point nowPoint){
		endPoint = nowPoint;
	}
	
	public Point getEPoint(){
		return endPoint;
	}
	
}
