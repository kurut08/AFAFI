package afafi;


/*
 * TODO:
 * Resize logo when resizing window
 * Make all components scalable
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class GameWindow extends JFrame {

	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow("test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * Create the frame.
	 */
	
	private JPanel sidePanel, topPanel;
	private JPanel contentPanel;
	private JPanel logoPanel;
	
	public GameWindow(String characterName) 
	{
		setMaximumSize(new Dimension(1920, 1080));
		setMinimumSize(new Dimension(1280, 720));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Side Panel
		
		sidePanel = new JPanel();
		sidePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sidePanel.setBackground(Color.GREEN);
		sidePanel.setBounds(0, 0, this.getWidth()/6, this.getHeight());
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		//Logo Panel
		logoPanel = new JPanel();
		logoPanel.setBounds(0, 0, sidePanel.getWidth(), sidePanel.getHeight()/8);
		logoPanel.setBackground(sidePanel.getBackground());
		sidePanel.add(logoPanel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/logo.png")));
		logoLabel.setBounds(0, 0, logoPanel.getWidth(), logoPanel.getHeight());
		logoPanel.add(logoLabel);
		
		//Character Name Panel
		JPanel characterNamePanel = new JPanel();
		characterNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		characterNamePanel.setBounds(0, 135, sidePanel.getWidth(), 45);
		sidePanel.add(characterNamePanel);
		
		JLabel characterNameLabel = new JLabel("Nickname");
		characterNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		characterNamePanel.add(characterNameLabel);
		
		//Combat activities panels
		
		JPanel combatPanel = new JPanel();
		combatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		combatPanel.setBounds(0, 180, 320, 295);
		sidePanel.add(combatPanel);
		combatPanel.setLayout(null);
		
		JPanel combatTitlePanel = new JPanel();
		combatTitlePanel.setBounds(0, 0, combatPanel.getWidth() - 1, 45);
		combatPanel.add(combatTitlePanel);
		
		JLabel combatTitleLabel = new JLabel("Combat");
		combatTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		combatTitlePanel.add(combatTitleLabel);
		
		JPanel combatSelectionPanel = new JPanel();
		combatSelectionPanel.setBounds(0, 45, combatPanel.getWidth() - 1, 250);
		combatPanel.add(combatSelectionPanel);
		combatSelectionPanel.setLayout(null);
		
		//Combat Attack
		JPanel combatAttackPanel = new JPanel();
		combatAttackPanel.setBounds(0, 0, combatSelectionPanel.getWidth(), 32);
		combatAttackPanel.setLayout(null);
		combatAttackPanel.setBackground(new Color(255, 0, 0));
		combatAttackPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatAttackPanel);
		
		JLabel attackIconLabel = new JLabel("Icon");
		attackIconLabel.setBounds(0, 0, 32, 32);
		attackIconLabel.setBackground(new Color(255, 255, 255)); attackIconLabel.setOpaque(true); //TODO REMOVE
		attackIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatAttackPanel.add(attackIconLabel);
		
		JLabel attackNameLabel = new JLabel("Attack");
		attackNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attackNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatAttackPanel.getHeight()/4, 75, 16);
		combatAttackPanel.add(attackNameLabel);
		
		JProgressBar attackProgressBar = new JProgressBar();
		attackProgressBar.setBounds(attackNameLabel.getX() + attackNameLabel.getWidth(), combatAttackPanel.getHeight()/4
				, combatAttackPanel.getWidth() - attackNameLabel.getX() - attackNameLabel.getWidth() - 10, 16);
		combatAttackPanel.add(attackProgressBar);
		
		//Combat Strength
		JPanel combatStrengthPanel = new JPanel();
		combatStrengthPanel.setBounds(0, combatAttackPanel.getHeight(), combatSelectionPanel.getWidth(), 32);
		combatStrengthPanel.setLayout(null);
		combatStrengthPanel.setBackground(new Color(255, 0, 0));
		combatStrengthPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatStrengthPanel);

		JLabel strengthIconLabel = new JLabel("Icon");
		strengthIconLabel.setBounds(0, 0, 32, 32);
		strengthIconLabel.setBackground(new Color(255, 255, 255)); strengthIconLabel.setOpaque(true); //TODO REMOVE
		strengthIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatStrengthPanel.add(strengthIconLabel);

		JLabel strengthNameLabel = new JLabel("Strength");
		strengthNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strengthNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatStrengthPanel.getHeight()/4, 75, 16);
		combatStrengthPanel.add(strengthNameLabel);

		JProgressBar strengthProgressBar = new JProgressBar();
		strengthProgressBar.setBounds(strengthNameLabel.getX() + strengthNameLabel.getWidth(), combatStrengthPanel.getHeight()/4
				, combatStrengthPanel.getWidth() - strengthNameLabel.getX() - strengthNameLabel.getWidth() - 10, 16);
		combatStrengthPanel.add(strengthProgressBar);
		
		//Combat defence
		JPanel combatDefencePanel = new JPanel();
		combatDefencePanel.setBounds(0, combatStrengthPanel.getY() + combatStrengthPanel.getHeight(),
				combatSelectionPanel.getWidth(), 32);
		combatDefencePanel.setLayout(null);
		combatDefencePanel.setBackground(new Color(255, 0, 0));
		combatDefencePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatDefencePanel);

		JLabel defenceIconLabel = new JLabel("Icon");
		defenceIconLabel.setBounds(0, 0, 32, 32);
		defenceIconLabel.setBackground(new Color(255, 255, 255)); defenceIconLabel.setOpaque(true); //TODO REMOVE
		defenceIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatDefencePanel.add(defenceIconLabel);

		JLabel defenceNameLabel = new JLabel("Defense");
		defenceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defenceNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatDefencePanel.getHeight()/4, 75, 16);
		combatDefencePanel.add(defenceNameLabel);

		JProgressBar defenseProgressBar = new JProgressBar();
		defenseProgressBar.setBounds(defenceNameLabel.getX() + defenceNameLabel.getWidth(), combatDefencePanel.getHeight()/4
				, combatDefencePanel.getWidth() - defenceNameLabel.getX() - defenceNameLabel.getWidth() - 10, 16);
		combatDefencePanel.add(defenseProgressBar);
		
		//Combat Hitpoints
		JPanel combatHpPanel = new JPanel();
		combatHpPanel.setBounds(0, combatDefencePanel.getY() + combatDefencePanel.getHeight(),
				combatSelectionPanel.getWidth(), 32);
		combatHpPanel.setLayout(null);
		combatHpPanel.setBackground(new Color(255, 0, 0));
		combatHpPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatHpPanel);

		JLabel hpIconLabel = new JLabel("Icon");
		hpIconLabel.setBounds(0, 0, 32, 32);
		hpIconLabel.setBackground(new Color(255, 255, 255)); hpIconLabel.setOpaque(true); //TODO REMOVE
		hpIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatHpPanel.add(hpIconLabel);

		JLabel hpNameLabel = new JLabel("Hitpoints");
		hpNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hpNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatHpPanel.getHeight()/4, 75, 16);
		combatHpPanel.add(hpNameLabel);

		JProgressBar hpProgressBar = new JProgressBar();
		hpProgressBar.setBounds(hpNameLabel.getX() + hpNameLabel.getWidth(), combatHpPanel.getHeight()/4
				, combatHpPanel.getWidth() - hpNameLabel.getX() - hpNameLabel.getWidth() - 10, 16);
		combatHpPanel.add(hpProgressBar);
		
		//Combat Ranged
		JPanel combatRangedPanel = new JPanel();
		combatRangedPanel.setBounds(0, combatHpPanel.getY() + combatHpPanel.getHeight(),
				combatSelectionPanel.getWidth(), 32);
		combatRangedPanel.setLayout(null);
		combatRangedPanel.setBackground(new Color(255, 0, 0));
		combatRangedPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatRangedPanel);

		JLabel rangedIconLabel = new JLabel("Icon");
		rangedIconLabel.setBounds(0, 0, 32, 32);
		rangedIconLabel.setBackground(new Color(255, 255, 255)); rangedIconLabel.setOpaque(true); //TODO REMOVE
		rangedIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatRangedPanel.add(rangedIconLabel);

		JLabel rangedNameLabel = new JLabel("Ranged");
		rangedNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rangedNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatRangedPanel.getHeight()/4, 75, 16);
		combatRangedPanel.add(rangedNameLabel);

		JProgressBar rangedProgressBar = new JProgressBar();
		rangedProgressBar.setBounds(rangedNameLabel.getX() + rangedNameLabel.getWidth(), combatRangedPanel.getHeight()/4
				, combatRangedPanel.getWidth() - rangedNameLabel.getX() - rangedNameLabel.getWidth() - 10, 16);
		combatRangedPanel.add(rangedProgressBar);
		
		//Combat Magic
		JPanel combatMagicPanel = new JPanel();
		combatMagicPanel.setBounds(0, combatRangedPanel.getY() + combatRangedPanel.getHeight(),
				combatSelectionPanel.getWidth(), 32);
		combatMagicPanel.setLayout(null);
		combatMagicPanel.setBackground(new Color(255, 0, 0));
		combatMagicPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatSelectionPanel.add(combatMagicPanel);

		JLabel magicIconLabel = new JLabel("Icon");
		magicIconLabel.setBounds(0, 0, 32, 32);
		magicIconLabel.setBackground(new Color(255, 255, 255)); magicIconLabel.setOpaque(true); //TODO REMOVE
		magicIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		combatMagicPanel.add(magicIconLabel);

		JLabel magicNameLabel = new JLabel("Magic");
		magicNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		magicNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatMagicPanel.getHeight()/4, 75, 16);
		combatMagicPanel.add(magicNameLabel);

		JProgressBar magicProgressBar = new JProgressBar();
		magicProgressBar.setBounds(magicNameLabel.getX() + magicNameLabel.getWidth(), combatMagicPanel.getHeight()/4
				, combatMagicPanel.getWidth() - magicNameLabel.getX() - magicNameLabel.getWidth() - 10, 16);
		combatMagicPanel.add(magicProgressBar);
		
		//Noncombat activities panels
		
		JPanel nonCombatPanel = new JPanel();
		nonCombatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		nonCombatPanel.setBounds(0, 475, sidePanel.getWidth(), 295);
		sidePanel.add(nonCombatPanel);
		nonCombatPanel.setLayout(null);
		
		JPanel nonCombatTitlePanel = new JPanel();
		nonCombatTitlePanel.setBounds(0, 1, nonCombatPanel.getWidth() - 1, 45);
		nonCombatPanel.add(nonCombatTitlePanel);
		
		JLabel nonCombatTitleLabel = new JLabel("Non-Combat");
		nonCombatTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nonCombatTitlePanel.add(nonCombatTitleLabel);
		
		JPanel nonCombatSelectionPanel = new JPanel();
		nonCombatSelectionPanel.setBounds(0, 46, nonCombatPanel.getWidth() - 1, 250);
		nonCombatPanel.add(nonCombatSelectionPanel);
		nonCombatSelectionPanel.setLayout(null);
		
		//Noncombat mining
		JPanel miningPanel = new JPanel();
		miningPanel.setBackground(new Color(255, 0, 0));
		miningPanel.setBounds(0, 0, nonCombatSelectionPanel.getWidth(), 32);
		miningPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(miningPanel);
		miningPanel.setLayout(null);

		JLabel miningIconLabel = new JLabel("Icon");
		miningIconLabel.setBackground(new Color(255, 255, 255)); miningIconLabel.setOpaque(true); //TODO REMOVE
		miningIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		miningIconLabel.setBounds(0, 0, 32, 32);
		miningPanel.add(miningIconLabel);

		JLabel miningNameLabel = new JLabel("Mining");
		miningNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		miningNameLabel.setBounds(miningIconLabel.getWidth() + 10, miningPanel.getHeight()/4, 75, 16);
		miningPanel.add(miningNameLabel);

		JProgressBar miningProgressBar = new JProgressBar();
		miningProgressBar.setBounds(miningNameLabel.getX() + miningNameLabel.getWidth(), miningPanel.getHeight()/4,
				miningPanel.getWidth() - miningNameLabel.getX() - miningNameLabel.getWidth() - 10, 16);
		miningPanel.add(miningProgressBar);
				
		//Noncombat smithing
		JPanel smithingPanel = new JPanel();
		smithingPanel.setBackground(new Color(255, 0, 0));
		smithingPanel.setBounds(0, miningPanel.getHeight(), nonCombatSelectionPanel.getWidth(), 32);
		smithingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(smithingPanel);
		smithingPanel.setLayout(null);

		JLabel smithingIconLabel = new JLabel("Icon");
		smithingIconLabel.setBackground(new Color(255, 255, 255)); smithingIconLabel.setOpaque(true); //TODO REMOVE
		smithingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		smithingIconLabel.setBounds(0, 0, 32, 32);
		smithingPanel.add(smithingIconLabel);

		JLabel smithingNameLabel = new JLabel("Smithing");
		smithingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		smithingNameLabel.setBounds(smithingIconLabel.getWidth() + 10, smithingPanel.getHeight()/4, 75, 16);
		smithingPanel.add(smithingNameLabel);

		JProgressBar smithingProgressBar = new JProgressBar();
		smithingProgressBar.setBounds(smithingNameLabel.getX() + smithingNameLabel.getWidth(), smithingPanel.getHeight()/4,
				smithingPanel.getWidth() - smithingNameLabel.getX() - smithingNameLabel.getWidth() - 10, 16);
		smithingPanel.add(smithingProgressBar);
		
		//Noncombat woodcutting
		JPanel woodcuttingPanel = new JPanel();
		woodcuttingPanel.setBackground(new Color(255, 0, 0));
		woodcuttingPanel.setBounds(0, smithingPanel.getY() + smithingPanel.getHeight(),
				nonCombatSelectionPanel.getWidth(), 32);
		woodcuttingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(woodcuttingPanel);
		woodcuttingPanel.setLayout(null);
		
		JLabel woodcuttingIconLabel = new JLabel("Icon");
		woodcuttingIconLabel.setBackground(new Color(255, 255, 255)); woodcuttingIconLabel.setOpaque(true); //TODO REMOVE
		woodcuttingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		woodcuttingIconLabel.setBounds(0, 0, 32, 32);
		woodcuttingPanel.add(woodcuttingIconLabel);
		
		JLabel woodcuttingNameLabel = new JLabel("Woodcutting");
		woodcuttingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		woodcuttingNameLabel.setBounds(woodcuttingIconLabel.getWidth() + 10, woodcuttingPanel.getHeight()/4, 75, 16);
		woodcuttingPanel.add(woodcuttingNameLabel);
		
		JProgressBar woodcuttingProgressBar = new JProgressBar();
		woodcuttingProgressBar.setBounds(woodcuttingNameLabel.getX() + woodcuttingNameLabel.getWidth(), woodcuttingPanel.getHeight()/4
				, woodcuttingPanel.getWidth() - woodcuttingNameLabel.getX() - woodcuttingNameLabel.getWidth() - 10, 16);
		woodcuttingPanel.add(woodcuttingProgressBar);
		
		//Noncombat crafting
		JPanel craftingPanel = new JPanel();
		craftingPanel.setBackground(new Color(255, 0, 0));
		craftingPanel.setBounds(0, woodcuttingPanel.getY() + woodcuttingPanel.getHeight(), nonCombatSelectionPanel.getWidth(), 32);
		craftingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(craftingPanel);
		craftingPanel.setLayout(null);

		JLabel craftingIconLabel = new JLabel("Icon");
		craftingIconLabel.setBackground(new Color(255, 255, 255)); craftingIconLabel.setOpaque(true); //TODO REMOVE
		craftingIconLabel.setBounds(0, 0, 32, 32);
		craftingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		craftingPanel.add(craftingIconLabel);

		JLabel craftingNameLabel = new JLabel("Crafting");
		craftingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		craftingNameLabel.setBounds(craftingIconLabel.getWidth() + 10, craftingPanel.getHeight()/4, 75, 16);
		craftingPanel.add(craftingNameLabel);

		JProgressBar craftingProgressBar = new JProgressBar();
		craftingProgressBar.setBounds(craftingNameLabel.getX() + craftingNameLabel.getWidth(), craftingPanel.getHeight()/4
				, craftingPanel.getWidth() - craftingNameLabel.getX() - craftingNameLabel.getWidth() - 10, 16);
		craftingPanel.add(craftingProgressBar);
		
		//Noncombat farming
		JPanel farmingPanel = new JPanel();
		farmingPanel.setBackground(new Color(255, 0, 0));
		farmingPanel.setBounds(0, craftingPanel.getY() + craftingPanel.getHeight(),
				nonCombatSelectionPanel.getWidth(), 32);
		farmingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(farmingPanel);
		farmingPanel.setLayout(null);

		JLabel farmingIconLabel = new JLabel("Icon");
		farmingIconLabel.setBackground(new Color(255, 255, 255)); farmingIconLabel.setOpaque(true); //TODO REMOVE
		farmingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		farmingIconLabel.setBounds(0, 0, 32, 32);
		farmingPanel.add(farmingIconLabel);

		JLabel farmingNameLabel = new JLabel("Farming");
		farmingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		farmingNameLabel.setBounds(farmingIconLabel.getWidth() + 10, farmingPanel.getHeight()/4, 75, 16);
		farmingPanel.add(farmingNameLabel);

		JProgressBar farmingProgressBar = new JProgressBar();
		farmingProgressBar.setBounds(farmingNameLabel.getX() + farmingNameLabel.getWidth(), farmingPanel.getHeight()/4
				, farmingPanel.getWidth() - farmingNameLabel.getX() - farmingNameLabel.getWidth() - 10, 16);
		farmingPanel.add(farmingProgressBar);
		
		//Noncombat fishing
		JPanel fishingPanel = new JPanel();
		fishingPanel.setBackground(new Color(255, 0, 0));
		fishingPanel.setBounds(0, farmingPanel.getY() + farmingPanel.getHeight(),
				nonCombatSelectionPanel.getWidth(), 32);
		fishingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(fishingPanel);
		fishingPanel.setLayout(null);

		JLabel fishingIconLabel = new JLabel("Icon");
		fishingIconLabel.setBackground(new Color(255, 255, 255)); fishingIconLabel.setOpaque(true); //TODO REMOVE
		fishingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		fishingIconLabel.setBounds(0, 0, 32, 32);
		fishingPanel.add(fishingIconLabel);

		JLabel fishingNameLabel = new JLabel("Fishing");
		fishingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fishingNameLabel.setBounds(fishingIconLabel.getWidth() + 10, fishingPanel.getHeight()/4, 75, 16);
		fishingPanel.add(fishingNameLabel);

		JProgressBar fishingProgressBar = new JProgressBar();
		fishingProgressBar.setBounds(fishingNameLabel.getX() + fishingNameLabel.getWidth(), fishingPanel.getHeight()/4
				, fishingPanel.getWidth() - fishingNameLabel.getX() - fishingNameLabel.getWidth() - 10, 16);
		fishingPanel.add(fishingProgressBar);
		
		//Noncombat cooking
		JPanel cookingPanel = new JPanel();
		cookingPanel.setBackground(new Color(255, 0, 0));
		cookingPanel.setBounds(0, fishingPanel.getY() + fishingPanel.getHeight(),
				nonCombatSelectionPanel.getWidth(), 32);
		cookingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		nonCombatSelectionPanel.add(cookingPanel);
		cookingPanel.setLayout(null);

		JLabel cookingIconLabel = new JLabel("Icon");
		cookingIconLabel.setBackground(new Color(255, 255, 255)); cookingIconLabel.setOpaque(true); //TODO REMOVE
		cookingIconLabel.setBounds(0, 0, 32, 32);
		cookingIconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		cookingPanel.add(cookingIconLabel);

		JLabel cookingNameLabel = new JLabel("Cooking");
		cookingNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cookingNameLabel.setBounds(cookingIconLabel.getWidth() + 10, cookingPanel.getHeight()/4, 75, 16);
		cookingPanel.add(cookingNameLabel);

		JProgressBar cookingProgressBar = new JProgressBar();
		cookingProgressBar.setBounds(cookingNameLabel.getX() + cookingNameLabel.getWidth(), cookingPanel.getHeight()/4,
				cookingPanel.getWidth() - cookingNameLabel.getX() - cookingNameLabel.getWidth() - 10, 16);
		cookingPanel.add(cookingProgressBar);
		
		
		//Top Panel
		
		topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBackground(Color.RED);
		topPanel.setBounds(sidePanel.getWidth(), 0, this.getWidth() - sidePanel.getWidth(), this.getHeight()/18);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JPanel activityPanel = new JPanel();
		activityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		activityPanel.setBounds(0, 0, 260, 60);
		topPanel.add(activityPanel);
		
		JLabel activityLabel = new JLabel("Activity");
		activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		activityPanel.add(activityLabel);
		
		JPanel equipmentPanel = new JPanel();
		equipmentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		equipmentPanel.setBounds(260, 0, 260, 60);
		topPanel.add(equipmentPanel);
		
		JLabel equipmentLabel = new JLabel("Equipment");
		equipmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		equipmentPanel.add(equipmentLabel);
		
		JPanel shopPanel = new JPanel();
		shopPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		shopPanel.setBounds(520, 0, 260, 60);
		topPanel.add(shopPanel);
		
		JLabel shopLabel = new JLabel("Shop");
		shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		shopPanel.add(shopLabel);
		
		//Content Panel
		
		contentPanel = new JPanel();
		contentPanel = setContentPanel(contentPanel, "Summary");
		contentPanel.setBounds(sidePanel.getWidth(), 60,
				this.getWidth()-sidePanel.getWidth(), this.getHeight()-topPanel.getHeight());
		contentPane.add(contentPanel);
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) 
			{
				/*
				sidePanel.setBounds(0, 0, contentPane.getWidth()/6, contentPane.getHeight());
				logoPanel.setBounds(0, 0, sidePanel.getWidth(), sidePanel.getHeight()/8);
				
				
				topPanel.setBounds(sidePanel.getWidth(), 0, contentPane.getWidth() - sidePanel.getWidth(), contentPane.getHeight()/18);
				contentPanel.setBounds(sidePanel.getWidth(), topPanel.getHeight(),
						contentPane.getWidth()-sidePanel.getWidth(),contentPane.getHeight()-topPanel.getHeight());
				*/
			}
		});
	}
	
	//Set general parameters
	private JPanel setContentPanel(JPanel contentPanel, String activity)
	{
		if(contentPanel != null) //if InternalFrame exists - get rid of it
		{
			contentPane.remove(contentPanel);
		}
		contentPanel = new JPanel();
		
		
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setLayout(null); //Perhaps will change it later
		//sets background to blue for debugging, change it to a picture / different 
		contentPanel.setBackground(new Color(0, 0, 255));
		
		setContentPanelContent(contentPanel, activity);
		return contentPanel;
		
	}
	
	private void setContentPanelContent(JPanel contentPanel,String activity)
	{
		switch(activity)
		{
			case "Summary":
				JLabel test = new JLabel("test");
				test.setBounds(200, 200, 20, 20);
				test.setForeground(new Color(255, 0, 0));
				contentPanel.add(test);
				break;
		}
		
	}
}
