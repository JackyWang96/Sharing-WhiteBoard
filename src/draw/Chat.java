package draw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class Chat extends JPanel {

	Socket s;
	DataOutputStream out;
	DataInputStream in = null;
	private boolean isConnected = false;
	private int sendFlag;
	public String useName,serverip;
	JTextArea ta1 = new JTextArea();
	JTextField tf1 = new JTextField();
	
	JLabel l1 = new JLabel("Enter:");
	JLabel l2 = new JLabel("History:");
	
	JButton btn1 = new JButton("Send");

	public Chat() {
		this.sendFlag = 2;
		this.setLayout(null);
		l2.setBounds(770, 0, 100, 30);
		l1.setBounds(770, 360, 100, 30);	
		tf1.setBounds(770, 400, 170, 40);		
		ta1.setBounds(770, 40, 170, 280);
		btn1.setBounds(870, 477, 70, 48);
		this.setBounds(760, 0, 170, 640);
		this.add(l1);
		this.add(tf1);
		this.add(l2);
		this.add(ta1);
		this.add(btn1);

		btn1.addActionListener(new TFListener() {

		});

		tf1.addActionListener(new TFListener());

		connect();

		new Thread(new recvThread()).start();
	}

	class recvThread implements Runnable {

		@Override
		public void run() {
			while (isConnected) {
				try {
					String message = in.readUTF();
					ta1.setText(ta1.getText() + message + "\n");
					System.out.println(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void connect() {
		try {
			s = new Socket(serverip, 8100);
			isConnected = true;
			out = new DataOutputStream(s.getOutputStream());
			System.out.println("Connected...");
			in = new DataInputStream(s.getInputStream());
		} catch (UnknownHostException e) {

			System.out.println("Can't Find Server");
		} catch (IOException e) {

			System.out.println("Error");
		}
	}

	class TFListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tf1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Text Can not be null", "Message Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String message = useName+ " :" + tf1.getText().trim();
			tf1.setText("");
			try {
				System.out.println("!!!");
				out.writeUTF(message);
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
