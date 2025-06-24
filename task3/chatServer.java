package task3;
import java.io.*;
import java.net.*;
import java.util.*;

public class chatServer {
    private static final int PORT = 1234;
    private static Set<ClientHandler> clientHandlers = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Server is running on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected.");
                ClientHandler clientHandler = new ClientHandler(socket, clientHandlers);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private String userName;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clientHandlers;

    public ClientHandler(Socket socket, Set<ClientHandler> clientHandlers) {
        this.socket = socket;
        this.clientHandlers = clientHandlers;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            out.println("Enter your name:");
            userName = in.readLine();
            broadcast(userName + " has joined the chat.");

            String message;
            while ((message = in.readLine()) != null) {
                broadcast("[" + userName + "]: " + message);
            }
        } catch (IOException ex) {
            System.out.println(userName + " disconnected.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
            clientHandlers.remove(this);
            broadcast(userName + " has left the chat.");
        }
    }

    private void broadcast(String message) {
        synchronized (clientHandlers) {
            for (ClientHandler ch : clientHandlers) {
                ch.out.println(message);
            }
        }
    }
}
