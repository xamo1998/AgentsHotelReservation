package swing;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private Panel panel;
	public Frame() {
		setVisible(true);
		setResizable(false);
		setTitle("Hotel Reservation");
		setBounds(200,200,391,321);
		getContentPane().add(panel=new Panel());
	}
	
	public Panel getPanel() {
		return panel;
	}

}
