package draw;

import java.awt.Graphics;
import java.awt.Point;

public class Paintrect extends paint{

	public Paintrect(Point bEPoint, Point eNPoint) {
		super(bEPoint, eNPoint);
	}

	public void drawRectangle(Graphics paintGraphics){
		if(this.getBPoint().x > this.getEPoint().x)
			if(this.getBPoint().y > this.getEPoint().y)
				paintGraphics.drawRect(this.getEPoint().x, this.getEPoint().y,
				                       Math.abs(this.getBPoint().x - this.getEPoint().x), 
				                       Math.abs(this.getBPoint().y - this.getEPoint().y));
			else
				paintGraphics.drawRect(this.getEPoint().x, this.getBPoint().y,
	                       Math.abs(this.getBPoint().x - this.getEPoint().x), 
	                       Math.abs(this.getBPoint().y - this.getEPoint().y));
		else if(this.getBPoint().y > this.getEPoint().y)
			paintGraphics.drawRect(this.getBPoint().x, this.getEPoint().y,
                    Math.abs(this.getBPoint().x - this.getEPoint().x), 
                    Math.abs(this.getBPoint().y - this.getEPoint().y));
		else
			paintGraphics.drawRect(this.getBPoint().x, this.getBPoint().y,
                    Math.abs(this.getBPoint().x - this.getEPoint().x), 
                    Math.abs(this.getBPoint().y - this.getEPoint().y));
	}
	
}
