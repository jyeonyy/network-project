import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatNettyClientInitializer extends ChannelInitializer<SocketChannel> {

	private static final StringDecoder DECODER = new StringDecoder();
	private static final StringEncoder ENCODER = new StringEncoder();
	
	private static ChatNettyClientHandler CLIENT_HANDLER = new ChatNettyClientHandler();
	private static BaseFrame bf;
	
	public ChatNettyClientInitializer() {
	}

	public ChatNettyClientInitializer(BaseFrame bf) {
		// TODO Auto-generated constructor stub
		this.bf = bf;
	}
	
	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));	    
		pipeline.addLast(DECODER);	    
		pipeline.addLast(ENCODER);	   
		pipeline.addLast(new ChatNettyClientHandler(bf));
	   
	}
}