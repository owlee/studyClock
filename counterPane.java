package studyClock;

import java.awt.*;
import javax.swing.*;

public class counterPane extends JPanel{
	
	//Constants
	private int count = 0, initTime = 0, currTime = 0, runtime = 0;
	private int num, hr, min, sec;
	private int winWidth, winHeight;
	private Color clockColor, bgColor;
	
	private String subject = "test";
	
	public counterPane(int w, int h, Color bgC, Color clockC){
		winWidth = w;
		winHeight = h;
		bgColor = bgC;
		clockColor = clockC;
		setPreferredSize(new Dimension(winWidth, winHeight));
		setBackground(bgColor);
		num = 0;
		setClock(num);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(clockColor);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.drawString(getTime(), 10, 50);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString(subject, 10, 90);
	}
	
	public void runCount(){
		if(sec > 0){ 
			sec--;
			runtime++;
		} else if(sec == 0){ 
			if((hr == 0) && (min == 0)){
				sec = 0;
			} else {
				sec = 59;
			}
			if(min > 0){
				min--;
			} else if(hr != 0){
				hr--;
				min=59;
			}
		}
	}

	public void setClock(int setVal){
		num = setVal;
		hr = setVal/3600;
		min = (setVal%3600)/60;
		sec = (setVal%3600)%60;
	}
	
	public String getTime(){
		String build = "";
		if(hr<10){
			build += "0" + hr + ":";
		} else {
			build += hr + ":";
		}
		if(min<10){
			build += "0" + min + ":";
		} else {
			build += min + ":";
		}
		if(sec<10){
			build += "0" + sec;
		} else {
			build += sec;
		}
		return build;
	}
	
	public void setSubject(String s){	subject = s;	}
	
	public int getInitTime(){	return initTime; }
	
	public int getCurrTime(){	return currTime; }
	
	public int getCount(){	return count; }
	
	public int getRuntime(){ return runtime; }

	public void stopClock() {
		
		
	}
	
}