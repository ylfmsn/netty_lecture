package com.suntoon.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description
 */
public class TestServer {

    public static void main(String[] args) throws InterruptedException {

        // 不断的从客户端接收连接，但不对连接做任何处理，接收到连接后转给workGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 对连接进行处理，并做响应
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 用于启动服务端类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
