package afafi;


/*
 * TODO:
 * Resize logo when resizing window
 * Make all components scalable
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.border.LineBorder;

public class GameWindow extends JFrame
{

    private JPanel contentPane;
    Player player = new Player();
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                try
                {
                    TickWatek tickWatek = new TickWatek();
                    GameWindow frame = new GameWindow("test");
                    frame.setVisible(true);
                    tickWatek.start();
                }
                catch (Exception e)
                {
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
    private EquipmentWindow equipmentWindow;
    private DevMenu devMenu;
    itemID itemID = new itemID();
    public int idItemID=1;
    public GameWindow(String characterName)
    {
    	setResizable(false);
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    	
    	ImageIcon windowIcon = new ImageIcon(GameWindow.class.getResource("/afafi/images/logo.png"));
    	setIconImage(windowIcon.getImage());
    	
    	setTitle("AFAFI - Another Freaking Awesome Fantasy Idle");
        setMaximumSize(new Dimension(1920, 1080));
        setMinimumSize(new Dimension(1280, 720));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(0, 0, 1920, 1080);
        setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight()); //Set fullscreen
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
        logoPanel.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		contentPanel = setContentPanel(contentPanel, "Summary");
        	}
        });
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

        JLabel characterNameLabel = new JLabel(characterName);
        characterNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        characterNamePanel.add(characterNameLabel);

        //Combat activities panels

        JPanel combatPanel = new JPanel();
        combatPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        combatPanel.setBounds(0, 180, 320, 295);
        combatPanel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Combat");
            }
        });
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
        nonCombatPanel.setLayout(null);
        sidePanel.add(nonCombatPanel);

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
        miningPanel.setLayout(null);
        miningPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Mining");
            }
        });
        nonCombatSelectionPanel.add(miningPanel);

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
        smithingPanel.setLayout(null);
        smithingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Smithing");
            }
        });
        nonCombatSelectionPanel.add(smithingPanel);

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
        woodcuttingPanel.setLayout(null);
        woodcuttingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Woodcutting");
            }
        });
        nonCombatSelectionPanel.add(woodcuttingPanel);

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
        craftingPanel.setLayout(null);
        craftingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Crafting");
            }
        });
        nonCombatSelectionPanel.add(craftingPanel);

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
        farmingPanel.setLayout(null);
        farmingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Farming");
            }
        });
        nonCombatSelectionPanel.add(farmingPanel);

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
        fishingPanel.setLayout(null);
        fishingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Fishing");
            }
        });
        nonCombatSelectionPanel.add(fishingPanel);

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
        cookingPanel.setLayout(null);
        cookingPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                contentPanel = setContentPanel(contentPanel, "Cooking");
            }
        });
        nonCombatSelectionPanel.add(cookingPanel);

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
        
        JPanel devMenuPanel = new JPanel();
        devMenuPanel.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		if(devMenu != null)
        		{
        			devMenu.dispose();
        		}
        		devMenu = new DevMenu();
        		devMenu.setVisible(true);
        	}
        });
        devMenuPanel.setOpaque(false);
        devMenuPanel.setBounds(0, 880, 320, 145);
        sidePanel.add(devMenuPanel);


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
        activityPanel.setBackground(new Color(255,255,255));
        activityPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered( MouseEvent e ) 
            {
                activityPanel.setBackground(new Color(179, 255, 179));
            }
            public void mouseExited(MouseEvent e) 
            {
                activityPanel.setBackground(new Color(255, 255,255));
            }
            public void mouseClicked(MouseEvent e) 
            {

            }
        } );
        topPanel.add(activityPanel);

        JLabel activityLabel = new JLabel("Activity");
        activityLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        activityPanel.add(activityLabel);

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        inventoryPanel.setBounds(260, 0, 260, 60);
        inventoryPanel.setBackground(new Color(255, 255,255));
        inventoryPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered( MouseEvent e ) 
            {
                inventoryPanel.setBackground(new Color(179, 255, 179));
            }
            public void mouseExited(MouseEvent e) 
            {
                inventoryPanel.setBackground(new Color(255, 255,255));
            }
            public void mouseClicked(MouseEvent e) 
            {
                contentPanel = setContentPanel(contentPanel, "Equipment");
            }
        } );
        topPanel.add(inventoryPanel);

        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        inventoryPanel.add(inventoryLabel);

        JPanel shopPanel = new JPanel();
        shopPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        shopPanel.setBounds(520, 0, 260, 60);
        shopPanel.setBackground(new Color(255, 255,255));
        shopPanel.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered( MouseEvent e ) 
            {
                shopPanel.setBackground(new Color(179, 255, 179));
            }
            public void mouseExited(MouseEvent e) 
            {
                shopPanel.setBackground(new Color(255, 255,255));
            }
            public void mouseClicked(MouseEvent e) 
            {
                contentPanel = setContentPanel(contentPanel, "Shop");
            }
        } );
        topPanel.add(shopPanel);

        JLabel shopLabel = new JLabel("Shop");
        shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        shopPanel.add(shopLabel);

        JButton saveButtton = new JButton("Save");
        saveButtton.setBounds(1500, 0, 90, 60);
        topPanel.add(saveButtton);

        JButton equipmentButton = new JButton("");
        equipmentButton.addMouseListener(new MouseAdapter() 
        {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		if(equipmentWindow!=null)
        		{
        			equipmentWindow.dispose();
        		}
        		equipmentWindow = new EquipmentWindow();
        		equipmentWindow.setVisible(true);
        	}
        });
        equipmentButton.setLayout(new BoxLayout(equipmentButton, BoxLayout.Y_AXIS));
        equipmentButton.setBounds(1400, 0, 100, 60);

        JLabel equipmentButtonLabel1 = new JLabel("Equipment");
        JLabel equipmentButtonLabel2 = new JLabel("window");

        equipmentButton.add(equipmentButtonLabel1);
        equipmentButton.add(equipmentButtonLabel2);
        topPanel.add(equipmentButton);

        //Content Panel

        contentPanel = new JPanel();
        contentPanel = setContentPanel(contentPanel, "Summary");
        contentPanel.setBounds(sidePanel.getWidth(), topPanel.getHeight(),
                this.getWidth()-sidePanel.getWidth(), this.getHeight()-topPanel.getHeight());
        JLabel bgImageMain = new JLabel();
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png"))
        		.getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
        contentPane.add(contentPanel);

        //loading items/monsters/etc
        itemID.readItems();
    }

    //Set general parameters
    private JPanel setContentPanel(JPanel contentPanel, String activity)
    {
        if(contentPanel != null) //if contentPanel exists - get rid of it's contents
        {
            contentPanel.removeAll();
        }

        contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        contentPanel.setLayout(null); //Perhaps will change it later
        contentPanel.setBounds(sidePanel.getWidth(), topPanel.getHeight(),
                contentPane.getWidth()-sidePanel.getWidth(),contentPane.getHeight()-topPanel.getHeight());
        //sets background to blue for debugging, change it to a picture / different
        contentPanel.setBackground(new Color(0, 0, 255));
        setContentPanelContent(contentPanel, activity);
        contentPanel.validate();
        contentPanel.repaint();
        return contentPanel;

    }

    private void setContentPanelContent(JPanel contentPanel,String activity)
    {
        switch(activity)
        {
            case "Summary":
                JLabel bgImageMain = new JLabel();
                bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
                bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png"))
                		.getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
                contentPanel.add(bgImageMain);
                break;
            case "Woodcutting":
                player.setWoodcuttingOverall(5);//example
                setWoodcuttingContent(contentPanel);
                break;
            case "Cooking":
                setCookingContent(contentPanel);
                break;
            case "Crafting":
                //setCraftingContent(contentPanel);
                break;
            case "Farming":
                setFarmingContent(contentPanel);
                break;
            case "Fishing":
                setFishingContent(contentPanel);
                break;
            case "Mining":
                setMiningContent(contentPanel);
                break;
            case "Smithing":
                setSmithingContent(contentPanel);
                break;
            case "Equipment":
                setEqupimentContent(contentPanel);
                break;
            case "Shop":
                setShopContent(contentPanel);
                break;
            case "Combat":
                setCombatContent(contentPanel);
                break;
        }

    }

    private void setEqupimentContent(JPanel contentPanel){
        JPanel eqMain = new JPanel();
        eqMain.setBorder(new LineBorder(new Color(0,0,0)));
        //shopMain.setBackground(new Color(0, 32, 128));
        eqMain.setBounds(0,0,getWidth(), getHeight());
        eqMain.setLayout(null);
        JLabel bgImage = new JLabel();
        bgImage.setBounds(0, 0, eqMain.getWidth(), eqMain.getHeight());
        //tried to scale image but results with white box -_-
        bgImage.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/eqiupment.png")).getImage().getScaledInstance(
                bgImage.getWidth(), bgImage.getHeight(), Image.SCALE_SMOOTH)));
        eqMain.add(bgImage);
        JPanel shelf = new JPanel();
        shelf.setBackground(new Color(255, 255, 255, 128));
        shelf.setOpaque(true);
        shelf.setBounds(100,100 , contentPanel.getWidth()-210, contentPanel.getHeight()-210);
        shelf.setLayout(null);
        //co 200
        // rgb(143, 102, 61)
        for (int i = 30; i < shelf.getHeight()- 60; i=i+66) {
            for (int j = 30; j < shelf.getWidth() - 60; j=j+66) {
                setEquipmentShop(shelf, "id", "name", j,i );
            }
        }
        contentPanel.add(shelf);
        contentPanel.add(eqMain);
    }
    private void itemShop(JPanel shelf, String name, String price, String source, int x){
        //unitil we dont have icons
        //ImageIcon icon = new ImageIcon(GameWindow.class.getResource(source),"Brak ikony!");
        JLabel iconLabel = new JLabel("ICON");
        iconLabel.setBackground(new Color(255, 255, 255));
        iconLabel.setOpaque(true); //TODO REMOVE
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        iconLabel.setBounds(x, shelf.getHeight()/4, 64, 64);
        shelf.add(iconLabel);
        if (player.getMoney()>Integer.parseInt(price)){
            iconLabel.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    //will be fixed;
                }
            } );
        }

        JLabel amount = new JLabel(name, SwingConstants.CENTER);
        amount.setFont(new Font("Tahoma", Font.BOLD, 10));
        amount.setForeground(new Color(255,255,255));
        amount.setBounds(x-18, (shelf.getHeight()/4)+60,100,30);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        shelf.add(amount);

        JLabel priceLabel = new JLabel(price, SwingConstants.CENTER);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        if (player.getMoney()>Integer.parseInt(price)){
            priceLabel.setForeground(new Color(255,255,255));
        }
        else{
            priceLabel.setForeground(new Color(255,0,0));
        }
        priceLabel.setBounds(x-18, (shelf.getHeight()/4)+75,100,30);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shelf.add(priceLabel);
    }

    private void setEquipmentShop(JPanel eqView, String id, String name, int x, int y){
        JPanel border = new JPanel();
        border.setBounds(x, y, 64, 64);
        border.setBackground(new Color(143, 102, 61));
        border.setBorder(new LineBorder(new Color(0,0,0),1));
        border.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered( MouseEvent e )
            {
                border.setBackground(new Color(255, 102, 61));
            }
            public void mouseExited(MouseEvent e)
            {
                border.setBackground(new Color(143, 102, 61));
            }
        } );
        ImageIcon icon = new ImageIcon(GameWindow.class.getResource("/afafi/images/test.png"),"TEST");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBackground(new Color(255, 255, 255));
        iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        iconLabel.setBounds(16, 16, 64, 64);
        border.add(iconLabel);

        JLabel amount = new JLabel(name, SwingConstants.CENTER);
        amount.setFont(new Font("Tahoma", Font.BOLD, 10));
        amount.setForeground(new Color(255,255,255));
        amount.setBounds(54, 20,43,30);
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        border.add(amount);
        eqView.add(border);
    }
    private void setShopContent(JPanel contentPanel){
        JPanel shopMain = new JPanel();
        shopMain.setBorder(new LineBorder(new Color(0,0,0)));
        //shopMain.setBackground(new Color(0, 32, 128));
        shopMain.setBounds(0,0,getWidth(), getHeight());
        shopMain.setLayout(null);
        JLabel bgImage = new JLabel();
        bgImage.setBounds(0, 0, shopMain.getWidth(), shopMain.getHeight());
        //tried to scale image but results with white box -_-
        bgImage.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/shop.png")).getImage().getScaledInstance(
        		bgImage.getWidth(), bgImage.getHeight(), Image.SCALE_SMOOTH)));
        shopMain.add(bgImage);
        JPanel shelf = new JPanel();
        shelf.setBackground(new Color(255, 255, 255, 128));
        shelf.setOpaque(true);
        shelf.setBounds(contentPanel.getWidth()/8,100 , contentPanel.getWidth()*3/4, 150);
        shelf.setLayout(null);
        itemShop(shelf,  itemID.id_list.get(15)[0],itemID.id_list.get(15)[5], itemID.id_list.get(15)[6], 168);
        itemShop(shelf, itemID.id_list.get(18)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 368);
        itemShop(shelf, itemID.id_list.get(26)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 568);
        itemShop(shelf, itemID.id_list.get(27)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 768);
        itemShop(shelf, itemID.id_list.get(28)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 968);

        //co 200
        // rgb(143, 102, 61)
        JPanel eqView = new JPanel();
        eqView.setBackground(new Color(143, 102, 61,192));
        eqView.setOpaque(true);
        eqView.setBounds(0,contentPanel.getHeight()*3/5,contentPanel.getWidth(),contentPanel.getHeight()*3/5);
        eqView.setLayout(null);
        for (int i = 30; i < 320; i=i+66) {
            for (int j = 30; j < 1500; j=j+66) {
                setEquipmentShop(eqView, "id", "name", j,i );
            }
        }
        contentPanel.add(shelf);
        contentPanel.add(eqView);
        contentPanel.add(shopMain);
    }
    private void combatcontent(JPanel contentPanel, String name, int size, int x){
        JPanel combat = new JPanel();
        combat.setBorder(new LineBorder(new Color(0,0,0)));
        combat.setBackground(new Color(203, 184, 184));
        combat.setBounds(x,100, 350, 100);
        combat.setLayout(null);
        contentPanel.add(combat);
        JButton dung = new JButton(name);
        dung.setBackground(new Color(91, 45, 45));
        dung.setBounds(0,0,350,100);
        combat.add(dung);
        dung.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(combat.getHeight()> 100){
                    combat.setSize(combat.getWidth(), 100);
                }else{
                    combat.setSize(combat.getWidth(), (size+1)*101);
                }
            }
        });

        JButton[] buttons = new JButton[size];
        for (int i = 0; i < size; i++) {
            buttons[i] = new JButton("Monster name");
            buttons[i].setBackground(new Color(42, 141, 110));
            buttons[i].setBounds(0, (i+1)*101, 350, 100);
            combat.add(buttons[i]);
        }
    }
    private void setCombatContent(JPanel contentPanel){
        combatcontent(contentPanel, "Catacombs", 4, 40);
        combatcontent(contentPanel, "Skidway's basement", 4, 430);
        combatcontent(contentPanel, "Kurut08's basement", 4, 820);
        combatcontent(contentPanel, "Mangekyou's basement", 4, 1210);
    }

    private void skillcontent(JPanel contentPanel, String name, String icon, int level,int reqlevel, int x, int y, int exp, int tick )
    {
        //if we need, we can add parameters to change position of .setBounds
        JPanel activityContent = new JPanel();
        activityContent.setBorder(new LineBorder(new Color(0,0,0)));
        activityContent.setBackground(new Color(0, 32, 128));
        activityContent.setBounds(x,y, 350, 250);
        activityContent.setLayout(null);
        contentPanel.add(activityContent);
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        nameLabel.setForeground(new Color(255,255,255));
        nameLabel.setBounds(0, 0, 350, 100);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        activityContent.add(nameLabel);
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setBackground(new Color(255, 255, 255));
        iconLabel.setOpaque(true); //TODO REMOVE
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        iconLabel.setBounds(350/2-25, 90, 64, 64);
        activityContent.add(iconLabel);
        JLabel levelLabel = new JLabel("Progres: "+level, SwingConstants.CENTER);//need string variable instead of text
        levelLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        levelLabel.setForeground(new Color(255,255,255));
        levelLabel.setBounds(0, 130,350,100);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        activityContent.add(levelLabel);
        JProgressBar progressBar = new JProgressBar(0,tick);
        progressBar.setValue(0);
        progressBar.setBounds(25, 210, 300, 15);//need variable to fill progress bar
        activityContent.add(progressBar);
        if(reqlevel>level)
        {
            activityContent.setBorder(new LineBorder(new Color(0,0,0)));
            activityContent.setBackground(new Color(230, 0, 0));
            activityContent.setBounds(x,y, 350, 250);
            activityContent.setLayout(null);
            contentPanel.add(activityContent);
        }
        else
        {
            activityThread activityThread = new activityThread(activityContent, progressBar, tick);
            activityThread.start();
        }
        /*

         */
    }
    private  void overallContent(JPanel contentPanel, int overall)
    {
        JPanel summary = new JPanel();
        summary.setBorder(new LineBorder(new Color(0,0,0)));
        summary.setBackground(new Color(0,32,128));
        summary.setBounds(50, 850, 1475, 90);
        summary.setLayout(null);
        contentPanel.add(summary);
        JLabel summaryNameLabel = new JLabel("Overall level: "+overall+"/100", SwingConstants.CENTER);
        summaryNameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        summaryNameLabel.setForeground(new Color(255,255,255));
        summaryNameLabel.setBounds(0, 0,350,30);
        summaryNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        summary.add(summaryNameLabel);
        JProgressBar summaryProgressBar = new JProgressBar();
        summaryProgressBar.setBounds(25, 40, 1425, 20);
        summary.add(summaryProgressBar);
    }
    private void setWoodcuttingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Oak Tree", "Icon", player.getWoodcuttingOverall(), 1,50,25,10,100 );
        skillcontent(contentPanel,"Spruce Tree", "0000",  player.getWoodcuttingOverall(), 4,425,25,15,1200);
        skillcontent(contentPanel,"Birch Tree", "Icon",  player.getWoodcuttingOverall(), 7,800,25,25,1200);
        skillcontent(contentPanel,"Acocoa Tree", "Icon",  player.getWoodcuttingOverall(), 10,1175,25,40,900 );
        skillcontent(contentPanel,"Mangrove Tree", "Icon",  player.getWoodcuttingOverall(), 13,50,300,65,900);
        skillcontent(contentPanel,"Ash Tree", "Icon",  player.getWoodcuttingOverall(), 16,425,300,105,1200);
        skillcontent(contentPanel,"Maple Tree", "Icon",  player.getWoodcuttingOverall(), 19,800,300,170,1500);
        skillcontent(contentPanel,"Sycamore Tree", "Icon",  player.getWoodcuttingOverall(), 22,1175,300,275,188);
        skillcontent(contentPanel,"Adler Tree", "Icon",  player.getWoodcuttingOverall(), 25,50,575,445,2100);
        skillcontent(contentPanel,"Hornbeam Tree", "Icon", player.getWoodcuttingOverall(), 28,425,575,720,2400);
        skillcontent(contentPanel,"Pine Tree", "Icon",  player.getWoodcuttingOverall(), 31,800,575,1165,2700);
        skillcontent(contentPanel,"Baobab Tree", "Icon", player.getWoodcuttingOverall(), 34,1175,575,1885,3600);
        overallContent(contentPanel, player.getWoodcuttingOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }
    private void setCookingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Toasts with butter", "Icon", player.getCookingOverall(), 1,50,25,10,1200 );
        skillcontent(contentPanel,"Fish Soup", "0000",  player.getCookingOverall(), 3,425,25,15,1200);
        skillcontent(contentPanel,"Instant soup", "Icon",  player.getCookingOverall(), 6,800,25,25,1200);
        skillcontent(contentPanel,"Muesli", "Icon",  player.getCookingOverall(), 10,1175,25,40,900 );
        skillcontent(contentPanel,"Pasta", "Icon",  player.getCookingOverall(), 14,50,300,65,900);
        skillcontent(contentPanel,"Ravioli", "Icon",  player.getCookingOverall(), 18,425,300,105,1200);
        skillcontent(contentPanel,"Ramen", "Icon",  player.getCookingOverall(), 22,800,300,170,1500);
        skillcontent(contentPanel,"Grilled steak", "Icon",  player.getCookingOverall(), 26,1175,300,275,188);
        skillcontent(contentPanel,"Roasted Chicken", "Icon",  player.getCookingOverall(), 30,50,575,445,2100);
        skillcontent(contentPanel,"Chicken soup", "Icon", player.getCookingOverall(), 34,425,575,720,2400);
        overallContent(contentPanel, player.getCookingOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }
    private void setFarmingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Wheat", "Icon", player.getFarmingOverall(), 1,50,25,30,2400 );
        skillcontent(contentPanel,"Rye", "0000",  player.getFarmingOverall(), 4,425,25,50,3600);
        skillcontent(contentPanel,"Barley", "Icon",  player.getFarmingOverall(), 7,800,25,80,4800);
        skillcontent(contentPanel,"Corn", "Icon",  player.getFarmingOverall(), 11,1175,25,200,6000 );
        skillcontent(contentPanel,"Oat", "Icon",  player.getFarmingOverall(), 15,50,300,420,7200);
        skillcontent(contentPanel,"Hop", "Icon",  player.getFarmingOverall(), 19,425,300,840,8400);
        skillcontent(contentPanel,"Pumpkin", "Icon",  player.getFarmingOverall(), 23,800,300,1680,9600);
        skillcontent(contentPanel,"Rice", "Icon",  player.getFarmingOverall(), 27,1175,300,3360,10800);
        skillcontent(contentPanel,"Melon", "Icon",  player.getFarmingOverall(), 31,50,575,6720,1200);
        skillcontent(contentPanel,"Potato", "Icon", player.getCookingOverall(), 35,425,575,13340,13200);
        overallContent(contentPanel, player.getFarmingOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setFishingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Perch", "Icon", player.getFishingOverall(), 1,50,25,25,1800 );
        skillcontent(contentPanel,"Pike", "0000",  player.getFishingOverall(), 5,425,25,50,2400);
        skillcontent(contentPanel,"Bream", "Icon",  player.getFishingOverall(), 9,800,25,100,3000);
        skillcontent(contentPanel,"Cod", "Icon",  player.getFishingOverall(), 13,1175,25,205,3600 );
        skillcontent(contentPanel,"Sea Trout", "Icon",  player.getFishingOverall(), 17,50,300,410,4200);
        skillcontent(contentPanel,"Catfish", "Icon",  player.getFishingOverall(), 21,425,300,815,4800);
        skillcontent(contentPanel,"Barbel", "Icon",  player.getFishingOverall(), 25,800,300,1625,5400);
        skillcontent(contentPanel,"Powan", "Icon",  player.getFishingOverall(), 29,1175,300,3250,6000);
        skillcontent(contentPanel,"Shark", "Icon",  player.getFishingOverall(), 33,50,575,6500,6600);
        overallContent(contentPanel, player.getFishingOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setMiningContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Coal", "Icon", player.getMiningOverall(), 1,50,25,5,600);
        skillcontent(contentPanel,"Copper", "0000",  player.getMiningOverall(), 2,425,25,10,600);
        skillcontent(contentPanel,"Silver", "Icon",  player.getMiningOverall(), 5,800,25,25,1200);
        skillcontent(contentPanel,"Iron", "Icon",  player.getMiningOverall(), 10,1175,25,75,1800 );
        skillcontent(contentPanel,"Nickel", "Icon",  player.getMiningOverall(), 15,50,300,180,2400);
        skillcontent(contentPanel,"Allumium", "Icon",  player.getMiningOverall(), 20,425,300,350,3000);
        skillcontent(contentPanel,"Platinium", "Icon",  player.getMiningOverall(), 25,800,300,750,3600);
        skillcontent(contentPanel,"Cobalt", "Icon",  player.getMiningOverall(), 30,1175,300,1500,4200);
        skillcontent(contentPanel,"Titanium", "Icon",  player.getMiningOverall(), 35,50,575,3500,4800);
        overallContent(contentPanel, player.getMiningOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setSmithingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Stone", "Icon", player.getSmithingOverall(), 1,50,25,10,1200);
        skillcontent(contentPanel,"Copper", "0000",  player.getSmithingOverall(), 3,425,25,20,1200);
        skillcontent(contentPanel,"Silver", "Icon",  player.getSmithingOverall(), 6,800,25,50,2400);
        skillcontent(contentPanel,"Iron", "Icon",  player.getSmithingOverall(), 11,1175,25,150,3600 );
        skillcontent(contentPanel,"Nickel", "Icon",  player.getSmithingOverall(), 16,50,300,360,4800);
        skillcontent(contentPanel,"Allumium", "Icon",  player.getSmithingOverall(), 21,425,300,700,6000);
        skillcontent(contentPanel,"Platinium", "Icon",  player.getSmithingOverall(), 26,800,300,1500,7200);
        skillcontent(contentPanel,"Cobalt", "Icon",  player.getSmithingOverall(), 31,1175,300,3000,8400);
        skillcontent(contentPanel,"Titanium", "Icon",  player.getSmithingOverall(), 36,50,575,7000,9600);
        overallContent(contentPanel, player.getSmithingOverall());
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }
}