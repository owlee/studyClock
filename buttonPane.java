package studyClock;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class buttonPane extends JPanel implements ActionListener{

	//TIMER
	counterPane counter;
	private Timer t = new Timer(1000, this);
	private int initTime = -1;

	//UI
	private int winWidth, winHeight;
	private Color stringColor, bgColor;
	private JButton start = new JButton("start");
	private JButton stop = new JButton("stop");
	private JButton set = new JButton("set");
	private JButton clear = new JButton("clear");
	private JButton log = new JButton("log");
	private JTextField timeField = new JTextField(8);
	
	//
	private String subject;
	
	public buttonPane(counterPane ct, int w, int h, Color bgC, Color stringC){
		counter = ct;
		
		//UI
		winWidth = w;
		winHeight = h;
		bgColor = bgC;
		stringColor = stringC;
		setPreferredSize(new Dimension(winWidth, winHeight));
		setBackground(bgColor);
		
		//Button Additions/listeners
		add(timeField); add(set); add(start); add(stop); add(clear); add(log);
		set.addActionListener(this);
		start.addActionListener(this);
		stop.addActionListener(this);
		clear.addActionListener(this);
		log.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		if(t == event){
				counter.runCount();
				counter.repaint();
		} 	else if(event == start){
				//if(initTime == -1)
				t.start();
		} 	else if(event == stop){
				t.stop();
				//repaint();
		}	else if(event == set){
				initTime = Integer.parseInt(timeField.getText());
				counter.setClock(initTime);
				counter.repaint();
		}	else if(event == log){
				t.stop();
				//adds to the log;
		}
	}

}
