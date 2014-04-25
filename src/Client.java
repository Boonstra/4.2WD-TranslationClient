import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Erik on 4/21/14.
 */
public class Client {

    public Client() {
        String hostName = "127.0.0.1";
        int portNumber = 8008;

        Socket socket = null;
        try {
            socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);

                Scanner sc = new Scanner(System.in);
                String scLine = sc.nextLine();
                if (scLine.equals("bye")) {
                    socket.close();
                    System.out.println("Thank you for using translation service.");
                    break;
                } else {
                    out.println(scLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
