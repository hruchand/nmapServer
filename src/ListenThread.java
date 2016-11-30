import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import iot.ManageDB;

public class ListenThread implements Runnable{
static	Boolean status =false;
public static String [] numbersArray;
	Thread thread = new Thread(this);
	static	String str = null;
	public ListenThread(){
		thread.start();
	}
	public void run(){
	
			
		try{
			BufferedReader in = null;
			String ack = "received";
			
			ServerSocket listener = new ServerSocket(6111);
			listener.setReuseAddress(true);
			while (true) {
		
				Socket socket = listener.accept();


in = new BufferedReader(
		new InputStreamReader(socket.getInputStream()));
str = in.readLine();
numbersArray = str.split(" ");
nmapClass.map.put(numbersArray[0], numbersArray[1]);
if(str.equalsIgnoreCase("null")){
	//	System.out.println("hello");
	}
	else{
	String ipaddress = str;
	System.out.println("received ip is:-"+ipaddress);
	status = true;
	socket.close();
	listener.close();
	break;
	
	}


				}
			System.out.println("role is"+nmapClass.map.get(numbersArray[0]));		
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	//	}
	}
}
