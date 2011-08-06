import java.io.*;
import java.net.*;
public class ChatServer {
  public static void main(String[] args) throws Exception{
    ChatServer myServ = new ChatServer();
    myServ.run();
  }
  public void run() throws Exception{
    ServerSocket mySS = new ServerSocket(6969);
    while (true){
      Socket SS_accept = mySS.accept();
      BufferedReader SS_BF = new BufferedReader(new InputStreamReader(SS_accept.getInputStream()));
      String temp = SS_BF.readLine();
      System.out.println(temp);
      if (temp!=null){
        PrintStream SSPS = new PrintStream(SS_accept.getOutputStream());
        SSPS.println("Got something!");
      }
    }
  }
}