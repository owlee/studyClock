package studyClock;
import java.io.*;

public class clockWriterDriver {

	public static void main(String[] args){
		clockWriter cw = new clockWriter();
		File f = new File("test.txt");
		try{
			cw.openFile(f);
			cw.add("hello", 123);
			cw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
