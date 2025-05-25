import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started, waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            // Chat loop
            while (true) {
                // Read message from client
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

                // Read message from server console
                System.out.print("Server: ");
                serverMsg = console.readLine();
                out.write(serverMsg);
                out.newLine();
                out.flush();

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server exiting.");
                    break;
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

