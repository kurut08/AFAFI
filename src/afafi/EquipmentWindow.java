package afafi;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Image;

public class EquipmentWindow extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public EquipmentWindow() {
		setTitle("AFAFI - Equipment");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headLabel = new JLabel();
		headLabel.setBounds(180, 10, 64, 64);
		headLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/helmet_empty.png"))
                .getImage().getScaledInstance(headLabel.getWidth(), headLabel.getHeight(), Image.SCALE_SMOOTH), "Head"));
		contentPane.add(headLabel);
		
		JLabel chestLabel = new JLabel();
		chestLabel.setBounds(180, 80, 64, 64);
		chestLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/chestplate_empty.png"))
                .getImage().getScaledInstance(chestLabel.getWidth(), chestLabel.getHeight(), Image.SCALE_SMOOTH), "Chest"));
		contentPane.add(chestLabel);
		
		JLabel legsLabel = new JLabel("legs");
		legsLabel.setBounds(180, 150, 64, 64);
		legsLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/legs_empty.png"))
                .getImage().getScaledInstance(legsLabel.getWidth(), legsLabel.getHeight(), Image.SCALE_SMOOTH), "Legs"));
		contentPane.add(legsLabel);
		
		JLabel feetLabel = new JLabel("feet");
		feetLabel.setBounds(180, 220, 64, 64);
		feetLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/boots_empty.png"))
                .getImage().getScaledInstance(feetLabel.getWidth(), feetLabel.getHeight(), Image.SCALE_SMOOTH), "Boots"));
		contentPane.add(feetLabel);
		
		JLabel weaponLabel = new JLabel("weapon");
		weaponLabel.setBounds(110, 80, 64, 64);
		weaponLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/weapon_empty.png"))
                .getImage().getScaledInstance(weaponLabel.getWidth(), weaponLabel.getHeight(), Image.SCALE_SMOOTH), "Weapon"));
		contentPane.add(weaponLabel);
		
		JLabel shieldLabel = new JLabel("shield");
		shieldLabel.setBounds(250, 80, 64, 64);
		shieldLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/shield_empty.png"))
                .getImage().getScaledInstance(shieldLabel.getWidth(), shieldLabel.getHeight(), Image.SCALE_SMOOTH), "Shield"));
		contentPane.add(shieldLabel);
		
		JLabel amuletLabel = new JLabel("amulet");
		amuletLabel.setBounds(110, 10, 64, 64);
		amuletLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/amulet_empty.png"))
                .getImage().getScaledInstance(amuletLabel.getWidth(), amuletLabel.getHeight(), Image.SCALE_SMOOTH), "Amulet"));
		contentPane.add(amuletLabel);
		
		JLabel glovesLabel = new JLabel("gloves");
		glovesLabel.setBounds(110, 150, 64, 64);
		glovesLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/gauntlet_empty.png"))
                .getImage().getScaledInstance(glovesLabel.getWidth(), glovesLabel.getHeight(), Image.SCALE_SMOOTH), "Gauntlet"));
		contentPane.add(glovesLabel);
		
		JLabel ringLabel = new JLabel("ring");
		ringLabel.setBounds(250, 150, 64, 64);
		ringLabel.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/icons/Empty_EQ/ring_empty.png"))
                .getImage().getScaledInstance(ringLabel.getWidth(), ringLabel.getHeight(), Image.SCALE_SMOOTH), "Ring"));
		contentPane.add(ringLabel);
	}
}
