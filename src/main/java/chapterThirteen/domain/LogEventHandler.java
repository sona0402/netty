package chapterThirteen.domain;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 代码清单13-7
 *
 * @author renfakai
 */
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent msg) throws Exception {

        StringBuilder builder = new StringBuilder();
        builder.append(msg.getReceived());

        builder.append("[");

        builder.append(msg.getSource().toString());

        builder.append("] [");

        builder.append(msg.getLogfile());

        builder.append("] :");

        builder.append(msg.getMsg());

        System.out.println(builder.toString());
    }
}
