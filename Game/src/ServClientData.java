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

import javax.print.attribute.standard.Severity;

public class ServClientData extends Thread {
	IngameFrame server;
	public String name = "";
	public int indexChar = 0;
	public String IP = "";
	public int checkPlayer = 0;
	public int checkBot = 0;
	public int position=0;
	public int setBack=0;
	public int win =0;
	public int checkReady =0;
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
								server.butReady.setVisible(true);
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
							if(spt[0].equals("SetDefault")) {
								System.out.println("set default ........");
							}
							
							server.chat.append(line + "\n");
						}
						if (spt.length == 4) {
							if (spt[0].equals("chat")) {
								if(spt[0].equals("chat")&&spt[2].equals(">>Game start in")&&spt[3].equals("5")) {
									AudioWin au = new AudioWin();
									au.StarGame();
								}
//								if(spt[0].equals("chat")&&spt[2].equals(">>Game start in")&&spt[3].equals("1")) {
//									AudioWin au = new AudioWin("stop");
//								}
								String str = spt[2] + " : " + spt[3];
								System.out.println(str+" >>");
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
								//System.out.println("set player  " + i);
								server.butReady.setVisible(true);
								if (i == 0) {
									if (spt[0].equals(FrameGame.IP)) {
										server.labelWait[i].setIcon(server.CharacterPlayer[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
										server.position = 0;
										
									} else {
										server.labelWait[i].setIcon(server.Character[indexCha]);
										server.labelPlayerName[i].setText("Name : " + spt[2]);
									}
									//System.out.println("image 0");
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
									//System.out.println("image 1");
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
									//System.out.println("image 2");
								}
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
								int m = Integer.parseInt(spt[1]);
								server.money[i] = m;
								server.labelMoney[i].setText("Money : " + server.money[i]);
							}


							server.panel.revalidate();
							server.revalidate();

						}
						if (spt.length == 5) {
							AudioWin audioWin = new AudioWin();
							//System.out.println("check ");
							int c = Integer.parseInt(spt[2]);
							int i = Integer.parseInt(spt[3]);
							if (spt[1].equals(server.ip)) {
								//System.out.println("Check win in 4");
								if (spt[0].equals("Win")) {
									server.labelNameWinner.setText("Winner is "+server.namePlayer);
									server.labelWinner.setIcon(server.Winner[c]);
									server.labelNameWinner.setLocation(520, 520);
									//server.money[i] = server.money[i] + 500;
									int hum1 = (int)(Math.random()*7)+1;
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
									}else if (hum1==6) {
										audioWin.Win_walkLong();
									}else if (hum1==7) {
										audioWin.Win_maidiadag22();
									}
									
									
								} else if (spt[0].equals("Lost")) {
									//System.out.println("Check lost");
									server.labelNameWinner.setText("Winner is BOT");
									server.labelNameWinner.setLocation(570, 520);
									server.labelWinner.setIcon(server.Winner[5]);
									//server.money[i] = server.money[i] - 500;
									//server.labelMoney[i].setText("Money : " + server.money[i]);
									int hum = (int)(Math.random()*7)+1;
									if (hum==1) {
										audioWin.Lost_DakEveryDay();
									}else if (hum==2) {
										audioWin.Lost_dakEveryDay2();
									}else if (hum==3) {
										audioWin.Lost_EatGrab();
									}else if (hum==4) {
										audioWin.Lost_maidaiDak();
									}else if (hum==5) {
										audioWin.Lost_janow();
									}else if (hum==6) {
										audioWin.Lost_nacom();
									}else if (hum==7) {
										audioWin.Lost_tungjai();
									}
								} 
								///////////// show money ////////////////////////
								for (int j = 0; j < server.money.length-1; j++) {
									server.labelMoney[i].setText("Money : " + server.money[j]);
								}
								
								
								int p=0;
								while(true) {
									try {
									Thread.sleep(1000);
										if (p == 6) {
											break;
										}
									p++;
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								for (int j = 0; j < 3; j++) {
									audioWin.clip.stop();
									System.out.println("set images to null "+i);
									server.labelPlayer0[j].setIcon(null);
									server.labelPlayer1[j].setIcon(null);
									server.labelPlayer2[j].setIcon(null);
									server.labelBot[j].setIcon(null);
									server.labelNameWinner.setText("");;
									server.labelWinner.setIcon(null);
									server.butReady.setEnabled(true);
								}
								checkPlayer=0;
								checkBot=0;
								setBack=0;
								server.butReady.setVisible(true);
								 
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
