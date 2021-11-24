package Client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class loginfo extends JFrame implements ActionListener{
	private JLabel serIPLabel = null;
	private JLabel nameLabel = null;
	private JTextField serIPText = null;
	private JTextField nameText = null;
	private JButton loginBut = null;
	private JButton logoutBut = null;
	public loginfo()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(null);
		nameLabel = new JLabel("UserName:");
		nameLabel.setPreferredSize(new Dimension(100, 30));
		nameLabel.setBounds(100, 50, 100, 30);
		getContentPane().add(nameLabel);
		nameText = new JTextField("");
		nameText.setPreferredSize(new Dimension(100, 30));
		nameText.setBounds(210, 50, 100, 30);
		getContentPane().add(nameText);
		serIPLabel = new JLabel("Server IP:");
		serIPLabel.setPreferredSize(new Dimension(100, 30));
		serIPLabel.setBounds(100, 100, 100, 30);
		getContentPane().add(serIPLabel);
		serIPText = new JTextField("127.0.0.1");
		serIPText.setPreferredSize(new Dimension(100, 30));
		serIPText.setBounds(210, 100, 100, 30);
		getContentPane().add(serIPText);
		loginBut = new JButton("Enter");
		loginBut.setPreferredSize(new Dimension(80, 30));
		loginBut.setBounds(150, 200, 80, 30);
		getContentPane().add(loginBut);
		loginBut.addActionListener(this);
		logoutBut = new JButton("Exit");
		logoutBut.setPreferredSize(new Dimension(80, 30));
		logoutBut.setBounds(250, 200, 80, 30);
		getContentPane().add(logoutBut);
		logoutBut.addActionListener(this);
		this.setTitle("Choose Server");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// �Ѵ��ڷ�����Ļ�м�
		this.setPreferredSize(new Dimension(450, 350));
		this.setBounds(screenSize.width / 2 - 225, screenSize.height / 2 - 175,
				450, 350);
		this.setVisible(true);
		setResizable(false);
		pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginfo loginInfoFunction=new loginfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Enter")) {
			Client c=new Client(serIPText.getText(),nameText.getText());
			this.setVisible(false);
			this.dispose();
			
		} else {
			this.dispose();
		}
	}

}
