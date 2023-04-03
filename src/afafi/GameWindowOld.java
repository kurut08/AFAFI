package afafi;

import javax.swing.*;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.*;

public class GameWindowOld implements ActionListener, MouseListener
{
	JFrame frame;
	
	JScrollPane combat;
	
	JLabel sidePanel[] = new JLabel[20];
	/* 0 - logo
	 * 1 - nickname
	 * 2 - combat activities
	 * 3 - non-combat activities
	 * 4 - attack
	 */
	
	ImageIcon gameIcon;
	
	Color sidePanelBackgroundColor = new Color(153,217,234);
	Color sidePanelForegroundColor = new Color(0,0,0); 
	Color borderColor = new Color(0,0,0); //black
	
	GameWindowOld()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		
		gameIcon = new ImageIcon("images/icon.png");
		frame = new JFrame("AFAFI");
		frame.setIconImage(gameIcon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight());
		frame.setLayout(null);
		
		
		gameIcon = new ImageIcon(gameIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		sidePanel[0] = new JLabel(gameIcon);
		sidePanel[0].setBounds(0,0,gameIcon.getIconWidth(),gameIcon.getIconHeight());
		sidePanel[0].setBorder(BorderFactory.createLineBorder(borderColor,4));
		frame.add(sidePanel[0]);
		
		sidePanel[1] = new JLabel("Kurut08"); //Replace with actual nickname from savefile
		sidePanel[2] = new JLabel("Combat activities");
		sidePanel[3] = new JLabel("Non-combat activities");
		sidePanel[4] = new JLabel("Attack");
		
		sidePanel[2].setLayout(new BoxLayout(sidePanel[2],BoxLayout.Y_AXIS));
		
		for(int i=1;i<5;i++)
		{
			setSidePanelProperties(sidePanel[i],i,50);
			frame.add(sidePanel[i]);
		}
		
		sidePanel[2].setBounds(0,250,200,380);
		sidePanel[2].setVerticalAlignment(SwingConstants.TOP);
		sidePanel[3].setBounds(0,630,200,380);
		sidePanel[3].setVerticalAlignment(SwingConstants.TOP);
		
		for(int i=4;i<5;i++)
		{
			sidePanel[2].add(sidePanel[i]);
		}
		
		frame.setVisible(true);
	}
	
	private void setSidePanelProperties(JLabel label,int i, int x)
	{
		if(i<4)
		{
			label.setBounds(0,(3+i)*x,200,50);			
		}
		else
		{
			label.setBounds(10,(3+i)*x,180,50);
		}
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		if(i<4)
		{
			label.setBorder(BorderFactory.createLineBorder(borderColor,4));			
		}
		
		label.setOpaque(true);
		label.setBackground(sidePanelBackgroundColor);
		label.setForeground(sidePanelForegroundColor);
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
}
