package studyClock;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class logPane extends JPanel implements ActionListener{
	
	//UI
	private int winWidth, winHeight;
	private Color stringColor, bgColor;
	private JTextField enterSub = new JTextField(7);
	private JButton set = new JButton("set");
	private JButton log = new JButton("log");
	
	//Constants
	private String subject = "null";
	private counterPane counter;
	private loggerIO logger;
	private ArrayList<logSession> session;
	
	
	public logPane(counterPane ct, int w, int h, Color bgC, Color stringC){
		//UI
		counter = ct;
		winWidth = w;
		winHeight = h;
		bgColor = bgC;
		stringColor = stringC;
		setPreferredSize(new Dimension(winWidth, winHeight));
		setBackground(bgColor);
		
		//Buttons/listeners
		log.setPreferredSize(new Dimension(52,25));
		add(enterSub); add(set); add(log);
		enterSub.addActionListener(this);
		set.addActionListener(this);
		log.addActionListener(this);
		
		//log controls
		logger = new loggerIO();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(stringColor);
		//g.drawString(subject, 0, 100);
		//drawLast(3, g);
	}
	
	public void drawLast(int num, Graphics g){
		updateList();
		int count = 1;
		int size = session.size();
		int x = 4, y = 95;
		String build = "";
		//checks for nullpoints
		if(size == 0){	//if there isn't values in the log, skip the drawing.
			count = num + 1;
		} else if(num > size) {	//if num is greater than the size, draw anything that is available.
			num = size;
		}
		//builds a session string/ resets build/ next value/ draws at lower location
		while(count <= num){
			build += session.get(size-count).getSubject() + "  " + session.get(size-count).getRuntime();
			g.drawString(build, x, y);
			build = "";
			count++;
			y-=12;
		}
	}
	
	public void updateList(){
		session = logger.getLogSessions();
	}
	
	public void actionPerformed(ActionEvent arg0){
		Object event = arg0.getSource();
		if(set == event){
			subject = enterSub.getText();
			counter.setSubject(subject);
			counter.repaint();
		} else if(log == event){
			logger.log(subject, counter.getRuntime());
		}
	}
	
	public String getSubject(){
		return subject;
	}
	
}
