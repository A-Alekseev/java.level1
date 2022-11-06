package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class TelnetServer {
    private ServerSocketChannel serverChannel;
    private Selector selector;
    private ByteBuffer byteBuffer;

    public TelnetServer(int port) throws IOException {
        byteBuffer = ByteBuffer.allocate(100);
        serverChannel = ServerSocketChannel.open();
        selector = Selector.open();
        serverChannel.bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (serverChannel.isOpen()) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            try {
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        handleAccept();
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                }
                iterator.remove();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void handleAccept() throws IOException {
        System.out.println("Client accepted");
        SocketChannel socketChannel = serverChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ, new TelnetChannelHandle());
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        StringBuilder message = new StringBuilder();
        while(true){
            int read = channel.read(byteBuffer);
            if (read == -1) {
                channel.close();
                return;
            }
            if (read == 0){
                break;
            }
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                message.append((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }

        System.out.println("Incoming message " + message);
        TelnetChannelHandle handle = (TelnetChannelHandle)key.attachment();
        String answer = handle.ProcessMessage(message.toString());
        channel.write(ByteBuffer.wrap(answer.getBytes(StandardCharsets.UTF_8)));
    }

    public static void main(String[] args) throws IOException {
        new TelnetServer(8989);
    }

}
