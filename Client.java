/**
 * @author wierschkec
 */
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**client for the date server.*/
public class Client
{
    Socket skt = null;
    
    public void run()
    {
        try
        {
            String serverAddress = "";
            int portNum = 7070;
        /** To Do Create a socket and connects it to the specified port number you created in the server side.
		*Hint: Use the constructor with host name and port as parameters*/
            skt = new Socket(InetAddress.getByName(serverAddress), portNum);
/* TO DO Here*/
            BufferedReader input = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            String serverTime = input.readLine();
            System.out.println(serverTime);
        /** To Do Write code to disconnect Here.*/
/* TO DO Here*/
            skt.close();
            skt = null;
            System.exit(0);
        }
        catch(Exception ex)
        {
            System.out.println("Client Error: " + ex);
        }
    }
    
    /**Runs the client application to read date and time from the server side.*/
    public static void main(String[] args) throws IOException
    {
        Client client = new Client();
        client.run();
    }
}
