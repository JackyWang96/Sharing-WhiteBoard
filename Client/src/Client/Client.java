package Client;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import draw.Chat;
import draw.Drawpan;
import draw.Creatthread;

public class Client extends JFrame {

    private Drawpan drawpan;
    private Chat chat;
    private int sendFlag;
    private static String serverip;
    private static String Usename;
    BufferedImage picture = new BufferedImage(760, 525,
            BufferedImage.TYPE_4BYTE_ABGR);
    Graphics hdc = picture.getGraphics();

    public Client(String ip, String username) {
        serverip = ip;
        Usename = username;
        drawpan = new Drawpan();
        drawpan.serverip = serverip;
        chat = new Chat();
        chat.serverip = serverip;
        chat.useName = Usename;
        this.setLayout(new BorderLayout());
        this.setLocation(400, 0);
        this.setSize(960, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Paint Client    " + Usename);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(drawpan);
        this.getContentPane().add(chat);
        new Thread(new Creatthread(this, drawpan, sendFlag)).start();

    }
}
