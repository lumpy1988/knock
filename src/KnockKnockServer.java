import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer {
    
	public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = null;
	try {
	      serverSocket = new ServerSocket(4444);
	} catch (IOException e) {
	        System.err.println("Could not listen on port: 4444");
	        System.exit(1);
	}
	
	Socket mySocket = null;
	try {
	      mySocket = serverSocket.accept();
	} catch (IOException e) {
	        System.err.println("Accept failed");
	        System.exit(1);
	}

	PrintWriter out = new PrintWriter( mySocket.getOutputStream(), true);
	BufferedReader in = new BufferedReader( new InputStreamReader( mySocket.getInputStream()));
	String inputLine, outputLine;
	KnockKnockProtocol kkp = new KnockKnockProtocol();
	outputLine = kkp.processInput(null);
	out.println(outputLine);
	while(( inputLine = in.readLine()) != null ){
		outputLine = kkp.processInput(inputLine);
		out.println(outputLine);
		if( outputLine.equals("Bye."))
		    break;
	}
	out.close();
	in.close();
	mySocket.close();
	serverSocket.close();
        }
}
