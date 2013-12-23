package studyClock;

import java.awt.*;
import javax.swing.*;

public class clockTimer extends JPanel{

	//Panels
	private counterPane counter;
	private buttonPane button;
	private logPane log;
	
	//UI
	private int windowWidth = 200;
	private int windowHeight = 200;
	private Color BACKGROUND = Color.black;
	private Color TEXTCOLOR = Color.white;
	//Buttons/Fields
	
	
	public clockTimer(){
		//DESCRIPTION (SIZE/COLOR)
		counter = new counterPane(windowWidth, 100, BACKGROUND, TEXTCOLOR);
		button = new buttonPane(counter, windowWidth, windowHeight/2, BACKGROUND, TEXTCOLOR);
		log = new logPane(counter, windowWidth, windowHeight/2, BACKGROUND, TEXTCOLOR);
		
		//LAYOUT (FORMATTING/ADDING BUTTONS)
		setLayout(new GridLayout(3,0));
		button.setLayout(new GridLayout(3,2));
		add(counter); add(button); add(log);
	}
}
