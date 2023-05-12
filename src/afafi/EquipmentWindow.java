package afafi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class EquipmentWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					EquipmentWindow frame = new EquipmentWindow();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EquipmentWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headLabel = new JLabel("head");
		headLabel.setBackground(new Color(255, 255, 255));
		headLabel.setOpaque(true);
		headLabel.setBounds(180, 10, 64, 64);
		contentPane.add(headLabel);
		
		JLabel chestLabel = new JLabel("chest");
		chestLabel.setBackground(new Color(255, 255, 255));
		chestLabel.setOpaque(true);
		chestLabel.setBounds(180, 80, 64, 64);
		contentPane.add(chestLabel);
		
		JLabel legsLabel = new JLabel("legs");
		legsLabel.setOpaque(true);
		legsLabel.setBackground(new Color(255, 255, 255));
		legsLabel.setBounds(180, 150, 64, 64);
		contentPane.add(legsLabel);
		
		JLabel feetLabel = new JLabel("feet");
		feetLabel.setOpaque(true);
		feetLabel.setBackground(new Color(255, 255, 255));
		feetLabel.setBounds(180, 220, 64, 64);
		contentPane.add(feetLabel);
		
		JLabel weaponLabel = new JLabel("weapon");
		weaponLabel.setBackground(new Color(255, 255, 255));
		weaponLabel.setOpaque(true);
		weaponLabel.setBounds(110, 80, 64, 64);
		contentPane.add(weaponLabel);
		
		JLabel shieldLabel = new JLabel("shield");
		shieldLabel.setOpaque(true);
		shieldLabel.setBackground(new Color(255, 255, 255));
		shieldLabel.setBounds(250, 80, 64, 64);
		contentPane.add(shieldLabel);
		
		JLabel amuletLabel = new JLabel("amulet");
		amuletLabel.setOpaque(true);
		amuletLabel.setBackground(new Color(255, 255, 255));
		amuletLabel.setBounds(110, 10, 64, 64);
		contentPane.add(amuletLabel);
		
		JLabel glovesLabel = new JLabel("gloves");
		glovesLabel.setOpaque(true);
		glovesLabel.setBackground(new Color(255, 255, 255));
		glovesLabel.setBounds(110, 150, 64, 64);
		contentPane.add(glovesLabel);
		
		JLabel ringLabel = new JLabel("ring");
		ringLabel.setBackground(new Color(255, 255, 255));
		ringLabel.setOpaque(true);
		ringLabel.setBounds(250, 150, 64, 64);
		contentPane.add(ringLabel);
	}
}
