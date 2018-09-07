package me.rivermind.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author river
 * @date 2016/10/24
 */
public class MyNioHttpServer {

    public static void main(String[] args) throws IOException {

        // selector is open here
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 1111);

        // Binds the channel's socket to a local address and configures the socket to listen for connections
        serverSocketChannel.bind(socketAddress);

        // Adjusts this channel's blocking mode.
        serverSocketChannel.configureBlocking(false);

        int ops = serverSocketChannel.validOps();
        SelectionKey selectKy = serverSocketChannel.register(selector, ops, null);

        // Infinite loop..
        // Keep server running
        while (true) {

            selector.select();

            // token representing the registration of a SelectableChannel with a Selector
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();

                if (myKey.isAcceptable()) {
                    SocketChannel clientSocketChannel = serverSocketChannel.accept();

                    // Adjusts this channel's blocking mode to false
                    clientSocketChannel.configureBlocking(false);

                    // Operation-set bit for read operations
                    clientSocketChannel.register(selector, SelectionKey.OP_READ);

                } else if (myKey.isReadable()) {

                    SocketChannel clientSocketChannel = (SocketChannel)myKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                    String request = "";

                    while (clientSocketChannel.read(byteBuffer) > 0) {
                        request += new String(byteBuffer.array());
                        byteBuffer.clear();
                    }

                    String responseHeader = "HTTP/1.0 200 OK\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "Content-Length: " + request.getBytes().length + "\r\n" +
                        "\r\n";

                    clientSocketChannel.write(ByteBuffer.wrap((responseHeader + request).getBytes()));

                    clientSocketChannel.close();
                }
                iterator.remove();
            }
        }
    }
}
