package studyClock;

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class loggerIO {
	File file = new File(System.getProperty("./log_session.txt"));
	File fileName = request.getServletContext().getRealPath("/files/BB.key");
	//private File fileName = new File("user.dir/log_session.txt");
	
	private PrintWriter writer;
	private Scanner sc;
	public static ArrayList<logSession> session = new ArrayList<logSession>();
	int i = 0;
	
	public loggerIO() {
		//todo: add input to filename
	}
	
	public void log(int time, String subj){
		try {	
			writer = new PrintWriter(new FileWriter(fileName, true));
			writer.println(subj + " " + time);
			writer.close();
			System.out.println("done.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reportLog(){//gets the last 3 logs		
		try {
			sc = new Scanner(new FileReader(fileName));
			while(sc.hasNext()){
				processLine(sc.nextLine(), i);
				i++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void processLine(String str, int i){
		boolean integer = false;
		StringTokenizer st = new StringTokenizer(str);
		int runTime = 0;
		String subject = "";
		while(st.hasMoreElements()){
			if(integer){
				runTime = Integer.parseInt(st.nextToken());
				integer = false;
			} else {
				subject = st.nextToken();
				integer = true;
			}
		}
		session.add(new logSession(runTime, subject));
	}
	
	public ArrayList<logSession> getLogSessions(){
		return session;
	}
}
