package afafi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class DevMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DevMenu() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner goldSpinner = new JSpinner();
		goldSpinner.setBounds(10, 10, 120, 20);
		contentPane.add(goldSpinner);
		
		JButton addGoldButton = new JButton("Add gold");
		addGoldButton.setBounds(130, 10, 120, 20);
		contentPane.add(addGoldButton);
		
		JButton attackDecrementButton = new JButton("Attack -");
		attackDecrementButton.setBounds(10, 40, 120, 20);
		contentPane.add(attackDecrementButton);
		
		JButton attackIncrementButton = new JButton("Attack +");
		attackIncrementButton.setBounds(130, 40, 120, 20);
		contentPane.add(attackIncrementButton);
		
		JButton strengthDecrementButton = new JButton("Strength -");
		strengthDecrementButton.setBounds(10, 70, 120, 20);
		contentPane.add(strengthDecrementButton);
		
		JButton strengthIncrementButton = new JButton("Strength +");
		strengthIncrementButton.setBounds(130, 70, 120, 20);
		contentPane.add(strengthIncrementButton);
		
		JButton defenseDecrementButton = new JButton("Defense -");
		defenseDecrementButton.setBounds(10, 100, 120, 20);
		contentPane.add(defenseDecrementButton);
		
		JButton defenseIncrementButton = new JButton("Defense +");
		defenseIncrementButton.setBounds(130, 100, 120, 20);
		contentPane.add(defenseIncrementButton);
		
		JButton hitpointsDecrementButton = new JButton("Hitpoints -");
		hitpointsDecrementButton.setBounds(10, 130, 120, 20);
		contentPane.add(hitpointsDecrementButton);
		
		JButton hitpointsIncrementButton = new JButton("Hitpoints +");
		hitpointsIncrementButton.setBounds(130, 130, 120, 20);
		contentPane.add(hitpointsIncrementButton);
		
		JButton rangedDecrementButton = new JButton("Ranged -");
		rangedDecrementButton.setBounds(10, 160, 120, 20);
		contentPane.add(rangedDecrementButton);
		
		JButton rangedIncrementButton = new JButton("Ranged +");
		rangedIncrementButton.setBounds(130, 160, 120, 20);
		contentPane.add(rangedIncrementButton);
		
		JButton magicDecrementButton = new JButton("Magic -");
		magicDecrementButton.setBounds(10, 190, 120, 20);
		contentPane.add(magicDecrementButton);
		
		JButton magicIncrementButton = new JButton("Magic +");
		magicIncrementButton.setBounds(130, 190, 120, 20);
		contentPane.add(magicIncrementButton);
		
		JButton miningDecrementButton = new JButton("Mining -");
		miningDecrementButton.setBounds(240, 10, 120, 20);
		contentPane.add(miningDecrementButton);
		
		JButton miningIncrementButton = new JButton("Mining +");
		miningIncrementButton.setBounds(350, 10, 120, 20);
		contentPane.add(miningIncrementButton);
		
		JButton smithingDecrementButton = new JButton("Smithing -");
		smithingDecrementButton.setBounds(240, 40, 120, 20);
		contentPane.add(smithingDecrementButton);
		
		JButton smithingIncrementButton = new JButton("Smithing +");
		smithingIncrementButton.setBounds(350, 40, 120, 20);
		contentPane.add(smithingIncrementButton);
		
		JButton woodcuttingDecrementButton = new JButton("Woodcutting -");
		woodcuttingDecrementButton.setBounds(240, 70, 120, 20);
		contentPane.add(woodcuttingDecrementButton);
		
		JButton woodcuttingIncrementButton = new JButton("Woodcutting +");
		woodcuttingIncrementButton.setBounds(350, 70, 120, 20);
		contentPane.add(woodcuttingIncrementButton);
		
		JButton craftingDecrementButton = new JButton("Crafting -");
		craftingDecrementButton.setBounds(240, 100, 120, 20);
		contentPane.add(craftingDecrementButton);
		
		JButton craftingIncrementButton = new JButton("Crafting +");
		craftingIncrementButton.setBounds(350, 100, 120, 20);
		contentPane.add(craftingIncrementButton);
		
		JButton farmingDecrementButton = new JButton("Farming -");
		farmingDecrementButton.setBounds(240, 130, 120, 20);
		contentPane.add(farmingDecrementButton);
		
		JButton farrmingIncrementButton = new JButton("Farming +");
		farrmingIncrementButton.setBounds(350, 130, 120, 20);
		contentPane.add(farrmingIncrementButton);
		
		JButton fishingDecrementButton = new JButton("Fishing -");
		fishingDecrementButton.setBounds(240, 160, 120, 20);
		contentPane.add(fishingDecrementButton);
		
		JButton fishingIncrementButton = new JButton("Fishing +");
		fishingIncrementButton.setBounds(350, 160, 120, 20);
		contentPane.add(fishingIncrementButton);
		
		JButton cookingDecrementButton = new JButton("Cooking -");
		cookingDecrementButton.setBounds(240, 190, 120, 20);
		contentPane.add(cookingDecrementButton);
		
		JButton cookingIncrementButton = new JButton("Cooking +");
		cookingIncrementButton.setBounds(350, 190, 120, 20);
		contentPane.add(cookingIncrementButton);
	}
}
