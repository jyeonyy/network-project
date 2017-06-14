

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextPane;

 

public class GameLobby extends BaseFrame{
	
	private JPanel jPanel;   //��ü �г�	//ä���� �̷�� ���� ��
	private String message = "";
	public GameLobby() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 500);
		jPanel = new JPanel();
		jPanel.setBackground(SystemColor.info);
		jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanel);
		jPanel.setLayout(null);
		
		//�� ���� Game Lobby Label �κ�
		JLabel title = new JLabel("Game Lobby");
		title.setFont(new Font("Maiandra GD", Font.PLAIN, 25));
		title.setBounds(386, 10, 149, 45);
		jPanel.add(title);
		
		
		//���� �� �κ�
		JButton room_1 = new JButton("1\uBC88 \uBC29");
		room_1.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_1.setBounds(43, 127, 232, 82);
		room_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(1);
				setVisible(false);
			}
		});
		jPanel.add(room_1);
		
		
		JButton room_2 = new JButton("2\uBC88 \uBC29");
		room_2.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_2.setBounds(309, 127, 232, 82);
		room_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(2);
				setVisible(false);
			}
		});
		jPanel.add(room_2);
		
		JButton room_3 = new JButton("3\uBC88 \uBC29");
		room_3.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_3.setBounds(43, 219, 232, 82);
		room_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(3);
				setVisible(false);
			}
		});
		jPanel.add(room_3);
		
		JButton room_4 = new JButton("4\uBC88 \uBC29");
		room_4.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_4.setBounds(309, 219, 232, 82);
		room_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(4);
				setVisible(false);
			}
		});
		jPanel.add(room_4);
		
		JButton room_5 = new JButton("5\uBC88 \uBC29");
		room_5.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_5.setBounds(43, 311, 232, 82);
		room_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(5);
				setVisible(false);
			}
		});
		jPanel.add(room_5);
		
		JButton room_6 = new JButton("6\uBC88 \uBC29");
		room_6.setFont(new Font("���� ���", Font.PLAIN, 20));
		room_6.setBounds(309, 311, 232, 82);
		room_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s= new BaseFrame("gameRoom");
				BaseFrame.setSelectroom(6);
				setVisible(false);
			}
		});
		jPanel.add(room_6);

		if(getUsername().equals("")){
			setUsername(JOptionPane.showInputDialog(null, "�г��� �Է�."));
			if(getUsername().length() > 5){
				JOptionPane.showMessageDialog(null, "5�� �̳��� �Է��Ͻÿ�"); 
				setUsername(JOptionPane.showInputDialog(null, "�г��� �Է�."));
			}
		}
		
		
		//�г��� �����ִ� ��
		JLabel showname = new JLabel("\uB2C9\uB124\uC784: " + getUsername());
		showname.setFont(new Font("���ʷҹ���", Font.PLAIN, 15));
		showname.setBounds(43, 65, 362, 31);
		jPanel.add(showname);
		

		//��ȭ�� �̷�� ���� ��
		chatField = new JTextPane();
		chatField.setBounds(680, 70, 300, 280);
		chatField.setText("��ȭ ����!\n");
		jPanel.add(chatField);
		
		
		//��ȭ �� ��
		mychat = new JTextField();
		mychat.setBounds(680, 360, 300, 50);
		jPanel.add(mychat);
		mychat.setColumns(10);
		

		 Action action = new AbstractAction()
	      {
	          @Override
	          public void actionPerformed(ActionEvent e)
	          {
	        	  message = getMyChat();
	              mychat.setText("");
	              BaseFrame.setMessage(message);
//	            SimpleAttributeSet keyWord = new SimpleAttributeSet();
//	            try
//	            {
//	               StyledDocument doc = chatField.getStyledDocument();
//	                doc.insertString(doc.getLength(), getUsername()+": "+ message +"\n", keyWord );
//	                
//	                
//	            }
//	            catch(Exception e1) { System.out.println(e1); }
	          }
	      };
	      mychat.addActionListener( action );
		
		
		
		//�޼��� ������ ��ư
		JButton sendMessage = new JButton("\uBA54\uC138\uC9C0 \uBCF4\uB0B4\uAE30");
		sendMessage.setBounds(680, 420, 300, 30);
		sendMessage.addActionListener(new ActionListener() {
			@Override
	         public void actionPerformed(ActionEvent e) {  
	            message = getMyChat();
	            mychat.setText("");
	            BaseFrame.setMessage(message);
	           }
		});
		jPanel.add(sendMessage);
		
		//��ȭâ ���� �۾�
		JLabel label = new JLabel("\uB300\uD654\uCC3D");
		label.setFont(new Font("HY�ٴ�M", Font.PLAIN, 20));
		label.setBounds(681, 30, 94, 30);
		jPanel.add(label);
		
		
		setTitle("Game Lobby");
		setVisible(true);
		setResizable(true);
		
	}
	
}