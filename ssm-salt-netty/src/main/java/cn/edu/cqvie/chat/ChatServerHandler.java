package cn.edu.cqvie.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    // GlobalEventExecutor.INSTANCE 是一个全局的时间执行器是一个单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 表示 Channel 处于就绪状态，提示上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 将该客户加入聊天的信息推送给其它的在线客户端
        // 该方法将 channelGroup 中所有的 channel 遍历，并且发送消息
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 上线了 " + sdf.format(new Date()) + "\n");
        // 将当前 channel 加入到 channelGroup 中
        channelGroup.add(channel);
        System.out.println(channel.remoteAddress() + " 上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 将当前 channel 从 channelGroup 中移除
        channelGroup.remove(channel);
        // 将该客户离开聊天的信息推送给其它的在线客户端
        // 该方法将 channelGroup 中所有的 channel 遍历，并且发送消息
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 下线了 " + sdf.format(new Date()) + "\n");
        System.out.println(channel.remoteAddress() + " 下线了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (ch.id() != channel.id()) {
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + ": " + sdf.format(new Date()) + "\n" +
                        msg + "\n");
            } else {
                ch.writeAndFlush(" [自己]：" + msg + "\n");
            }
        });
    }

}