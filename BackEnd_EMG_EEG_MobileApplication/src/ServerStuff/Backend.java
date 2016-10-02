package ServerStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sendBack = "";
		String s = null;
        //String sendBack = "";
        try {
            
	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
        	Process p = Runtime.getRuntime().exec("C:\\Python27\\python.exe running.py");
            //Process p = Runtime.getRuntime().exec("C:\\Python27\\python.exe running.py");
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));
 
            int coun =  0;
            // read the output from the command
            //System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
               // System.out.println(s);
            	if(coun == 0){
            		 sendBack = s;
            		 coun++;
            	}
            }
            
            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
               // System.out.println(s);
            }
            
            //System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            //System.exit(-1);
        }
		
		
		
		SimpleServer server = new SimpleServer(sendBack);
		
		
		
		
	}

}
