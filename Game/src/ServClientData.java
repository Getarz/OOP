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
	public String name = "";
	public int indexChar=0;
	public String IP="";
	public int checkPlayer = 0;
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
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									System.out.println("image 0");
								} else if (i == 1) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									System.out.println("image 1");
								} else if (i == 2) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									System.out.println("image 2");
								} else if (i == 3) {
									if(spt[0].equals(FrameGame.IP))
									{
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : "+spt[2]);
									}
									System.out.println("image 3");
								}
								server.panel.revalidate();
								server.revalidate();
							}
						}
						if(spt.length==3) {
							if(spt[0].equals(server.ip)) {
						
								int c = Integer.parseInt(spt[2]);
								int ran = Integer.parseInt(spt[1]);
								if(c==0) {
									server.labelPlayer0[checkPlayer].setIcon(server.card[ran]);
								}
								else if(c==1) {
									server.labelPlayer1[checkPlayer].setIcon(server.card[ran]);
								}
								else if(c==2) {
									server.labelPlayer2[checkPlayer].setIcon(server.card[ran]);
								}
//								else if(c==0) {
//									server.labelPlayer0[0].setIcon(server.card[ran]);
//								}
								checkPlayer++;
							}
						}
						if(spt.length==2) {
							System.out.println("check win");
							set();
							int c = Integer.parseInt(spt[1]);
							if(spt[0].equals("win")) {
								System.out.println("Win "+c);
								if(c==0) {
									server.labelWinner.setIcon(server.Winner[0]);
								}
								else if(c==1) {
									server.labelWinner.setIcon(server.Winner[1]);
								}
								else if(c==2) {
									server.labelWinner.setIcon(server.Winner[2]);
								}
								server.panel.revalidate();
								server.revalidate();
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
	public void set() {
		System.out.println("xxx");
	}

	
}
