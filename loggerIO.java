package studyClock;

import java.io.*;
import java.util.*;

public class loggerIO {
	
	//public String getCurr = System.getProperty("user.dir");
	//public File fileName = new File(getCurr + "/log_session.txt");
	public File fileName = new File("log_Session.txt");
	private clockWriter writer = new clockWriter();
	private clockReader reader = new clockReader();
	
	public loggerIO() { }
	
	public void log(String subj, int time){
		try{
			writer.openFile(fileName);
			writer.add(subj, time);
			writer.close();
		} catch(Exception e) {
			System.out.println("Something happened during the log call in loggerIO");
			e.printStackTrace();
		}
	}
	
	public ArrayList<logSession> getLogSessions(){
		reader.openFile(fileName);
		reader.read();
		reader.close();
		return reader.getLogSession();
	}
}
