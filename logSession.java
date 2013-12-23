package studyClock;

public class logSession {
	
	private int runtime;
	private String subject;
	
	public logSession(int run, String subj){
		runtime = run;
		subject = subj;
	}
	
	public int getRuntime(){	return runtime;	}
	
	public String getSubject(){	return subject;	}

}
