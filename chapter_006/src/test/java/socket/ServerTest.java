package socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Class for testing the "Client" and the "Server" classes.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 01.07.2019
 */
public class ServerTest {

    private static final String LN = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenSayExitThenProgrammeExits() throws IOException {
        this.testServer("Exit", "");
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "Hello, Oracle!",
                        "Exit"
                ),
                String.format("Hello, dear friend! I'm Oracle.%s%s", LN, LN)
        );
    }

    @Test
    public void whenAskUnsupportedThenDontUnderstand() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "UnsupportedCommand",
                        "Exit"
                ),
                String.format("I don't understand.%s%s", LN, LN)
        );
    }
}