import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.IndexColorModel;
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
	
	public ImageIcon allCard;
	public JLabel labelAllCard;
	JPanel panel = new JPanel(null);
	/************CARD***************/
	public ImageIcon card[] = new ImageIcon[52];
	String clubs = "clubs_";
	String diamonds = "diamonds_";
	String hearts = "hearts_";
	String spades = "spades_";
	public JLabel labelCard[] = new JLabel[52];
	/************CARD***************/
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
		/********************************************************************/
		allCard = new ImageIcon(getClass().getResource("All_card.png"));
		labelAllCard = new JLabel(allCard);
		labelAllCard.setSize(100,100);
		labelAllCard.setLocation(300,270);
		/********************************************************************/
		int numcard = 0;
		for (int i = 0; i < card.length; i++) {
			if(i>=0&&i<=12) {
				card[i] = new ImageIcon(getClass().getResource(clubs+(numcard+1)+".png"));
			}
			else if(i>=13&&i<=25) {
				card[i] = new ImageIcon(getClass().getResource(spades+(numcard+1)+".png"));
			}
			else if(i>=26&&i<=38) {
				card[i] = new ImageIcon(getClass().getResource(hearts+(numcard+1)+".png"));
			}
			else if(i>=39&&i<=51) {
				card[i] = new ImageIcon(getClass().getResource(diamonds+(numcard+1)+".png"));
			}
			if(numcard==12)
				numcard=0;
			numcard++;
		}
		for (int i = 0; i < labelCard.length; i++) {
			labelCard[i] = new JLabel(card[i]);
			labelCard[i].setSize(60, 87);
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
		labelWait[3].setLocation(680,500);
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
		showName.setSize(200, 30);
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
		/******************************************************/
		
		butSend.setBorder(new LineBorder(Color.BLACK, 3));
		butSend.setFont(Tahoma16);
		butSend.setForeground(Color.BLACK);
		butSend.setLocation(1200, 550);
		butSend.setSize(60,40);
		butSend.setBackground(new Color(0, 115, 153));
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
		/****************************butSent************************/
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
		//panel.add(showCha);
		panel.add(sendMessage);
		panel.add(butSend);
		panel.add(butExit);
		/**********************************/
		panel.add(showName);
		panel.add(letChat);
		panel.add(labelAllCard);
		/**********************************/
		panel.add(labeledPlayer);
		panel.add(labeledLetChat);
		panel.add(chat);
		panel.add(labelWait[0]);
		panel.add(labelWait[1]);
		panel.add(labelWait[2]);
		panel.add(labelWait[3]);
		panel.add(labeldetailL1);
		panel.add(labeldetailR1);
		panel.add(labeldetailL2);
		panel.add(labeldetailR2);
		panel.add(labelTable);
		panel.add(labelBG);
		add(panel);
		System.out.println(namePlayer);
	}
}
