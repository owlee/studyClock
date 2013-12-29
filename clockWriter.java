package studyClock;

import java.io.*;
import java.util.*;

public class clockWriter {
	
	private Formatter f;
	
	public clockWriter(){}
	
	public void openFile(String name){
		try{
			f = new Formatter(name);
			System.out.println("File created");
		} catch(Exception e){
			System.out.println("unable to create file or find file.");
		}
	}
	
	public void add(String subj, int time){
		f.format("%s,%d", subj, time);
	}
	
	public void close(){
		f.close();
	}
}
