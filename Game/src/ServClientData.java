import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class ServClientData extends Thread {
	IngameFrame server;
	String name = "";
	int indexChar=0;
	String IP="";
	public ServClientData(IngameFrame server) {
		this.server =server;
	}

	public ServClientData(IngameFrame ingameFrame, int indexCha,String nameStr) {
		this.indexChar=indexCha;
		this.name=nameStr;
		this.server =ingameFrame;
	}
	public ServClientData() {
		// TODO Auto-generated constructor stub
	}
	public ServClientData(String text) {
		this.name = text;
	}

	public void run() {
		ServerSocket servSoket;
		try {
			servSoket = new ServerSocket(50113);
			while (true) {
				try {
					String line = "";
					Socket socket = servSoket.accept();
					InputStream input = socket.getInputStream();
					InputStreamReader inputStream = new InputStreamReader(input);
					BufferedReader bufferIn = new BufferedReader(inputStream);
					while ((line = bufferIn.readLine()) != null) {
						String[] spt = line.split("-");
						System.out.println("Message : "+line);
						if (line.equalsIgnoreCase("Ready")) {
							try {
								
								Socket sk = new Socket(ClientFindServer.ipServ, 50111);
								
								PrintStream doStream = new PrintStream(sk.getOutputStream());
								doStream.println(FrameGame.IP+"-"+indexChar+"-"+name);
							
								doStream.close();
								System.out.println("ReadySucees");
							} catch (Exception e1) {
								System.out.println(">>>>>> " + e1);
							}
							System.out.println("bug bug1");
							
						}
						if (spt.length == 4) {
							if (spt[0].equals("chat")) {
								String str = spt[2] + " : " + spt[3];
								System.out.println(str);
								server.chat.append(str + "\n");
								server.chat.revalidate();
							} else {
								int i = Integer.parseInt(spt[3]);
								int indexCha = Integer.parseInt(spt[1]);
								System.out.println("bug bug2  "+i);
								if (i == 0) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
									}
									
									System.out.println("image 0");
									System.out.println("image 0");
								} else if (i == 1) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
									}
									System.out.println("image 1");
								} else if (i == 2) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
									}
									System.out.println("image 2");
								} else if (i == 3) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
									}
									System.out.println("image 3");
								}
								server.panel.revalidate();
							}

						}
						if(spt.length==2) {
							if(spt[0].equals("set")) {
								server.chat.append(spt[1] + "\n");
								server.chat.revalidate();
							}
						}

					}
					bufferIn.close();
					socket.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
