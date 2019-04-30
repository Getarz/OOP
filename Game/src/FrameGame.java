import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.InetAddress;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class FrameGame extends JFrame{
	public String name = "";
	public ImageIcon bg;
	public ImageIcon icon;
	public ImageIcon card;
	public ImageIcon edge;
	public ImageIcon Character[] = new ImageIcon[5];
	public ImageIcon arrowLeft;
	public ImageIcon arrowRight;
	public ImageIcon snoopDog;
	public ImageIcon Casino;
	public JLabel labelBG;
	public JLabel labelCard;
	public JLabel labelCard2;
	public JLabel labelEdge;
	public JLabel labelCha[] = new JLabel[5];
	public JLabel labelArrowLeft;
	public JLabel labelArrowRight;
	public JLabel showCha;
	public JLabel labelSnoopDog2;
	public JLabel labelCasino;
	int indexCha = 0;
	static JTextField textName = new JTextField();
	static public String IP="";	
	public FrameGame(){
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			IP = inetAddress.getHostAddress();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		JPanel panel = new JPanel(null);
		Font Tahoma12  = new Font("Tahoma", Font.BOLD, 12);
		Font Tahoma16  = new Font("Tahoma", Font.BOLD, 16);
		Font Tahoma24  = new Font("Tahoma", Font.BOLD, 24);
		Font BMTC36  = new Font("Bernard MT", Font.BOLD, 36);
		AudioTSover playTS = new AudioTSover();
		/******************************************************/
		setTitle("POK POK v1.0");
		setSize(1080, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		icon = new ImageIcon(getClass().getResource("casino2.png"));
		setIconImage(icon.getImage());
		/******************************************************/
		JLabel incorrect = new JLabel();
		incorrect.setFont(Tahoma16);
		incorrect.setLocation(410 , 460);
		incorrect.setSize(260,50);
		incorrect.setForeground(Color.red);
		Character[0] = new ImageIcon(getClass().getResource("tu.png"));
		Character[1] = new ImageIcon(getClass().getResource("taksin.png"));
		Character[2] = new ImageIcon(getClass().getResource("tanaton.png"));
		Character[3] = new ImageIcon(getClass().getResource("pom.png"));
		Character[4] = new ImageIcon(getClass().getResource("sudarad.png"));
		labelCha[0] = new JLabel();
		for (int i = 0; i < labelCha.length; i++) {
			labelCha[i] = new JLabel(Character[i]);
			labelCha[i].setSize(200, 200);
		}
		/******************************************************/
		Casino = new ImageIcon(getClass().getResource("casino2.png"));
		labelCasino = new JLabel(Casino);
		labelCasino.setSize(303, 223);
		labelCasino.setLocation(0, 20);
		
		arrowLeft = new ImageIcon(getClass().getResource("left.png"));
		labelArrowLeft = new JLabel(arrowLeft);
		labelArrowLeft.setSize(60, 60);
		labelArrowLeft.setLocation(340, 100);
		labelArrowLeft.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				indexCha = indexCha - 1;
				if (indexCha < 0) {
					indexCha = 0;
				}
				showCha.setIcon(Character[indexCha]);
				System.out.println(indexCha);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		showCha = new JLabel(Character[0]);
		showCha.setSize(200, 200);
		showCha.setLocation(440,30);
		
		arrowRight = new ImageIcon(getClass().getResource("right.png"));
		labelArrowRight = new JLabel(arrowRight);
		labelArrowRight.setSize(60, 60);
		labelArrowRight.setLocation(680, 100);
		labelArrowRight.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				indexCha = indexCha + 1;
				if (indexCha > 4) {
					indexCha = 4;
				}
				showCha.setIcon(Character[indexCha]);
				System.out.println(indexCha);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		/******************************************************/
		textName.setBorder(new LineBorder(new Color(102, 102, 102), 2));
		textName.setFont(Tahoma16);
		textName.setSelectionColor (new Color(51, 133, 255));
		textName.setSelectedTextColor (Color.WHITE);
		textName.setDocument(new FixedSizeDocument(12));
		textName.setSize(200, 40);
		textName.setLocation(440, 325);
		textName.setForeground(Color.BLACK);
		textName.addKeyListener(new KeyListener() {
			
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
					if(textName.getText().length()==0) {
						incorrect.setText("กรุณากรอกชื่ออย่างน้อย 1 ตัวอักษร");
					}
					else {
						playTS.clip.stop();
						ClientFindServer join = new ClientFindServer();
						IngameFrame startGame = new IngameFrame(indexCha,textName.getText());
						
						setVisible(false);
						startGame.setVisible(true);
					}
				}
			}
		});
		
		edge = new ImageIcon(getClass().getResource("Rectangle.png"));
		labelEdge = new JLabel(edge);
		labelEdge.setLocation(340 , 250);
		labelEdge.setSize(400, 150);
		
		card = new ImageIcon(getClass().getResource("1-1re.png"));
		labelCard = new JLabel(card);
		labelCard.setLocation(350 , 315);
		labelCard.setSize(80, 50);
		labelCard2 = new JLabel(card);
		labelCard2.setLocation(650 , 315);
		labelCard2.setSize(80, 50);
		/******************************************************/
		JButton butStart = new JButton("Play Game");
		butStart.setBorder(new LineBorder(Color.BLACK, 3));
		butStart.setFont(Tahoma24);
		butStart.setForeground(Color.BLACK);
		butStart.setLocation(440, 410);
		butStart.setSize(200,60);
		butStart.setBackground(new Color(179, 179, 179));
		butStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().length()==0) {
					incorrect.setText("กรุณากรอกชื่ออย่างน้อย 1 ตัวอักษร");
				
				}
				else {
					playTS.clip.stop();
					ClientFindServer join = new ClientFindServer();
					IngameFrame startGame = new IngameFrame(indexCha,textName.getText());
					ServClientData serCliData = new ServClientData();
					serCliData.start();
					setVisible(false);
					startGame.setVisible(true);
				}
			}
		});
		/******************************************************/
		JLabel enterName = new JLabel("ENTER CHARACTER NAME");
		enterName.setFont(BMTC36);
		enterName.setForeground(new Color(218,165,32));
		enterName.setSize(420,40);
		enterName.setLocation(356 , 270);
		JLabel conditionName = new JLabel("(*ใส่ตัวอักษรหรือตัวเลขรวมกันไม่เกิน 12 ตัว)");
		conditionName.setFont(Tahoma12);
		conditionName.setForeground(Color.red);
		conditionName.setSize(250,40);
		conditionName.setLocation(480, 360);
		/******************************************************/
		
		/******************************************************/
		snoopDog = new ImageIcon(getClass().getResource("giphy.gif"));
		labelSnoopDog2 = new JLabel(snoopDog);
		labelSnoopDog2.setLocation(806, 220);
		labelSnoopDog2.setSize(234, 480);
		/******************************************************/
		bg = new ImageIcon(getClass().getResource("casino-show2.jpg"));
		labelBG = new JLabel(bg);
		labelBG.setLocation(0, 0);
		labelBG.setSize(1080, 720);
		/******************************************************/
		panel.add(textName);
		panel.add(butStart);
		panel.add(enterName);
		panel.add(incorrect);
		panel.add(conditionName);
		panel.add(showCha);
		panel.add(labelCasino);
		panel.add(labelSnoopDog2);
		panel.add(labelArrowLeft);
		panel.add(labelArrowRight);
		panel.add(labelCard);
		panel.add(labelCard2);
		panel.add(labelEdge);
		panel.add(labelBG);
		add(panel);
	}
}

