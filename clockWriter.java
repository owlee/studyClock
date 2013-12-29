package studyClock;

import java.io.*;
import java.util.*;

public class clockWriter {
	
	private FileWriter fw;
	
	public clockWriter(){}
	
	public void openFile(File name) throws IOException{
		if(!name.exists()){
			name.createNewFile();
			System.out.println("Created a new file: " + name.getName());
		}
		
		try{
			fw = new FileWriter(name);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void add(String subj, int time){
		try{
			//the "," is used as a delimiter
			fw.write(subj + "," + time);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try{
			fw.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
