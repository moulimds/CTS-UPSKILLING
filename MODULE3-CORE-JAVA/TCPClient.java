import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String serverMsg, clientMsg;

            // Chat loop
            while (true) {
                // Read message from server
                serverMsg = in.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMsg);

                // Read message from client console
                System.out.print("Client: ");
                clientMsg = console.readLine();
                out.write(clientMsg);
                out.newLine();
                out.flush();

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client exiting.");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

