package studyClock;

import java.io.*;
import java.util.*;

public class loggerIO {
	
	//public String getCurr = System.getProperty("user.dir");
	//public File fileName = new File(getCurr + "/log_session.txt");
	public String fileName = new String("log_Session.txt");
	private clockWriter writer;
	private clockReader reader;
	
	public loggerIO() { }
	
	public void log(String subj, int time){
		writer.openFile(fileName);
		writer.add(subj, time);
		writer.close();
	}
	
	public ArrayList<logSession> getLogSessions(){
		reader.openFile(fileName);
		reader.read();
		reader.close();
		return reader.getLogSession();
	}
}
