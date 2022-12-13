package networkSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main extends JFrame {

	private Displaycontent contents;

//	Launch app
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setTitle("Computer Networking Simulation");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//	create application window
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 300);
		contents = new Displaycontent();
		contents.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contents);
		contents.setLayout(null);
		
		JButton stopBtn = new JButton("Reset");
		stopBtn.setBounds(775, 11, 89, 23);
		contents.add(stopBtn);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(678, 11, 89, 23);
		contents.add(startButton);
		
		JLabel lblNewLabel = new JLabel("0.000 msec");
		lblNewLabel.setBounds(10, 204, 282, 14);
		contents.add(lblNewLabel);
		
		JLabel lblPacketsDropped = new JLabel("0 packets dropped out of 0");
		lblPacketsDropped.setBounds(10, 229, 282, 14);
		contents.add(lblPacketsDropped);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"300 packets/s", "500 packets/s"}));
		comboBox.setBounds(166, 11, 151, 22);
		contents.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"300 packets/s", "500 packets/s", "800 packets/s"}));
		comboBox_1.setBounds(517, 11, 151, 22);
		contents.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Emission Rate");
		lblNewLabel_1.setBounds(42, 15, 114, 14);
		contents.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Transmission Rate");
		lblNewLabel_1_1.setBounds(393, 15, 114, 14);
		contents.add(lblNewLabel_1_1);
		
		startButton.addActionListener(contents);
		stopBtn.addActionListener(contents);
		
		contents.startButton = startButton;
		contents.stopButton = stopBtn;
		contents.microSecond = lblNewLabel;
		contents.packetData = lblPacketsDropped;
		contents.genCombo = comboBox;
		contents.transCombo = comboBox_1;
		
	}

}
