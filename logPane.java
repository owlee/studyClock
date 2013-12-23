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
	private ArrayList<logSession> list = loggerIO.session;
	
	
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
		updateList();
		g.drawString(list.get(0).getSubject() + "        " + list.get(0).getRuntime(), 4, 95);
	}
	
	public void actionPerformed(ActionEvent arg0){
		Object event = arg0.getSource();
		if(set == event){
			subject = enterSub.getText();
			counter.setSubject(subject);
			counter.repaint();
		} else if(log == event){
			logger.log(counter.getRuntime(), subject);
		}
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void updateList(){
		logger.reportLog();
	}
}
