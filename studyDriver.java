package studyClock;
import javax.swing.*;

public class studyDriver {
	
	public static void main(String[] args){
		DisplayWindow d = new DisplayWindow();
		clockTimer clock = new clockTimer();
		d.add(clock);
		d.showFrame();
		d.addPanel(clock);

	}

}
