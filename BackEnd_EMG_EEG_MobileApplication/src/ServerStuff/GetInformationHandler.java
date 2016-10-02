package ServerStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA_2_3.portable.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author We did not do this, help taken from http://www.rgagnon.com/javadetails/java-have-a-simple-http-server.html
 *
 */
public class GetInformationHandler implements HttpHandler{
    String sendBack;
    int counter =0 ;
	
	public GetInformationHandler(String c){
		this.sendBack = c;
	}
	
	
	
	@Override
	public void handle(HttpExchange th) throws IOException {
		// TODO Auto-generated method stub
		
		if(counter ==1){
			this.sendBack = "Hey, Nikita";
		}else if(counter ==2){
			this.sendBack = "Hey, John";
		}
		counter++;
	    //"YOU Have reached the java application on this computer";
		System.out.println("Hola, "+ this.sendBack);
		th.sendResponseHeaders(200, sendBack.length());
		java.io.OutputStream outputStream = th.getResponseBody();
		outputStream.write(sendBack.getBytes());
		outputStream.close();
		System.out.println("we be having a response!");
	}
     
	
	
}
