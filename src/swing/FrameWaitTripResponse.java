package swing;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class FrameWaitTripResponse extends JFrame{
	private JProgressBar progressBar;
	public FrameWaitTripResponse() {
		getContentPane().setLayout(null);
		setVisible(true);
		setTitle("Loading");
		setResizable(false);
		setBounds(200,200,440,130);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 48, 374, 14);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		getContentPane().add(progressBar);
		
		JLabel lblSeEstanRealizando = new JLabel("Se estan realizando las operaciones, por favor espere un momento...");
		lblSeEstanRealizando.setBounds(10, 11, 473, 14);
		getContentPane().add(lblSeEstanRealizando);
	}
	
	public JProgressBar getProgressBar() {return progressBar;}
}
