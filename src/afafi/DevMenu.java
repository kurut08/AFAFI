package afafi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class DevMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DevMenu(Player player)
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
		try {
			goldSpinner.commitEdit();
		} catch ( java.text.ParseException e ) {
			throw new RuntimeException(e);
		}
		int value = (Integer) goldSpinner.getValue();

		JButton addGoldButton = new JButton("Add gold");
		addGoldButton.setBounds(130, 10, 120, 20);
		contentPane.add(addGoldButton);
		addGoldButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("money", player.getLEVEL("money")+ value);
			}
		});

		JButton attackDecrementButton = new JButton("Attack -");
		attackDecrementButton.setBounds(10, 40, 120, 20);
		contentPane.add(attackDecrementButton);
		attackDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("attack", player.getLEVEL("attack") -1);
			}
		});
		
		JButton attackIncrementButton = new JButton("Attack +");
		attackIncrementButton.setBounds(130, 40, 120, 20);
		contentPane.add(attackIncrementButton);
		attackIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("attack", player.getLEVEL("attack") +1);
			}
		});
		
		JButton strengthDecrementButton = new JButton("Strength -");
		strengthDecrementButton.setBounds(10, 70, 120, 20);
		contentPane.add(strengthDecrementButton);
		strengthDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("strength", player.getLEVEL("strength") -1);
			}
		});
		
		JButton strengthIncrementButton = new JButton("Strength +");
		strengthIncrementButton.setBounds(130, 70, 120, 20);
		contentPane.add(strengthIncrementButton);
		strengthIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("strength", player.getLEVEL("strength") +1);
			}
		});
		
		JButton defenseDecrementButton = new JButton("Defense -");
		defenseDecrementButton.setBounds(10, 100, 120, 20);
		contentPane.add(defenseDecrementButton);
		defenseDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("defense", player.getLEVEL("defense") -1);
			}
		});
		
		JButton defenseIncrementButton = new JButton("Defense +");
		defenseIncrementButton.setBounds(130, 100, 120, 20);
		contentPane.add(defenseIncrementButton);
		defenseIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("defense", player.getLEVEL("defense") +1);
			}
		});
		
		JButton hitpointsDecrementButton = new JButton("Hitpoints -");
		hitpointsDecrementButton.setBounds(10, 130, 120, 20);
		contentPane.add(hitpointsDecrementButton);
		hitpointsDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("hitpoints", player.getLEVEL("hitpoints") -1);
			}
		});
		
		JButton hitpointsIncrementButton = new JButton("Hitpoints +");
		hitpointsIncrementButton.setBounds(130, 130, 120, 20);
		contentPane.add(hitpointsIncrementButton);
		hitpointsIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("hitpoints", player.getLEVEL("hitpoints") +1);
			}
		});
		
		JButton rangedDecrementButton = new JButton("Ranged -");
		rangedDecrementButton.setBounds(10, 160, 120, 20);
		contentPane.add(rangedDecrementButton);
		rangedDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("ranged", player.getLEVEL("ranged") -1);
			}
		});
		
		JButton rangedIncrementButton = new JButton("Ranged +");
		rangedIncrementButton.setBounds(130, 160, 120, 20);
		contentPane.add(rangedIncrementButton);
		rangedIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("ranged", player.getLEVEL("ranged") +1);
			}
		});
		
		JButton magicDecrementButton = new JButton("Magic -");
		magicDecrementButton.setBounds(10, 190, 120, 20);
		contentPane.add(magicDecrementButton);
		magicDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("magic", player.getLEVEL("magic") -1);
			}
		});
		
		JButton magicIncrementButton = new JButton("Magic +");
		magicIncrementButton.setBounds(130, 190, 120, 20);
		contentPane.add(magicIncrementButton);
		magicIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("magic", player.getLEVEL("magic") +1);
			}
		});
		
		JButton miningDecrementButton = new JButton("Mining -");
		miningDecrementButton.setBounds(240, 10, 120, 20);
		contentPane.add(miningDecrementButton);
		miningDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("mining", player.getLEVEL("mining") -1);
			}
		});
		
		JButton miningIncrementButton = new JButton("Mining +");
		miningIncrementButton.setBounds(350, 10, 120, 20);
		contentPane.add(miningIncrementButton);
		miningIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("mining", player.getLEVEL("mining") +1);
			}
		});
		
		JButton smithingDecrementButton = new JButton("Smithing -");
		smithingDecrementButton.setBounds(240, 40, 120, 20);
		contentPane.add(smithingDecrementButton);
		smithingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("smithing", player.getLEVEL("smithing") -1);
			}
		});
		
		JButton smithingIncrementButton = new JButton("Smithing +");
		smithingIncrementButton.setBounds(350, 40, 120, 20);
		contentPane.add(smithingIncrementButton);
		smithingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("smithing", player.getLEVEL("smithing") +1);
			}
		});
		
		JButton woodcuttingDecrementButton = new JButton("Woodcutting -");
		woodcuttingDecrementButton.setBounds(240, 70, 120, 20);
		contentPane.add(woodcuttingDecrementButton);
		woodcuttingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("woodcutting", player.getLEVEL("woodcutting") -1);
			}
		});
		
		JButton woodcuttingIncrementButton = new JButton("Woodcutting +");
		woodcuttingIncrementButton.setBounds(350, 70, 120, 20);
		contentPane.add(woodcuttingIncrementButton);
		woodcuttingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("woodcutting", player.getLEVEL("woodcutting") +1);
			}
		});
		
		JButton craftingDecrementButton = new JButton("Crafting -");
		craftingDecrementButton.setBounds(240, 100, 120, 20);
		contentPane.add(craftingDecrementButton);
		craftingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("crafting", player.getLEVEL("crafting") -1);
			}
		});
		
		JButton craftingIncrementButton = new JButton("Crafting +");
		craftingIncrementButton.setBounds(350, 100, 120, 20);
		contentPane.add(craftingIncrementButton);
		craftingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("crafting", player.getLEVEL("crafting") +1);
			}
		});
		
		JButton farmingDecrementButton = new JButton("Farming -");
		farmingDecrementButton.setBounds(240, 130, 120, 20);
		contentPane.add(farmingDecrementButton);
		farmingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("farming", player.getLEVEL("farming") -1);
			}
		});
		
		JButton farrmingIncrementButton = new JButton("Farming +");
		farrmingIncrementButton.setBounds(350, 130, 120, 20);
		contentPane.add(farrmingIncrementButton);
		farrmingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("farming", player.getLEVEL("farming") +1);
			}
		});
		
		JButton fishingDecrementButton = new JButton("Fishing -");
		fishingDecrementButton.setBounds(240, 160, 120, 20);
		contentPane.add(fishingDecrementButton);
		fishingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("fishing", player.getLEVEL("fishing") -1);
			}
		});
		
		JButton fishingIncrementButton = new JButton("Fishing +");
		fishingIncrementButton.setBounds(350, 160, 120, 20);
		contentPane.add(fishingIncrementButton);
		fishingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("fishing", player.getLEVEL("fishing") +1);
			}
		});
		
		JButton cookingDecrementButton = new JButton("Cooking -");
		cookingDecrementButton.setBounds(240, 190, 120, 20);
		contentPane.add(cookingDecrementButton);
		cookingDecrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("cooking", player.getLEVEL("cooking") -1);
			}
		});
		
		JButton cookingIncrementButton = new JButton("Cooking +");
		cookingIncrementButton.setBounds(350, 190, 120, 20);
		contentPane.add(cookingIncrementButton);
		cookingIncrementButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				player.setLEVEL("cooking", player.getLEVEL("cooking") +1);
			}
		});
	}
}
