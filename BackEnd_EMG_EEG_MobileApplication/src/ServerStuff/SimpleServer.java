package ServerStuff;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class SimpleServer {
	HttpServer server;
	
	//Simple Server Constructor
	public SimpleServer() {
		try {
			setUpHttpServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void setUpHttpServer()throws Exception{
    	 server = HttpServer.create(new InetSocketAddress(8000), 0);
         server.createContext("/info", new GetInformationHandler());
         server.setExecutor(null);
         server.start();
    }
}