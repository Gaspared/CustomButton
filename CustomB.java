package cb;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class CustomB extends JFrame{
	
	Container c;
	JButton e;
	JToggleButton tb;
	BackgroundPanel back;
	
	public CustomB() {
		c = getContentPane();
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		
		//panel
		back = new BackgroundPanel(new ImageIcon("sm.png"));
		back.setBackground(new Color(0,0,0,0));
		back.setLayout(new GridLayout(4,1));
		
		setSize(260, 260);
		setLocation(650, 350);
		
		//togglebutton
		tb = new JToggleButton(new ImageIcon("ts0.png"));
		tb.setContentAreaFilled(false);
		tb.setBorderPainted(false);
		tb.setFocusPainted(false);
		
		//exit button
		e = new JButton(new ImageIcon("e.png"));
		e.setContentAreaFilled(false);
		e.setBorderPainted(false);
		e.setFocusPainted(false);
		e.setVisible(false);
		
		//add listener
		tb.addItemListener(new TBListener());
		e.addActionListener(new BListener());
		
		//add
		back.add(e);
		back.add(tb);
		c.add(back);
		
	}
	
	class TBListener implements ItemListener{
		public void itemStateChanged(ItemEvent ev) {
			if (ev.getStateChange() == ItemEvent.SELECTED) {
				e.setVisible(true);
				tb.setIcon(new ImageIcon("ts1.png"));
				back.setIcon(new ImageIcon("sm-g.png"));
				back.repaint();		
			
			}else if (ev.getStateChange() == ItemEvent.DESELECTED) {
				e.setVisible(false);
				tb.setIcon(new ImageIcon("ts0.png"));
				back.setIcon(new ImageIcon("sm.png"));
				back.repaint();	
				
			}
		
		}
		
	}
	
	class BListener implements ActionListener{
		public void actionPerformed(ActionEvent ee) {
			System.exit(0);
		}
		
	}
	
	
	
	class BackgroundPanel extends JPanel{
		ImageIcon icon;
		
		public BackgroundPanel(ImageIcon icon) {
			this.icon = icon;
		}

		public void setIcon(ImageIcon icon) {
			this.icon = icon;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (this.icon != null) {
				g.drawImage(icon.getImage(),0,0,this);
			}
			
			
		}
		
		
	}
	
	

	
	
	public static void main(String[] args) {
		
		CustomB frame = new CustomB();
		frame.setVisible(true);
	}

}
