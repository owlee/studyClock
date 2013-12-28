package studyClock;

import java.io.*;
import java.util.*;

public class loggerIO {
	
	public static String getCurr = System.getProperty("user.dir");
	public static File fileName = new File(getCurr + "/log_session.txt");
	
	private clockWriter writer;
	private clockReader reader;
	
	public loggerIO() {
		//todo: add input to filename
	}
	
	public void log(String subj, int time){
		writer.write(subj, time);
	}
	
	public ArrayList<logSession> getLogSessions(){
		reader.reportLog();
		return reader.getLogSession();
	}
}
