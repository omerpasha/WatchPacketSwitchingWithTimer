import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;
/*
 *This project list your connection of ip with using traceroute comment.
 *
 *you can use timer class for spesific times.
 *
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
	public class TraceRoute {
		public static void  timer() {
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//traceRoute();
			addressOfRoute();
			}
			
		};
		long delay=60000L;
		
		timer.schedule(task,delay);
		
		
		}
		
		
		
		public static void writeFile(String line,String address) throws IOException {
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println(dtf.format(now));  
			
		      try {
		         
		         File file = new File("you can write any your path");
		         if(!file.exists()) {
		        	 file.createNewFile();
		         }
		    
		         
		         FileWriter fr = new FileWriter(file, true);
		         BufferedWriter br = new BufferedWriter(fr);
		        
		         
		         br.write(dtf.format(now));
		         br.write(address);
		         br.write("\n");
		         br.write(line);
		         br.write("\n");

		         br.close();
		         fr.close();
		         
		      
		         
		         //System.out.println("Done");
		      } catch(IOException e){
		         e.printStackTrace();
		      }
		}
		public static void addressOfRoute() {
			
			
			String line1="you can write some site";//you must use .com extension
			//String line2="";
			//String line3="";
			String line4="";//you must use .com extension
			ArrayList<String> address=new ArrayList<>();
			//address.add(line1);
			//address.add(line2);
			//address.add(line3);
			address.add(line4);
			address.add(line1);
			
			String gecici="";
			
			  for (int i =0; i < address.size(); i++) {
			
			
				String address_get=address.get(i);
				
				
			gecici="traceroute"+"\t"+address_get;
			
			traceRoute(address_get);
				  
			  }
			
		}
	
	public static void traceRoute(String address_get) {
		
	String gecici="traceroute \n"+address_get;
		
		
		
		try {
			Process process=Runtime.getRuntime().exec(gecici);
			StringBuilder output=new StringBuilder();
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line="";
			while((line=reader.readLine())!=null) {
				output.append(line+"\n");
				
				writeFile(line,address_get);
				
				System.out.println(address_get+"-----------aass---"+line);
			}
			int exitVal=process.waitFor();
			if(exitVal==0) {
				System.out.println("success");
				System.out.println(output);
				//System.exit(0);
			}
			else {
				System.out.println("something abnormal happened :(");
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
	timer();
	    
	    	 
	}

	   
		
		
	
	}



