package ServerStuff;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class SimpleServer {
	HttpServer server;
	
	//Simple Server Constructor
	public SimpleServer(String c) {
		try {
			setUpHttpServer(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void setUpHttpServer(String c)throws Exception{
    	 server = HttpServer.create(new InetSocketAddress(8000), 0);
         server.createContext("/info", new GetInformationHandler(c));
         server.setExecutor(null);
         server.start();
    }
}