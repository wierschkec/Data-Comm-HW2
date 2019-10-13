/**
 * @author wierschkec
 */
import java.io.*;
import java.net.*;
import java.util.*;

/**A TCP server that runs on port 7070. When a client connects, 
 * it sends the client the current date and time, 
 * then closes the connection with that client.*/

public class Server
{
    private final int portNum = 7070;
    PrintWriter writeSkt;
    BufferedReader readSkt;
    
    /**Runs the server.*/
    public void run()
    {
        try
        {
            ServerSocket svrSkt = new ServerSocket(portNum);
            while(true)
            {
                Socket skt = svrSkt.accept();
                System.out.println("ServerSocket running on port 7070");
                System.out.println("Now listening on port 9090");
                PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
                out.println(new Date().toString());
                System.out.println("terminated running on port 9090");
                skt.close();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Server Error: " + ex);
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Server svr = new Server();
        svr.run();
    }
}
