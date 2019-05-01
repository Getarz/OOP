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
	public int indexChar = 0;
	public String IP = "";
	public int checkPlayer = 0;
	public int checkBot = 0;
	public int position=0;
	public int setBack=0;
	
	public ServClientData(IngameFrame server) {
		this.server = server;
	}

	public ServClientData(IngameFrame ingameFrame, int indexCha, String nameStr) {
		this.indexChar = indexCha;
		this.name = nameStr;
		this.server = ingameFrame;
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
						System.out.println("Message : " + line);
						if (line.equalsIgnoreCase("Ready")) {
							try {
								Socket sk = new Socket(ClientFindServer.ipServ, 50111);
								PrintStream doStream = new PrintStream(sk.getOutputStream());
								doStream.println(FrameGame.IP + "-" + indexChar + "-" + name);
								doStream.close();
								System.out.println("ReadySucees");
							} catch (Exception e1) {
								System.out.println(">>>>>> " + e1);
							}
							System.out.println("bug bug1");

						}
						if(spt.length==1 ){
							server.chat.append(line + "\n");
						}
						if (spt.length == 4) {
							if (spt[0].equals("chat")) {
								String str = spt[2] + " : " + spt[3];
								System.out.println(str);
								server.chat.append(str + "\n");
								server.chat.revalidate();
							}
							if(spt[3].equals("Draw")&&(setBack<3)) {
								int pos = Integer.parseInt(spt[2]);
								int ran = Integer.parseInt(spt[1]);
								if(spt[0].equals(FrameGame.IP)) {
									if (server.position == 0) {
										server.labelPlayer0[2].setIcon(server.card[ran]);
									} else if (server.position == 1) {
										server.labelPlayer1[2].setIcon(server.card[ran]);
									} else if (server.position == 2) {
										server.labelPlayer2[2].setIcon(server.card[ran]);
									}
								}
								
								else {
									if (pos == 0) {
										server.labelPlayer0[2].setIcon(server.backCard);
									} else if (pos == 1) {
										server.labelPlayer1[2].setIcon(server.backCard);
									} else if (pos== 2) {
										server.labelPlayer2[2].setIcon(server.backCard);
									}
								}
								
							}
							if(spt[0].equals("Set Back")) {
								if(spt[0].equals("Set Back")) {
									setBack ++;
									System.out.println("Set back ...............");
									int poss = Integer.parseInt(spt[3]);
									int index = Integer.parseInt(spt[2]);
									if(spt[1].equals("-1")) {
										System.out.println("No card draw");
									}
									else {
										int rann = Integer.parseInt(spt[1]);
										int indexPlay = Integer.parseInt(spt[2]);
										if (poss == 0) {
											server.labelPlayer0[index].setIcon(server.card[rann]);
										} else if (poss == 1) {
											server.labelPlayer1[index].setIcon(server.card[rann]);
										} else if (poss == 2) {
											server.labelPlayer2[index].setIcon(server.card[rann]);
										}
									}
								}
							}
							else {
								int i = Integer.parseInt(spt[3]);
								int indexCha = Integer.parseInt(spt[1]);
								System.out.println("set player  " + i);
								
								if (i == 0) {
									if (spt[0].equals(FrameGame.IP)) {
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
										server.position = 0;
										
									} else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
									}
									System.out.println("image 0");
								} 
								else if (i == 1) {
									if (spt[0].equals(FrameGame.IP)) {
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
										server.position = 1;
									} else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
									}
									System.out.println("image 1");
								} 
								else if (i == 2) {
									if (spt[0].equals(FrameGame.IP)) {
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
										server.position = 2;
									} else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
									}
									System.out.println("image 2");
								} 
//								else if (i == 3) {
//									if (spt[0].equals(FrameGame.IP)) {
//										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
//										server.labelPlayerName[i].setText("Name : " + spt[2]);
//										server.position = 3;
//									} else {
//										server.labelWait[i].setIcon(server.Character[indexCha]);
//										server.labelPlayerName[i].setText("Name : " + spt[2]);
//									}
//									System.out.println("image 3");
//								}
								server.panel.revalidate();
								server.revalidate();
							}

							// ************ check win *************************************
							
						}
						if (spt.length == 3) {
							int c = Integer.parseInt(spt[2]);
							int ran = Integer.parseInt(spt[1]);
							if (spt[0].equals(server.ip)) {
								server.butDraw.setVisible(true);
								server.butPass.setVisible(true);
								server.butPass.setEnabled(true);
								server.butDraw.setEnabled(true);
								
								if (c == 0) {
									server.labelPlayer0[checkPlayer].setIcon(server.card[ran]);
									server.labelPlayer1[checkPlayer].setIcon(server.backCard);
									server.labelPlayer2[checkPlayer].setIcon(server.backCard);
									server.labelBot[checkPlayer].setIcon(server.backCard);
								} else if (c == 1) {
									server.labelPlayer0[checkPlayer].setIcon(server.backCard);
									server.labelPlayer1[checkPlayer].setIcon(server.card[ran]);
									server.labelPlayer2[checkPlayer].setIcon(server.backCard);
									server.labelBot[checkPlayer].setIcon(server.backCard);
								} else if (c == 2) {
									server.labelPlayer0[checkPlayer].setIcon(server.backCard);
									server.labelPlayer1[checkPlayer].setIcon(server.backCard);
									server.labelPlayer2[checkPlayer].setIcon(server.card[ran]);
									server.labelBot[checkPlayer].setIcon(server.backCard);
								}
//								else if(c==0) {
//									server.labelPlayer0[0].setIcon(server.card[ran]);
//								}
								System.out.println("Check player : "+checkPlayer);
								checkPlayer++;
							
							}
							
							if(checkPlayer==3) {
								checkPlayer=0;
							}
							if (spt[0].equals("bot")) {
								ran = Integer.parseInt(spt[1]);
								server.labelBot[checkBot].setIcon(server.card[ran]);
								checkBot++;
							} 
							if(spt[0].equals("money")) {
								int i = Integer.parseInt(spt[2]);
								server.labelMoney[i].setText("Money : " + spt[1]);
							}
							//////////////// set show card /////////////////////
							/*if(spt.length ==4&&spt[0].equals("Set Back")) {
								if(spt[0].equals("Set Back")) {
									System.out.println("Set back ...............");
									int pos = Integer.parseInt(spt[3]);
									if(spt[1].equals("-1")) {
										System.out.println("No card draw");
									}
									else {
										int ran = Integer.parseInt(spt[1]);
										int indexPlay = Integer.parseInt(spt[2]);
										if (pos == 0) {
											server.labelPlayer0[checkPlayer].setIcon(server.card[ran]);
										} else if (pos == 1) {
											server.labelPlayer1[checkPlayer].setIcon(server.card[ran]);
										} else if (pos == 2) {
											server.labelPlayer2[checkPlayer].setIcon(server.card[ran]);
										}
									}
								}
							}*/

							server.panel.revalidate();
							server.revalidate();

						}
						if (spt.length == 5) {
							AudioWin audioWin = new AudioWin();
							System.out.println("check ");
							int c = Integer.parseInt(spt[2]);
							int i = Integer.parseInt(spt[3]);
							if (spt[1].equals(server.ip)) {
								System.out.println("Check win in 4");
								if (spt[0].equals("Win")) {
									server.labelNameWinner.setText("Winner is "+server.namePlayer);
									server.labelWinner.setIcon(server.Winner[c]);
									server.money[i] = server.money[i] + 500;
									server.money[3] = server.money[3] - 500;
									int hum1 = (int)(Math.random()*5)+1;
									if (hum1==1) {
										audioWin.Win_100Year();
									}else if (hum1==2) {
										audioWin.Win_Ainong();
									}else if (hum1==3) {
										audioWin.Win_Guzeanpai();
									}else if (hum1==4) {
										audioWin.Win_hudMaMai();
									}else if (hum1==5) {
										audioWin.Win_soypisoy();
									}
									
									server.labelMoney[i].setText("Money : " + server.money[i]);
								} else if (spt[0].equals("Lost")) {
									System.out.println("Check lost");
									server.labelNameWinner.setText("Winner is BOT");
									server.labelNameWinner.setLocation(570, 520);
									server.labelWinner.setIcon(server.Winner[5]);
									server.money[i] = server.money[i] - 500;
									server.money[3] = server.money[3] + 500;
									server.labelMoney[i].setText("Money : " + server.money[i]);
									int hum = (int)(Math.random()*4)+1;
									if (hum==1) {
										audioWin.Lost_DakEveryDay();
									}else if (hum==2) {
										audioWin.Lost_dakEveryDay2();
									}else if (hum==3) {
										audioWin.Lost_EatGrab();
									}else if (hum==4) {
										audioWin.Lost_maidaiDak();
									}
								}
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
