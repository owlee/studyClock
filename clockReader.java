package studyClock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class clockReader {
	//builds a logSession arrayList
	private Scanner sc;
	private static ArrayList<logSession> session = new ArrayList<logSession>();
	
	public clockReader(){
		
	}
	
	public void reportLog(){ //places logSessions in an ArrayList
		try {
			sc = new Scanner(new FileReader(loggerIO.fileName));
			while(sc.hasNext()){
				processLine(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void processLine(String str){
		boolean integer = false;
		StringTokenizer st = new StringTokenizer(str, ",", false);
		int runtime = 0;
		String subject = "";
		while(st.hasMoreElements()){
			if(integer){
				runtime = Integer.parseInt(st.nextToken());
				integer = false;
			} else {
				subject = st.nextToken();
				integer = true;
			}
		}
		session.add(new logSession(subject, runtime));
	}
	
	public ArrayList<logSession> getLogSession(){
		return session;
	}
}
