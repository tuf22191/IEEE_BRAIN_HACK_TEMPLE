package ServerStuff;

import java.io.IOException;

import org.omg.CORBA_2_3.portable.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author We did not do this, help taken from http://www.rgagnon.com/javadetails/java-have-a-simple-http-server.html
 *
 */
public class GetInformationHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange th) throws IOException {
		// TODO Auto-generated method stub
		String sendBack = "YOU Have reached the java application on this computer";
		th.sendResponseHeaders(200, sendBack.length());
		java.io.OutputStream outputStream = th.getResponseBody();
		outputStream.write(sendBack.getBytes());
		outputStream.close();
		System.out.println("we be having a response!");
	}
     
	
	
}
