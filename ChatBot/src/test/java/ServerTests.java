import org.junit.Test;
import java.net.Socket;
import org.junit.Before;
import java.io.IOException;
import java.net.ServerSocket;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServerTests {

    private ServerSocket serverSocketMock;
    private Socket socketMock;
//    private Server server;

    @Before
    public void setUp() throws IOException {
        serverSocketMock = mock(ServerSocket.class);
        socketMock = mock(Socket.class);
//        server = new Server(serverSocketMock);
    }

    @Test
    public void testServerConstructor() {
        assertNotNull("ServerSocket should not be null", serverSocketMock);
//        assertNotNull("Server should be initialized", server);
    }


    @Test
    public void testCloseServerSocket() throws IOException {
//        server.closeServerSocket();
        verify(serverSocketMock, times(1)).close();
    }

    @Test
    public void testPrintClientDisconnect() {
        String username = "testUser";
//        server.printClientDisconnect(username);
    }


//    @Test
//    public void testGetCommand() {
//        assertTrue(Server.getCommand() instanceof Boolean);
//    }
}
