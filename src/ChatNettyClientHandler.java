import java.util.ArrayList;

import org.json.*;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChatNettyClientHandler extends SimpleChannelInboundHandler<String> {
	
	private BaseFrame bf;
	ArrayList userinfo = new ArrayList<String>();
	int count = 1;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("welcome :" + bf.getName());
		for(int i=0;i<100;i++){
		userinfo.add("");
		}
	}
	public ChatNettyClientHandler() {
		// TODO Auto-generated constructor stub
	}
	public ChatNettyClientHandler(BaseFrame bf) {
		this.bf = bf;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		
		System.out.println(msg);


//		JSONObject json =  null;
//		System.out.println("dkssud"+msg);
//		json = new JSONObject(msg);
//		
//		int x = Integer.parseInt(json.getString("x"));
//		int y = Integer.parseInt(json.getString("y"));
//		String name = json.getString("nickName");
//		String message = json.getString("message");
//		
//		if(userinfo.size()==0)
//			userinfo.add(bf.getUsername());
//		
//		else{	
////			for(int i=1;i<userinfo.size()+1;i++){//���ο� user�� ������ �� userinfo�� ������ �ְ�
//				 if(!userinfo.contains(name)){
//					userinfo.add(name);			//���̰� ���ش�
//					int size = userinfo.size();
//					bf.CreateOtherUser(userinfo.size()-2, name);
//					bf.setUserVisible(userinfo.size() -2, true);
//				 }
////			}
//		}
//
//		if(bf.getUsername().equals(name)){	// ������ info�̸� �ڱⰡ ������
//			bf.setCharacterX(x);
//			bf.setCharacterY(y);
//		}
//		for(int i=1;i<userinfo.size();i++){		//�̹� �ִ� User�̸� ��ġ�� �ٲ��ش�.
//			if(userinfo.get(i).equals(name)){
//				bf.setUserVisible(i-1, true);
//				bf.CreateOtherUser(i-1, name);
//				bf.setUserLocation(i-1, x, y); 
//				break;
//			}
//		
//		}
//		System.out.println("userlist"+ userinfo.toString());
//		
//		if(!message.equals("")){
//			bf.sendMessage(name+ " : " + message+"\n");
//		}
		
		if(bf.getSumUser() >= 3){
			//����ó��
		}
		
		String temp[] = msg.split(":");
		String name = temp[1];
		System.out.println("userlist: "+userinfo.toString());
		System.out.println("bf's username" + bf.getUsername());
		
		if(temp[0].equals("GAMEIN")){
			int x = Integer.parseInt(temp[2]);
			int y = Integer.parseInt(temp[3]);
			
			if(temp[1].equals(bf.getUsername())){
				System.out.println("i'm wndls "+name);
//				if(!userinfo.get(1).equals("")){
//					for(int i=0;i<userinfo.size();i++){
//						String pretemp = (String) userinfo.get(i);
//		
				
//					}
//				}
				userinfo.set(0, name);
				bf.setCharacterX(50);
				bf.setCharacterY(50);
			}else{
				userinfo.add(count, name);
				bf.CreateOtherUser(count, name);
				bf.setUserLocation(count, x, y);
				bf.setUserVisible(count, true);	
				System.out.println("other client "+ userinfo.get(count));
				count++;
			
			
			}
			
//			if(!name.equals(bf.getUsername())){
//				bf.CreateOtherUser(count, name);
//				bf.setUserLocation(count, x, y);
//				bf.setUserVisible(count, true);	
//				
//			}
			int size = userinfo.size();
			
		}
		
		if(temp[0].equals("LOCATIONCHANGED")){
			int x = Integer.parseInt(temp[2]);
			int y = Integer.parseInt(temp[3]);

			if(bf.getUsername().equals(name)){	// ������ info�̸� �ڱⰡ ������
				bf.setCharacterX(x);
				bf.setCharacterY(y);
			}
			
			for(int i=1;i<userinfo.size();i++){		//�̹� �ִ� User�̸� ��ġ�� �ٲ��ش�.
				if(userinfo.get(i).equals(name)){
					System.out.println("in userinfo, name"+name+" i: "+ i);
					bf.CreateOtherUser(i, name);
					bf.setUserLocation(i, x, y); 
					bf.setUserVisible(i, true);
					break;
				}
			}
		}
		
		else if(temp[0].equals("MSG")){
			BaseFrame.sendMessage(name+ ": "+temp[2]);
		}
		
		else if(temp[0].equals("GAMEOUT")){
			if(!name.equals(bf.getUsername())){
				for(int i=1;i<userinfo.size();i++){
					if(userinfo.get(i).equals(name)){
						userinfo.set(i, "");
						bf.setUserLocation(i, 50, 50);
						bf.setUserVisible(i, false);
					}
				}
			}
			else if(name.equals(bf.getUsername())){
				userinfo.clear();
				for(int i=0;i<100;i++){
					userinfo.add("");
				}
			}
		}
		
		
		
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx){
		
	}
		
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
        System.out.println("exceptionCaught");
    }
}
