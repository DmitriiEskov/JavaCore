package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class represents a client, who might query anything from the server, represented by the "Server" class .
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.06.2019
 */
public class Client {

    /**
     * A client's socket.
     */
    private final Socket socket;

    /**
     * Initiates the input socket with this.socket.
     * @param socket - the input socket
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Runs a client.
     */
    public void start() {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String str = null;
            while (in.ready()) {
                str = in.readLine();
                out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}