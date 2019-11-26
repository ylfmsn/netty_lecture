package com.suntoon.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/11/25 0025下午 3:55
 */
public class TestServer {

    public static void main(String[] args) {

        // 不断的从客户端接收连接，但不对连接做任何处理，接收到连接后转给workGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 对连接进行处理，并做响应
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 用于启动服务端类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                childHandler(null);








    }


}