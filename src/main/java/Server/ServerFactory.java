package Server;

import java.net.Socket;

public abstract class ServerFactory {

    public abstract Server createServer(Socket socket);

}
