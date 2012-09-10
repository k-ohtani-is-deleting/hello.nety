package jp.adingo.hello.netty;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * サーバ側アプリケーションロジック
 */
public class EchoServerHandler extends SimpleChannelHandler {
	/**
	 * クライアントから電文を受信した際に呼び出されるメソッド
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent event) {
		String msg = (String) event.getMessage();
		ctx.getChannel().write(msg + " at " + today());
	}
	
	static String today() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
}