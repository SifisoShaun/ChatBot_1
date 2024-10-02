Chat Application

This is a simple chat application consisting of a server and multiple clients. The server can handle multiple client 
connections concurrently, and clients can send and receive messages to/from the server.

Server
The Server class is responsible for managing the server-side functionality of the chat application.

Features

    Accepts incoming client connections
    Creates a new ClientHandler for each client connection
    Starts a new thread for each client handler
    Allows shutting down the server based on a command

Usage

    Run the Server class to start the server.
    The server will listen for incoming client connections on ip address: 20.20.17.40 and port: 2222.
    The server can be shut down by returning the string "off" from the getCommand() method.

Client
The Client class represents a simple chat client that can send and receive messages over a network.

Features

    Connects to the server using a specified IP address and port
    Sends messages to the server
    Listens for incoming messages from the server in a separate thread
    Closes all I/O streams and the socket when necessary

Usage

    Run the Client class to start the client.
    The client will prompt for a username.
    After entering the username, the client will connect to the server at the specified IP address and port.
    The client can send messages to the server by typing in the console.
    The client will listen for incoming messages from the server and display them in the console.

ClientHandler
The ClientHandler class manages individual client connections in the chat room.

Features

    Handles receiving messages from a client
    Broadcasts messages to other clients
    Notifies when a client joins or leaves the chat room
    Uses a socket for network communication and buffered readers/writers for I/O operations
    Stores ClientHandler instances in a static list to facilitate message broadcasting

Usage

    A new ClientHandler is created for each client connection by the Server class.
    The ClientHandler manages the communication with the individual client, handling message reception, broadcasting, and client connection/disconnection events.

Prerequisites

    Java Development Kit (JDK) installed
    IDE or command-line interface for running Java applications

Running the Application

    Run the Server class to start the server.
    Run multiple instances of the Client class to start clients.
    Each client will prompt for a username and connect to the server.
    Clients can send messages to the server, and the messages will be broadcasted to all other connected clients.
    When a client disconnects, the server will notify all other clients.

Limitations

    The application does not have a graphical user interface (GUI).
    The server can only be shut down by modifying the getCommand() method.
    The application does not have advanced features like user authentication, message history, or private messaging.

Future Improvements

    Adding a GUI for a more user-friendly experience
    Implementing a command-line interface for controlling the server
    Adding user authentication and authorization features
    Storing message history and allowing clients to view past messages
    Implementing private messaging between clients

Contributing
Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please 
feel free to create a new issue or submit a pull request.
