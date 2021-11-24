package draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;
import Client.Client;

public class Drawpan extends JPanel implements Serializable{
	private Point beginPoint, endPoint;
	private int drawStyle;
	private Tool tool;
	private int releaseFlag, sendFlag;
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	private Client client;
	private Color setColor;
	public String serverip;
    BufferedImage picture = new BufferedImage(665, 525, BufferedImage.TYPE_4BYTE_ABGR); 
	Graphics hdc = picture.getGraphics();
	
	public Drawpan() throws HeadlessException {
		
		this.sendFlag = 1;
		beginPoint = new Point();
		endPoint =  new Point();
		releaseFlag = 1;
		tool = new Tool();
		drawStyle = tool.getStyle();
		
		
		this.setBounds(0, 0, 765, 525);
		this.setLayout(null);
		
		this.add(tool);
		this.setVisible(true);
		this.setBackground(new Color(255,255,255));
		
		getPoint();
		
		linkMessage();
		// TODO Auto-generated constructor stub
	}
	public void getPoint() {
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				endPoint = e.getPoint();
				releaseFlag = 1;
				sendMessage();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				beginPoint = e.getPoint();
				endPoint = e.getPoint();
				releaseFlag = 0;
				sendMessage();
			}
			
//			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
//			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}
//			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tool.getStyle() == 1) {
					beginPoint = endPoint;
					endPoint = e.getPoint();
					}
				if(tool.getStyle() == 1) 
					endPoint = e.getPoint();
				sendMessage();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}
	public Point getBPoint() {
		return beginPoint;
	}
	
	public void setBPoint(Point tempPoint) {
		beginPoint = tempPoint;
	}
	
	public Point getEPoint() {
		return endPoint;
	}
	
	public void setEPoint(Point tempPoint) {
		endPoint = tempPoint;
	}
	
	public void draw(Graphics g) {

		if(tool.getStyle() == 1) {
			Paintline drawLine = new Paintline(beginPoint, endPoint);
			drawLine.drawLine(g);
			tool.setPress(false);
		}

		if(tool.getFunction() == 1) {
			System.out.println("______!!!______");
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 665, 525);
			repaint();
			tool.setPress(false);
			tool.setFuntion(0);
			setColor(g);
		}
			
	}
	
	public void setPen(Graphics g) {
		
		Graphics2D g2D;
		g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(tool.getPen(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
	
	public void setColor(Graphics hdc) {
		if(tool.getColor() == 1)
			hdc.setColor(Color.BLACK);
		if(tool.getColor() == 2)
			hdc.setColor(Color.RED);
		if(tool.getColor() == 3)
			hdc.setColor(Color.ORANGE);
		if(tool.getColor() == 4)
			hdc.setColor(Color.YELLOW);
		if(tool.getColor() == 5)
			hdc.setColor(Color.GREEN);
		if(tool.getColor() == 6)
			hdc.setColor(Color.BLUE);
		if(tool.getColor() == 7)
			hdc.setColor(Color.PINK);
		if(tool.getColor() == 8)
			hdc.setColor(Color.WHITE);
		if(tool.getColor() == 9)
			hdc.setColor(tool.getMoreColor());
	}
	
	public void paint(Graphics g) {
	    super.paint(g);
	    g.drawImage(picture, 0, 0, picture.getWidth(), picture.getHeight(), null);
	    hdc.setColor(Color.black);
	    setColor(hdc);
	    setPen(hdc);

	    if(releaseFlag == 0)
		    draw(hdc);
		if(tool.getStyle() == 2 && releaseFlag == 1) {
			Paintrect paintrect  = new Paintrect (beginPoint, endPoint);
			paintrect .drawRectangle(hdc);
			setBPoint(new Point());
			setEPoint(new Point());
			tool.setPress(false);
		}
		if(tool.getStyle() == 3 && releaseFlag == 1) {
			Paintline straightline = new Paintline(beginPoint, endPoint);
			straightline.drawLine(hdc);
			setBPoint(new Point());
			setEPoint(new Point());
			tool.setPress(false);
			
		}
		if(tool.getStyle() == 4 && releaseFlag == 1) {
			Paintoval oval = new Paintoval(beginPoint, endPoint);
			oval.drawoval(hdc);
			setBPoint(new Point());
			setEPoint(new Point());
			tool.setPress(false);
			
		}
	    repaint(1);
	  }
	
	public BufferedImage getPicture() {
		return picture;
	}
	
	public void linkMessage() {
		try {
			Socket messageSocket = new Socket(serverip, 8000);
			
			fromServer = new DataInputStream(messageSocket.getInputStream());
			toServer = new DataOutputStream(messageSocket.getOutputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getMessage() {
		try {
			beginPoint.x = fromServer.readInt();
			beginPoint.y = fromServer.readInt();
			endPoint.x = fromServer.readInt();
			endPoint.y = fromServer.readInt();
			tool.setPen(fromServer.readInt());
			tool.setStyle(fromServer.readInt());
			releaseFlag = fromServer.readInt();
			tool.setColor(fromServer.readInt());
			tool.setMoreColor(fromServer.readInt());
			tool.setFuntion(fromServer.readInt());
			this.repaint();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage() {
		
		try {
			toServer.writeInt(beginPoint.x);
			toServer.writeInt(beginPoint.y);
			toServer.writeInt(endPoint.x);
			toServer.writeInt(endPoint.y);
			toServer.writeInt(tool.getPen());
			toServer.writeInt(tool.getStyle());
			toServer.writeInt(releaseFlag);
			toServer.writeInt(tool.getColor());
			toServer.writeInt(tool.getMoreColor().getRGB());
			toServer.writeInt(tool.getFunction());
			toServer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getReleaseFlag() {
		return releaseFlag;
	}
	
}
