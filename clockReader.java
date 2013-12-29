package studyClock;

import java.io.*;
import java.util.*;

public class clockReader {
	//builds a logSession arrayList
	private Scanner sc;
	private static ArrayList<logSession> session = new ArrayList<logSession>();
	
	public clockReader(){ }

	public void openFile(String path){
		//opens the file and uses commas as a delimiter
		try{
			sc = new Scanner(path);
			sc.useDelimiter(",");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void read(){
		//reads file and adds to the arrayList of sessions;
		while(sc.hasNext()){
			String s = sc.next();
			int n = sc.nextInt();
			session.add(new logSession(s,n));
		}
	}
	
	public void close(){
		sc.close();
	}

	public ArrayList<logSession> getLogSession(){
		return session;
	}
}
