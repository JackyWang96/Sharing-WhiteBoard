package draw;

import Client.Client;

public class Creatthread implements Runnable{

	private Client client;
	private Drawpan drawpan;
	
	public Creatthread(Client client, Drawpan drawpan, int sendFlag) {
		this.client = client;
		this.drawpan = drawpan;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(!client.isActive()) {

				drawpan.getMessage();
			}

		}
	}

}
