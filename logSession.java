package studyClock;

public class logSession {
	
	private int runtime;
	private String subject;
	
	public logSession(String subj, int run){
		subject = subj;
		runtime = run;
	}
	
	public int getRuntime(){	return runtime;	}
	
	public String getSubject(){	return subject;	}

}
