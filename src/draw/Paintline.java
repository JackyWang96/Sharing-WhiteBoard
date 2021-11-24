package draw;

import java.awt.Graphics;
import java.awt.Point;

public class Paintline extends paint{
	
	public Paintline(Point bEPoint, Point eNPoint){
		super(bEPoint, eNPoint);
	}
	
	public void drawLine(Graphics g){
		g.drawLine(this.getBPoint().x, this.getBPoint().y, this.getEPoint().x, 
				                       this.getEPoint().y);
		this.setBPoint(getEPoint());
	}
	
}
