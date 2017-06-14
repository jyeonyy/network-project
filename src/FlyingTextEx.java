import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
 	
public class FlyingTextEx extends JFrame {
    JPanel contentPane = new JPanel();
    JLabel la = new JLabel("", JLabel.CENTER);
    final int FLYING_UNIT = 10;
    JTextPane messageSpace = null;
    JButton sendButton = null;
    static String message ="";
 
    FlyingTextEx() {
        setTitle("chat program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.PINK);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.addKeyListener(new MyKeyListener());
        la.setLocation(50, 50);
        contentPane.setFocusable(true);
        String s = JOptionPane.showInputDialog(null, "�г��� �Է�.");
        if(s.length() > 5){
        	JOptionPane.showMessageDialog(null, "5�� �̳��� �Է��Ͻÿ�"); 
        	s = JOptionPane.showInputDialog(null, "�г��� �Է�.");
        }
        s.toUpperCase();
        la.setText(s);
        la.setSize(70, 20);
        BevelBorder border;
        border=new BevelBorder(BevelBorder.RAISED);//3�������� �׵θ� ȿ���� ���Ѱ��̰� �簢�� �ɼ��� �ش�.
        la.setBorder(border);//�󺧿� �����Ų��.
        
        contentPane.add(la);
        
        JTextPane chat = new JTextPane();
        chat.setText("ä�� â\n");
        chat.setBounds(350, 10, 220, 400);
        contentPane.add(chat);
        
        JLabel name = new JLabel();
        name.setText("�� �г���: "+s);
        
        name.setSize(100,20);
        name.setLocation(360,420);
        contentPane.add(name);
        
        JTextPane messageSpace = new JTextPane();
        messageSpace.setBounds(350, 450, 222, 71);
        contentPane.add(messageSpace);
        
        sendButton = new JButton("�޼��� ������");
        sendButton.setBounds(350, 531, 222, 20);
        
        
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message = messageSpace.getText();
                messageSpace.setText("");
            }
        });
        
        
        contentPane.add(sendButton);
        
        setSize(600, 600);
        setVisible(true);
        contentPane.requestFocus();
    }
 
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
            case KeyEvent.VK_UP:
            	if(la.getY() > 10)
            		la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
                break;
            case KeyEvent.VK_DOWN:
            	if(la.getY() <540)
            		la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
                break;
            case KeyEvent.VK_LEFT:
            	if(la.getX() > 10)
            		la.setLocation(la.getX() - FLYING_UNIT, la.getY());
                break;
            case KeyEvent.VK_RIGHT:
            	if(la.getX() < 270)
            		la.setLocation(la.getX() + FLYING_UNIT, la.getY());
                break;
            }
        }
    }
 
    public String getMessage(){
    	return this.message;
    }
    
//    
//    public static void main(String[] args) {
//    	EventQueue.invokeLater(new Runnable(){
//    		public void run(){
//    			try{
//    		        new FlyingTextEx();		
//    			}catch(Exception e){
//    				e.printStackTrace();
//    			}
//    		}
//    	});
//    }
}
