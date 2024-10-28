import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class represents a simple chat server that listens for incoming client connections and manages them.
 *
 * The server accepts connections from clients, creates a new ClientHandler for each connection,
 * and starts a new thread for handling client messages. The server can be shut down based on a command.
 *
 * Methods:
 * - Server(ServerSocket serverSocket): Constructor that initializes the server with a ServerSocket.
 * - startServer(): Starts the server and listens for incoming client connections.
 * - getCommand(): Returns a command to control server behavior (currently a placeholder).
 * - closeServerSocket(): Closes the server socket.
 * - printClientDisconnect(String username): Prints a message when a client disconnects.
 * - main(String[] args): Main method to run the server.
 */
public class Server {
    private ServerSocket serverSocket;

    /**
     * Constructs a Server object with the specified ServerSocket.
     *
     * @param serverSocket the ServerSocket for accepting client connections
     */
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    /**
     * Starts the server and listens for incoming client connections.
     *
     * The method enters a loop, accepting client connections and creating a new ClientHandler for each client.
     * It starts a new thread for each client handler. The server can be shut down based on a command.
     */
    public void startServer(){
        try {
            System.out.println("Server is running. Listening to incoming client connections...");
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("A New Client Has Connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();

                if (Server.getCommand().equals("off")){
                    System.out.println("Shutting down the server....");
                    closeServerSocket();
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Placeholder method to return a command for controlling server behavior.
     *
     * @return an object representing the command (currently always returns true)
     */
    static Object getCommand() {
        return true;
    }

    /**
     * Closes the server socket.
     *
     * This method is called to shut down the server, closing the server socket to stop accepting new connections.
     */
    public void closeServerSocket(){
        try {
            if (serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Prints a message when a client disconnects.
     *
     * @param username the username of the client who disconnected
     */
    public void printClientDisconnect(String username) {
        System.out.println("Client " + username + " has disconnected.");
    }

    /**
     * Main method to run the server.
     *
     * @param args command-line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}