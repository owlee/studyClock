package studyClock;

import java.io.*;

public class clockWriter {
	
	public clockWriter(){
		
	}

	public void write(String subj, int time ){
		try {
			//What ever the file path is.
			System.out.println("here0");
			FileOutputStream is = new FileOutputStream(loggerIO.fileName);
			System.out.println("here0.5");
			OutputStreamWriter osw = new OutputStreamWriter(is);    
			Writer w = new BufferedWriter(osw);
			System.out.println("here1");
			w.write("hello world");
			System.out.println("here2");
			//w.write(subj + "," + time);
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file" + loggerIO.fileName);
		}
	}
}
