package networkSimulation;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Displaycontent extends JPanel implements ActionListener{
	
	Animation animation = new  Animation();
	JLabel microSecond;
	JLabel packetData;
	
	boolean start_flg = false;
	int timerBig = 0;
	
	
	JComboBox genCombo,transCombo;
	
	JButton startButton;
	JButton stopButton;
	
	Timer timer = new Timer(10,this);
	Timer eTimer = new Timer(10,this);
	Timer tTimer = new Timer(10,this);
	
	public Displaycontent() {
		animation.createDefaultBuffer();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		// Paint all components
		animation.drawChannel(g);
		animation.drawPackets(g);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == timer) {
			microSecond.setText(timerBig/1000.0+" msec");
			packetData.setText(animation.droppedPkt+" packets dropped out of "+animation.totalPkt);
			
			animation.animateIn();
			animation.animateChannel();
			timerBig +=10;
		}
		if(e.getSource() == eTimer) {
			
			animation.generateNewPacket();
			
		}
		if(e.getSource() == tTimer) {
			animation.emitPackets();
		}
		
		if(e.getSource() == startButton ) {
			timer.start();
			int i = genCombo.getSelectedIndex();
			int j = transCombo.getSelectedIndex();
			eTimer.setDelay(i==0?3333:2000);
			tTimer.setDelay(j==0?3333:j==1?2000:1250);
			eTimer.start();
			tTimer.start();
			start_flg = true;
		}
		if(e.getSource() == stopButton) {
			timer.stop();
			tTimer.stop();
			eTimer.stop();
			animation.resetData();
			start_flg = false;
		}
		repaint();
		
	}

}
