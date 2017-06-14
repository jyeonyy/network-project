import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatNettyServer {

    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        final ChannelGroup[] channels = new ChannelGroup[7];
        
        for(int i=0; i<7; i++){
        	channels[i] = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        }
       
    	try {
            ServerBootstrap b = new ServerBootstrap()
            		.group(bossGroup, workerGroup)
            		.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
            		.childHandler(new ChatNettyServerInitializer(channels));

            ChannelFuture f = b.bind(8886).sync();
            f.channel().closeFuture().sync();
        }
        finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}