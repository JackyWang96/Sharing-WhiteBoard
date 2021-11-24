package draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class Tool extends JPanel{
	private JButton color_black, color_red, color_yellow, color_orange, color_blue, color_green, color_pink, color_white, color_moreColor;
	private JButton tool_pencil, tool_rectangle, tool_bigpen, tool_smallpen,tool_straight,tool_circle;
	private JButton clear;
	private int color, style, function, pen;
	private Color selectedColor = Color.BLACK;
	private boolean pressFlag;

	public Tool() {
		color = 1;
		style = 1;
		function = 0;
		pressFlag = false;

		this.setBounds(665, 0, 100, 525);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLayout(null);

		color_black = new JButton("B");
		color_red = new JButton("R");
		color_orange = new JButton("O");
		color_yellow = new JButton("Y");
		color_blue = new JButton("B");
		color_green = new JButton("G");
		color_pink = new JButton("P");
		tool_straight =new JButton(new ImageIcon("src/picture/zhixian.png "));
		tool_circle = new JButton(new ImageIcon("src/picture/circle.png "));
		color_white = new JButton(new ImageIcon("src/picture/xiangpi.png "));
		color_moreColor = new JButton(new ImageIcon("src/picture/moreColor.png"));
		tool_rectangle = new JButton(new ImageIcon("src/picture/juxing.jpg"));
		tool_pencil = new JButton(new ImageIcon("src/picture/pencil.png "));
		tool_bigpen = new JButton("Wide");
		tool_smallpen = new JButton("Thin");
		clear = new JButton(" Clean");
		setPaintAction();
		setPaintBLayout();
		this.add(color_black);
		this.add(color_red);
		this.add(color_yellow);
		this.add(color_orange);
		this.add(color_blue);
		this.add(color_green);
		this.add(color_pink);
		this.add(color_white);
		this.add(color_moreColor);
		this.add(tool_rectangle);
		this.add(tool_pencil);
		this.add(tool_bigpen);
		this.add(tool_smallpen);
		this.add(clear);
		this.add(tool_straight);
		this.add(tool_circle);
	}

	public void setPaintAction() {
		color_black.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 1;
				pressFlag = true;
			}
		});

		color_red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 2;
				pressFlag = true;
			}
		});

		color_orange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 3;
				pressFlag = true;
			}
		});

		color_yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 4;
				pressFlag = true;
			}
		});

		color_green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 5;
				pressFlag = true;
			}
		});

		color_blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 6;
				pressFlag = true;
			}
		});

		color_pink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 7;
				pressFlag = true;
			}
		});

		color_white.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 8;
				pressFlag = true;
			}
		});

		color_moreColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				color = 9;
				JColorChooser colorchooser = new JColorChooser();
				colorchooser.setVisible(true);
				selectedColor = JColorChooser.showDialog(color_moreColor, "Choose Color",
						Color.BLACK);
				tool_bigpen.setBackground(new Color(selectedColor.getRGB()));
				tool_smallpen.setBackground(new Color(selectedColor.getRGB()));
				pressFlag = true;
			}
		});

		tool_bigpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pen = 20;
				pressFlag = true;
			}
		});

		tool_smallpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pen = 1;
				pressFlag = true;
			}
		});

		tool_rectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				style = 2;
				pressFlag = true;
			}
		});

		tool_pencil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				style = 1;
				pressFlag = true;
			}
		});
         tool_circle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				style = 4;
				pressFlag = true;
			}
		});
		tool_straight.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				// TODO Auto-generated method stub
 				style = 3;
 				pressFlag = true;
 			}
 		});
		clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				function = 1;
				pressFlag = true;
			}
		});

	}

	public void setPaintBLayout() {
		color_black.setBounds(0, 0, 50, 50);
		color_black.setBackground(Color.BLACK);
		color_black.setFont(new Font("楷体", 1, 15){});
		color_red.setBackground(Color.RED);
		color_red.setBounds(50, 0, 50, 50);
		color_red.setFont(new Font("楷体", 1, 15){});
		color_orange.setBackground(Color.ORANGE);
		color_orange.setBounds(0, 50, 50, 50);
		color_orange.setFont(new Font("楷体", 1, 15){});
		color_yellow.setBackground(Color.YELLOW);
		color_yellow.setBounds(50, 50, 50, 50);
		color_yellow.setFont(new Font("楷体", 1, 15){});
		color_green.setBackground(Color.GREEN);
		color_green.setBounds(0, 100, 50, 50);
		color_green.setFont(new Font("楷体", 1, 15){});
		color_blue.setBackground(Color.BLUE);
		color_blue.setBounds(50, 100, 50, 50);
		color_blue.setFont(new Font("楷体", 1, 15){});
		color_pink.setBackground(Color.PINK);
		color_pink.setBounds(0, 150, 50, 50);
		color_pink.setFont(new Font("楷体", 1, 15){});
		color_white.setBackground(Color.WHITE);
		color_white.setBounds(50, 150, 50, 50);
		color_moreColor.setBounds(0, 350, 100, 100);
		tool_rectangle.setBackground(new Color(255,255,255));
		tool_rectangle.setBounds(50, 200, 50, 50);
		tool_straight.setBackground(new Color(255,255,255));
		tool_straight.setBounds(0, 300, 50, 50);
		tool_circle.setBackground(new Color(255,255,255));
		tool_circle.setBounds(50, 300, 50, 50);
		tool_pencil.setBounds(0, 200, 50, 50);
		tool_bigpen.setBounds(0, 250, 50, 50);
		tool_bigpen.setBackground(new Color(255,255,255));
		tool_bigpen.setFont(new Font("楷体", 1, 8){});
		tool_smallpen.setBounds(50, 250, 50, 50);
		tool_smallpen.setBackground(new Color(255,255,255));
		tool_smallpen.setFont(new Font("楷体", 1, 8){});
		clear.setBounds(0, 450, 100, 75);
		clear.setBackground(new Color(255,255,255));
		clear.setFont(new Font("楷体", 1, 15){});
	}
	
	public int getPen() {
		
		return pen;
	}
	
	public void setPen(int pen) {

		this.pen = pen;
	}	
	
	public int getColor() {
		
		return color;
	}
	
	public void setColor(int color) {
		
		this.color = color;
	}
	
	public Color getMoreColor() {
		
		return selectedColor;
	}
	
	public void setMoreColor(int moreColor) {
		Color color = new Color(moreColor);
		this.selectedColor = color;
	}		
	
	public int getStyle() {
		
		return style;
	}
	
	public void setStyle(int style) {
		
		this.style = style;
	}
	
	public boolean isPress() {
		
		return pressFlag;
	}
	
	public void setPress(boolean flag) {
		pressFlag = flag;
		
	}
	
	public int getFunction() {
		
		return function;
	}
	
	public void setFuntion(int function) {
		
		this.function= function;
	}
}
