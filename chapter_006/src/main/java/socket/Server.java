package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A server represents a chat bot, which can answer simple questions. A server stops a communication after
 * the "Exit" word was received.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.06.2019
 */
public class Server {

    /**
     * A server's socket.
     */
    private final Socket socket;

    /**
     * Initiates the input socket with this.socket.
     * @param socket - the input socket
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Runs a server.
     */
    public void start() {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask = null;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("Hello, Oracle!".equals(ask)) {
                    out.println("Hello, dear friend! I'm Oracle.");
                    out.println();
                } else if (!("Exit".equals(ask))) {
                    out.println("I don't understand.");
                    out.println();
                }
            } while (!"Exit".equals(ask));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}