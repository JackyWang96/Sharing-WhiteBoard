package draw;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Paintoval  implements Serializable{
	public Point Beginpoint,Endpoint;
	public Paintoval(Point bpoint,Point epoint){	
		Beginpoint=bpoint;
		Endpoint=epoint;
	}
	public void drawoval(Graphics g){
		if(Beginpoint.x >Endpoint.x)
			if(Beginpoint.y > Endpoint.y)
				g.fillOval(Endpoint.x, Endpoint.y, 
				                       Math.abs(Beginpoint.x - Endpoint.x), 
				                       Math.abs(Beginpoint.y - Endpoint.y));
			else
				g.fillOval(Endpoint.x, Beginpoint.y, 
	                       Math.abs(Beginpoint.x - Endpoint.x), 
	                       Math.abs(Beginpoint.y - Endpoint.y));
		else if(Beginpoint.y > Endpoint.y)
			g.fillOval(Beginpoint.x, Endpoint.y, 
                    Math.abs(Beginpoint.x - Endpoint.x), 
                    Math.abs(Beginpoint.y - Endpoint.y));
		else
			g.fillOval(Beginpoint.x, Beginpoint.y, 
                    Math.abs(Beginpoint.x - Endpoint.x), 
                    Math.abs(Beginpoint.y - Endpoint.y));
		
	}
}
