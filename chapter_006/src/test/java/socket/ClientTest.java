package socket;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Class for testing the Client class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 01.07.2019
 */
public class ClientTest {

    private static final String LN = System.getProperty("line.separator");

    private void testClient(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenInputThenThisInputBack() throws IOException {
        this.testClient("Hello!", String.format("Hello!%s", LN));
    }
}