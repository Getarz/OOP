import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.IndexColorModel;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.omg.CORBA.FREE_MEM;

public class IngameFrame extends JFrame{
	public ImageIcon edgePlayer;
	public ImageIcon bg;
	public ImageIcon table;
	public ImageIcon icon;
	public ImageIcon personWait;
	public ImageIcon Character[] = new ImageIcon[5];
	public ImageIcon CharacterPlayer[] = new ImageIcon[5];
	public ImageIcon edgeLetChat;
	public ImageIcon detailR;
	public ImageIcon detailL;
	public JLabel labeledPlayer;
	public JLabel labelBG;
	public JLabel labelTable;
	public JLabel labelWait[] = new JLabel[4];
	public JLabel labelCha[] = new JLabel[5];
	public JLabel labeledLetChat;
	public JLabel labeldetailR1;
	public JLabel labeldetailL1;
	public JLabel labeldetailR2;
	public JLabel labeldetailL2;
	static TextArea chat = new TextArea("",10,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	public int IndexCha=0;
	public String namePlayer ="";
	public String ip ="";
	public JButton butSend = new JButton("SEND");
	public JButton butExit = new JButton("Exit Program");
	public JTextField sendMessage = new JTextField();
	static public int position=0;
	public ImageIcon allCard;
	public JLabel labelAllCard;
	JPanel panel = new JPanel(null);
	/************CARD***************/
	public ImageIcon card[] = new ImageIcon[52];
	public JLabel labelCard[] = new JLabel[52];
	public ImageIcon backCard;
	public JLabel labelBot[] = new JLabel[3];
	public JLabel labelPlayer0[] = new JLabel[3];
	public JLabel labelPlayer1[] = new JLabel[3];
	public JLabel labelPlayer2[] = new JLabel[3];
	public int pointCard[] = new int[52];
	public JLabel labelPlayerName[] = new JLabel[3];
	public JLabel labelMoney[] = new JLabel[4];
	public static int money[] = new int[4];
	/**************CARD***************/
	public ImageIcon Winner[] = new ImageIcon[6];
	public JLabel labelWinner;
	public JLabel labelNameWinner;
	/**********************************************/
	public JButton butDraw = new JButton("Draw Card");
	public JButton butPass = new JButton("Pass");
	public JButton butReady = new JButton("Ready");
	public ImageIcon truePNG;
	public JLabel labeltruePNG ;
	public static int checknumReady=0 ;
	
	public IngameFrame(int indexCha, String namePlayer){
		ServClientData serv = new ServClientData(this,indexCha,namePlayer);
		serv.start();
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			ip = inetAddress.getHostAddress();
			this.ip = ip;
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.IndexCha = indexCha;
		this.namePlayer = namePlayer;
		System.out.println(ip+"IPPPPPPPPPPPPPPPPPPP "+IndexCha+"  index "+namePlayer+" nameP");
		AudioPiano playPiano = new AudioPiano();
		
		Font Tahoma12Plain  = new Font("Tahoma", Font.PLAIN, 12);
		Font Tahoma16Plain  = new Font("Tahoma", Font.PLAIN, 16);
		Font Tahoma16  = new Font("Tahoma", Font.BOLD, 16);
		Font Tahoma20  = new Font("Tahoma", Font.BOLD, 20);
		Font Tahoma28  = new Font("Tahoma", Font.BOLD, 28);
		icon = new ImageIcon(getClass().getResource("casino2.png"));
		setIconImage(icon.getImage());
		/********************************************************************/
		setTitle("POK POK v1.0 Player Name : " + namePlayer);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/********************************************************************/
		bg = new ImageIcon(getClass().getResource("bg.jpg"));
		labelBG = new JLabel(bg);
		labelBG.setLocation(0, 0);
		labelBG.setSize(1280, 720);
		/********************************************************************/
		table = new ImageIcon(getClass().getResource("table.png"));
		labelTable = new JLabel(table);
		labelTable.setLocation(60,80);
		labelTable.setSize(880,470);
		/**************************WINNER************************/
		Winner[0] = new ImageIcon(getClass().getResource("Tu_WInner.gif"));
		Winner[1] = new ImageIcon(getClass().getResource("Sin_WInner.gif"));
		Winner[2] = new ImageIcon(getClass().getResource("TNA_WInner.gif"));
		Winner[3] = new ImageIcon(getClass().getResource("Pom_WInner.gif"));
		Winner[4] = new ImageIcon(getClass().getResource("Ying_WInner.gif"));
		Winner[5] = new ImageIcon(getClass().getResource("Bot_WInner.gif"));
		labelWinner = new JLabel(Winner[5]);
		labelWinner.setSize(500, 500);
		labelWinner.setLocation(390, 110);
		labelWinner.setIcon(null);
		labelNameWinner = new JLabel();
		labelNameWinner.setFont(Tahoma20);
		labelNameWinner.setSize(250, 60);
		labelNameWinner.setLocation(520 , 520);
		/********************************************************************/
		for (int i = 0; i < money.length-1; i++) {
			money[i]=5000;
		}
		money[3]=100000;
		labelMoney[0] = new JLabel("Money : "+money[0]);
		labelMoney[1] = new JLabel("Money : "+money[1]);
		labelMoney[2] = new JLabel("Money : "+money[2]);
		labelMoney[3] = new JLabel("Money : "+money[3]);
		labelMoney[0].setSize(200,60);
		for (int i = 0; i < money.length; i++) {
			labelMoney[i].setSize(200,60);
			labelMoney[i].setFont(Tahoma16);
		}
		labelMoney[0].setLocation(45, 70);
		labelMoney[1].setLocation(780, 70);
		labelMoney[2].setLocation(45, 525);
		labelMoney[3].setLocation(780, 525);
		/********************************************************************/
		allCard = new ImageIcon(getClass().getResource("All_card.png"));
		labelAllCard = new JLabel(allCard);
		labelAllCard.setSize(100,100);
		labelAllCard.setLocation(300,270);
		/****************************LABEL NAME**********************************/
		labelPlayerName[0] = new JLabel("Name :");
		labelPlayerName[1] = new JLabel("Name :");
		labelPlayerName[2] = new JLabel("Name :");
		for (int i = 0; i < labelPlayerName.length; i++) {
			labelPlayerName[i].setSize(200, 60);
			labelPlayerName[i].setFont(Tahoma16);
		}
		labelPlayerName[0].setLocation(45,50);
		labelPlayerName[1].setLocation(780,50);
		labelPlayerName[2].setLocation(45,505);
		/********************************************************************/
		int numcard=1;
		for (int i = 0; i < 13; i++) {
			card[i] = new ImageIcon(getClass().getResource("clubs_"+(i+1)+".png"));
		}
		for (int i = 13; i < 26; i++) {
			card[i] = new ImageIcon(getClass().getResource("spades_"+(numcard)+".png"));
			numcard++;
		}
		numcard=1;
		for (int i = 26; i < 39; i++) {
			card[i] = new ImageIcon(getClass().getResource("hearts_"+(numcard)+".png"));
			numcard++;
		}
		numcard=1;
		for (int i = 39; i < 52; i++) {
			card[i] = new ImageIcon(getClass().getResource("diamonds_"+(numcard)+".png"));
			numcard++;
		}
		numcard=1;
		for (int i = 0; i < labelCard.length; i++) {
			labelCard[i] = new JLabel(card[i]);
			labelCard[i].setSize(60, 87);
		}
		/********************************************************************/
		int numcard2 = 1;
		for (int i = 0; i < pointCard.length; i++) {
			if(i>=0&&i<=9) {
				pointCard[i]=numcard2;
				numcard2++;
			}
			else if(i>=10&&i<=12) {
				pointCard[i]=10;
				numcard2 = 1;
			}
			else if(i>=13&&i<=22) {
				pointCard[i]=numcard2;
				numcard2++;
			}
			else if(i>=23&&i<=25) {
				pointCard[i]=10;
				numcard2 = 1;
			}
			else if(i>=26&&i<=35) {
				pointCard[i]=numcard2;
				numcard2++;
			}
			else if(i>=36&&i<=38) {
				pointCard[i]=10;
				numcard2 = 1;
			}
			else if(i>=39&&i<=48) {
				pointCard[i]=numcard2;
				numcard2++;
			}
			else if(i>=49&&i<=51) {
				pointCard[i]=10;
				numcard2 = 1;
			}
			System.out.println(pointCard[i]);
		}
		/********************************************************************/
		Character[0] = new ImageIcon(getClass().getResource("tu100.png"));
		Character[1] = new ImageIcon(getClass().getResource("tuksin100.png"));
		Character[2] = new ImageIcon(getClass().getResource("tanaton100.png"));
		Character[3] = new ImageIcon(getClass().getResource("pom100.png"));
		Character[4] = new ImageIcon(getClass().getResource("sudarad100.png"));
		CharacterPlayer[0] = new ImageIcon(getClass().getResource("Tu_RGB.gif"));
		CharacterPlayer[1] = new ImageIcon(getClass().getResource("Sin_RGB.gif"));
		CharacterPlayer[2] = new ImageIcon(getClass().getResource("TNA_RGB.gif"));
		CharacterPlayer[3] = new ImageIcon(getClass().getResource("Pom_RGB.gif"));
		CharacterPlayer[4] = new ImageIcon(getClass().getResource("YING_RGB.gif"));
		labelCha[0] = new JLabel();
		for (int i = 0; i < labelCha.length; i++) {
			labelCha[i] = new JLabel(Character[i]);
			labelCha[i].setSize(100, 100);
		}
		/********************************************************************/
		personWait = new ImageIcon(getClass().getResource("PersonNull.png"));
		for (int i = 0; i < labelWait.length; i++) {
			labelWait[i] = new JLabel(personWait);
			labelWait[i].setSize(100, 100);
		}
		labelWait[0].setLocation(230,45);
		labelWait[1].setLocation(680,45);
		labelWait[2].setLocation(230,500);
		//labelWait[3].setLocation(680,500);
		/*******************************BOT*******************************/
		backCard = new ImageIcon(getClass().getResource("Back_card.png"));
		for (int i = 0; i < labelBot.length; i++) {
			labelBot[i] = new JLabel(backCard);
			labelBot[i].setSize(60, 87);
		}
		labelBot[0].setLocation(400, 275);
		labelBot[1].setLocation(470, 275);
		labelBot[2].setLocation(540, 275);
		for (int i = 0; i < labelBot.length; i++) {
			labelBot[i].setIcon(null);
		}
		/*******************************player 0 *******************************/
		backCard = new ImageIcon(getClass().getResource("Back_card.png"));
		for (int i = 0; i < labelPlayer0.length; i++) {
			labelPlayer0[i] = new JLabel(backCard);
			labelPlayer0[i].setSize(60, 87);
		}
		labelPlayer0[0].setLocation(240, 160);
		labelPlayer0[1].setLocation(310, 160);
		labelPlayer0[2].setLocation(380, 160);
		for (int i = 0; i < labelPlayer0.length; i++) {
			labelPlayer0[i].setIcon(null);
		}
		/*******************************player 1 *******************************/
		backCard = new ImageIcon(getClass().getResource("Back_card.png"));
		for (int i = 0; i < labelPlayer1.length; i++) {
			labelPlayer1[i] = new JLabel(backCard);
			labelPlayer1[i].setSize(60, 87);
		}
		labelPlayer1[0].setLocation(700, 160);
		labelPlayer1[1].setLocation(630, 160);
		labelPlayer1[2].setLocation(560, 160);
		for (int i = 0; i < labelPlayer0.length; i++) {
			labelPlayer1[i].setIcon(null);
		}
		/*******************************player 2 *******************************/
		backCard = new ImageIcon(getClass().getResource("Back_card.png"));
		for (int i = 0; i < labelPlayer2.length; i++) {
			labelPlayer2[i] = new JLabel(backCard);
			labelPlayer2[i].setSize(60, 87);
		}
		labelPlayer2[0].setLocation(240, 400);
		labelPlayer2[1].setLocation(310, 400);
		labelPlayer2[2].setLocation(380, 400);
		for (int i = 0; i < labelPlayer0.length; i++) {
			labelPlayer2[i].setIcon(null);
		}
		/********************************************************************/
		detailL = new ImageIcon(getClass().getResource("leftData.png"));
		labeldetailL1 = new JLabel(detailL);
		labeldetailL1.setSize(250, 80);
		labeldetailL1.setLocation(35,55);
		labeldetailL2 = new JLabel(detailL);
		labeldetailL2.setSize(250, 80);
		labeldetailL2.setLocation(35,510);
		/********************************************************************/
		detailR = new ImageIcon(getClass().getResource("rightData.png"));
		labeldetailR1 = new JLabel(detailR);
		labeldetailR1.setSize(250, 80);
		labeldetailR1.setLocation(725,55);
		labeldetailR2 = new JLabel(detailR);
		labeldetailR2.setSize(250, 80);
		labeldetailR2.setLocation(725,510);
		/********************************************************************/
		JLabel showCha = new JLabel(Character[indexCha]);
		showCha.setSize(200, 200);
		showCha.setLocation(1060,0);
		/********************************************************************/
		JLabel showName = new JLabel("Name : " + namePlayer);
		showName.setForeground(Color.BLACK);
		showName.setFont(Tahoma20);
		showName.setSize(250, 30);
		showName.setLocation(1030,43);
		/********************************************************************/
		JLabel letChat = new JLabel("LET'S CHAT");
		letChat.setForeground(Color.BLACK);
		letChat.setFont(Tahoma28);
		letChat.setSize(200, 30);
		letChat.setLocation(1055,100);
		/********************************************************************/
		/*JLabel showNumPlayer = new JLabel("Player : 1");
		showNumPlayer.setForeground(Color.BLACK);
		showNumPlayer.setFont(Tahoma16);
		showNumPlayer.setSize(200, 30);
		showNumPlayer.setLocation(1040,65);*/
		/****************************butSent************************/
		butSend.setBorder(new LineBorder(Color.BLACK, 3));
		butSend.setFont(Tahoma16);
		butSend.setForeground(Color.BLACK);
		butSend.setLocation(1200, 550);
		butSend.setSize(60,40);
		butSend.setBackground(new Color(0, 115, 153));
		butSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket(ClientFindServer.ipServ,50111);
                    PrintStream dataOut = new PrintStream(socket.getOutputStream());
                    String str = sendMessage.getText();
                    sendMessage.setText("");
                    dataOut.print("chat"+"-"+ip+"-"+FrameGame.textName.getText()+"-"+str);
                    dataOut.close();
                } catch (Exception e1) {
                    System.out.println(">>>>>> "+e1);
                }
            }
        });
		/********************************************************************/
		butExit.setBorder(new LineBorder(Color.BLACK, 3));
		butExit.setFont(Tahoma16);
		butExit.setForeground(Color.BLACK);
		butExit.setLocation(1010, 595);
		butExit.setSize(250,40);
		butExit.setBackground(new Color(0, 115, 153));
		butExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/********************************************************************/
		butDraw.setBorder(new LineBorder(Color.BLACK, 3));
		butDraw.setFont(Tahoma16);
		butDraw.setForeground(Color.black);
		butDraw.setLocation(380, 570);
		butDraw.setSize(120,40);
		butDraw.setBackground(Color.yellow);
		butDraw.setVisible(false);
		butDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Socket sockDraw = new Socket(ClientFindServer.ipServ,50111);
					PrintStream datatodraw = new PrintStream(sockDraw.getOutputStream());		
					datatodraw.print("Draw"+"-"+ip+"-"+position);
					datatodraw.close();
					butPass.setEnabled(false);
					butDraw.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		/********************************************************************/
		butPass.setBorder(new LineBorder(Color.BLACK, 3));
		butPass.setFont(Tahoma16);
		butPass.setForeground(Color.black);
		butPass.setLocation(510, 570);
		butPass.setSize(120,40);
		butPass.setBackground(Color.gray);
		butPass.setVisible(false);
		butPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Socket sockDraw = new Socket(ClientFindServer.ipServ,50111);
					PrintStream datatodraw = new PrintStream(sockDraw.getOutputStream());		
					datatodraw.print("Pass"+"-"+ip+"-"+position);
					datatodraw.close();
					butDraw.setEnabled(false);
					butPass.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		/********************************************************************/
		truePNG = new ImageIcon(getClass().getResource("true.png"));
		labeltruePNG = new JLabel(truePNG );
		labeltruePNG.setIcon(null);
		labeltruePNG.setSize(60, 60);
		labeltruePNG.setLocation(570, 30);
		
		butReady.setBorder(new LineBorder(Color.BLACK, 3));
		butReady.setFont(Tahoma16);
		butReady.setForeground(Color.black);
		butReady.setLocation(440, 40);
		butReady.setSize(120,40);
		butReady.setBackground(Color.gray);
		butReady.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(checknumReady);
				if(checknumReady==0) {
					labeltruePNG.setIcon(truePNG );
					butReady.setBackground(Color.green);
					checknumReady=1;
					
					try {
		                   Socket sockReady = new Socket(ClientFindServer.ipServ,50111);
		                   PrintStream dataOut = new PrintStream(sockReady.getOutputStream());
		                   dataOut.print("ReadyToPlay"+"-"+namePlayer);
		                   dataOut.close();
		                   butReady.setEnabled(false);
		             }
					catch (Exception e1) {}
				}
			}
		});
		/********************************************************************/
		
		sendMessage.setBorder(new LineBorder(Color.BLACK, 2));
		sendMessage.setFont(Tahoma16Plain);
		sendMessage.setSelectionColor (new Color(51, 133, 255));
		sendMessage.setSelectedTextColor (Color.WHITE);
		sendMessage.setDocument(new FixedSizeDocument(70));
		sendMessage.setSize(190, 40);
		sendMessage.setLocation(1010,550);
		sendMessage.setForeground(Color.BLACK);
		sendMessage.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {
	               try {
	                   Socket socket = new Socket(ClientFindServer.ipServ,50111);
	                   PrintStream dataOut = new PrintStream(socket.getOutputStream());
	                   String str = sendMessage.getText();
	                   sendMessage.setText("");
	                   dataOut.print("chat"+"-"+ip+"-"+FrameGame.textName.getText()+"-"+str);
	                   dataOut.close();
	               } catch (Exception e1) {
	                   System.out.println(">>>>>> "+e1);
	               }
				}
			}
		});
		/********************************************************************/
		chat.setForeground(Color.blue);
		chat.setFont(Tahoma12Plain);
		chat.setSize(250, 400);
		chat.setLocation(1010, 140);
		/********************************************************************/
		edgePlayer = new ImageIcon(getClass().getResource("account.png"));
		labeledPlayer = new JLabel(edgePlayer);
		labeledPlayer.setSize(260, 60);
		labeledPlayer.setLocation(1005,27);
		/********************************************************************/
		edgeLetChat = new ImageIcon(getClass().getResource("account.png"));
		labeledLetChat = new JLabel(edgeLetChat);
		labeledLetChat.setSize(260, 60);
		labeledLetChat.setLocation(1005,82);
		/********************************************************************/
		
		/********************************************************************/
		//panel.add(showCha);
		panel.add(labelNameWinner);
		panel.add(labelWinner);
		panel.add(sendMessage);
		panel.add(labeltruePNG);
		panel.add(butSend);
		panel.add(butExit);
		panel.add(butReady);
		panel.add(butDraw);
		panel.add(butPass);
		/**********************************/
		panel.add(showName);
		panel.add(letChat);
		panel.add(labelAllCard);
		/**********************************/
		panel.add(labelPlayerName[0]);
		panel.add(labelPlayerName[1]);
		panel.add(labelPlayerName[2]);
		/**********************************/
		panel.add(labelMoney[0]);
		panel.add(labelMoney[1]);
		panel.add(labelMoney[2]);
		//panel.add(labelMoney[3]);
		/**********************************/
		panel.add(labelBot[0]);
		panel.add(labelBot[1]);
		panel.add(labelBot[2]);
		/**********************************/
		panel.add(labelPlayer0[0]);
		panel.add(labelPlayer0[1]);
		panel.add(labelPlayer0[2]);
		/**********************************/
		panel.add(labelPlayer1[0]);
		panel.add(labelPlayer1[1]);
		panel.add(labelPlayer1[2]);
		/**********************************/
		panel.add(labelPlayer2[0]);
		panel.add(labelPlayer2[1]);
		panel.add(labelPlayer2[2]);
		/**********************************/
		panel.add(labeledPlayer);
		panel.add(labeledLetChat);
		panel.add(chat);
		panel.add(labelWait[0]);
		panel.add(labelWait[1]);
		panel.add(labelWait[2]);
		//panel.add(labelWait[3]);
		panel.add(labeldetailL1);
		panel.add(labeldetailR1);
		panel.add(labeldetailL2);
		//panel.add(labeldetailR2);
		panel.add(labelTable);
		panel.add(labelBG);
		add(panel);
		System.out.println(namePlayer);
	}
}
