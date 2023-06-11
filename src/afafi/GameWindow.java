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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.border.LineBorder;

public class GameWindow extends JFrame
{

    private JPanel contentPane;
    Player player = new Player();
    HashMap<Integer,Integer> exp1 = new HashMap<>();
    HashMap<Integer,Integer> exp2 = new HashMap<>();


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
    private CombatWindow combatWindow;
    private DevMenu devMenu;
    itemID itemID = new itemID();
    public int idItemID=1;
    ActivityThread activityThread;

    public GameWindow(String characterName)
    {

        Properties pexp2 = new Properties();
        Properties pexp1 = new Properties();
        try {
            pexp2.load(new FileInputStream("data/exp2.properties"));
            pexp1.load(new FileInputStream("data/exp1.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String key : pexp2.stringPropertyNames()) {
            exp2.put(Integer.parseInt(key), Integer.parseInt(pexp2.get(key).toString()));
        }
        for (String key : pexp1.stringPropertyNames()) {
            exp1.put(Integer.parseInt(key), Integer.parseInt(pexp1.get(key).toString()));
        }

        if(new File("data/accounts/admin/"+characterName+"/level.properties").isFile() && new File("data/accounts/admin/"+characterName+"/exp.properties").isFile()){
            try {
                player = new Player(characterName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
        //sidePanel.setBackground(new Color(0,0,0,255));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
                contentPanel = setContentPanel(contentPanel, "Summary");
            }
        });
        logoPanel.setBounds(0, 0, sidePanel.getWidth(), sidePanel.getHeight()/8);
        logoPanel.setBackground((sidePanel.getBackground()));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar attackProgressBar = new JProgressBar(0,100);
        attackProgressBar.setBounds(attackNameLabel.getX() + attackNameLabel.getWidth(), combatAttackPanel.getHeight()/4
                , combatAttackPanel.getWidth() - attackNameLabel.getX() - attackNameLabel.getWidth() - 10, 16);
        attackProgressBar.setValue(player.getLEVEL("attack"));
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

        JProgressBar strengthProgressBar = new JProgressBar(0,100);
        strengthProgressBar.setBounds(strengthNameLabel.getX() + strengthNameLabel.getWidth(), combatStrengthPanel.getHeight()/4
                , combatStrengthPanel.getWidth() - strengthNameLabel.getX() - strengthNameLabel.getWidth() - 10, 16);
        strengthProgressBar.setValue(player.getLEVEL("strength"));
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

        JProgressBar defenseProgressBar = new JProgressBar(0,100);
        defenseProgressBar.setBounds(defenceNameLabel.getX() + defenceNameLabel.getWidth(), combatDefencePanel.getHeight()/4
                , combatDefencePanel.getWidth() - defenceNameLabel.getX() - defenceNameLabel.getWidth() - 10, 16);
        defenseProgressBar.setValue(player.getLEVEL("defense"));
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

        JProgressBar hpProgressBar = new JProgressBar(0,100);
        hpProgressBar.setBounds(hpNameLabel.getX() + hpNameLabel.getWidth(), combatHpPanel.getHeight()/4
                , combatHpPanel.getWidth() - hpNameLabel.getX() - hpNameLabel.getWidth() - 10, 16);
        hpProgressBar.setValue(player.getLEVEL("hitpoints"));
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

        JProgressBar rangedProgressBar = new JProgressBar(0,100);
        rangedProgressBar.setBounds(rangedNameLabel.getX() + rangedNameLabel.getWidth(), combatRangedPanel.getHeight()/4
                , combatRangedPanel.getWidth() - rangedNameLabel.getX() - rangedNameLabel.getWidth() - 10, 16);
        rangedProgressBar.setValue(player.getLEVEL("ranged"));
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

        JProgressBar magicProgressBar = new JProgressBar(0,100);
        magicProgressBar.setBounds(magicNameLabel.getX() + magicNameLabel.getWidth(), combatMagicPanel.getHeight()/4
                , combatMagicPanel.getWidth() - magicNameLabel.getX() - magicNameLabel.getWidth() - 10, 16);
        magicProgressBar.setValue(player.getLEVEL("magic"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar miningProgressBar = new JProgressBar(0,100);
        miningProgressBar.setBounds(miningNameLabel.getX() + miningNameLabel.getWidth(), miningPanel.getHeight()/4,
                miningPanel.getWidth() - miningNameLabel.getX() - miningNameLabel.getWidth() - 10, 16);
        miningProgressBar.setValue(player.getLEVEL("mining"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar smithingProgressBar = new JProgressBar(0,100);
        smithingProgressBar.setBounds(smithingNameLabel.getX() + smithingNameLabel.getWidth(), smithingPanel.getHeight()/4,
                smithingPanel.getWidth() - smithingNameLabel.getX() - smithingNameLabel.getWidth() - 10, 16);
        smithingProgressBar.setValue(player.getLEVEL("smithing"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar woodcuttingProgressBar = new JProgressBar(0,100);
        woodcuttingProgressBar.setBounds(woodcuttingNameLabel.getX() + woodcuttingNameLabel.getWidth(), woodcuttingPanel.getHeight()/4
                , woodcuttingPanel.getWidth() - woodcuttingNameLabel.getX() - woodcuttingNameLabel.getWidth() - 10, 16);
        woodcuttingProgressBar.setValue(player.getLEVEL("woodcutting"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar craftingProgressBar = new JProgressBar(0,100);
        craftingProgressBar.setBounds(craftingNameLabel.getX() + craftingNameLabel.getWidth(), craftingPanel.getHeight()/4
                , craftingPanel.getWidth() - craftingNameLabel.getX() - craftingNameLabel.getWidth() - 10, 16);
        craftingProgressBar.setValue(player.getLEVEL("crafting"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar farmingProgressBar = new JProgressBar(0,100);
        farmingProgressBar.setBounds(farmingNameLabel.getX() + farmingNameLabel.getWidth(), farmingPanel.getHeight()/4
                , farmingPanel.getWidth() - farmingNameLabel.getX() - farmingNameLabel.getWidth() - 10, 16);
        farmingProgressBar.setValue(player.getLEVEL("farming"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar fishingProgressBar = new JProgressBar(0,100);
        fishingProgressBar.setBounds(fishingNameLabel.getX() + fishingNameLabel.getWidth(), fishingPanel.getHeight()/4
                , fishingPanel.getWidth() - fishingNameLabel.getX() - fishingNameLabel.getWidth() - 10, 16);
        fishingProgressBar.setValue(player.getLEVEL("fishing"));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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

        JProgressBar cookingProgressBar = new JProgressBar(0,100);
        cookingProgressBar.setBounds(cookingNameLabel.getX() + cookingNameLabel.getWidth(), cookingPanel.getHeight()/4,
                cookingPanel.getWidth() - cookingNameLabel.getX() - cookingNameLabel.getWidth() - 10, 16);
        cookingProgressBar.setValue(player.getLEVEL("cooking"));
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
                devMenu = new DevMenu(player);
                devMenu.setVisible(true);
            }
        });
        devMenuPanel.setOpaque(false);
        devMenuPanel.setBounds(0, 880, 320, 145);
        sidePanel.add(devMenuPanel);
        //sidePanel.add(labelSidePanel);

        //Top Panel

        topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        topPanel.setBackground(new Color(0,0,0,0));
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
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
                if(activityThread != null)
                {
                    activityThread.finish();
                    activityThread = null;
                }
                contentPanel = setContentPanel(contentPanel, "Shop");
            }
        } );
        topPanel.add(shopPanel);

        JLabel shopLabel = new JLabel("Shop");
        shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        shopPanel.add(shopLabel);

        JButton saveButtton = new JButton("Save");
        saveButtton.setBounds(1500, 0, 90, 60);
        saveButtton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    player.save(characterName);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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
        //just example
        itemID.playerEq.put(1,2);
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
        int help = 1;
        for (int i = 30; i < 380; i=i+66) {
            for (int j = 30; j < 1300; j=j+66) {
                setEquipmentShop(shelf, help,  j,i, true);
                help++;
            }
        }
        contentPanel.add(shelf);
        contentPanel.add(eqMain);
    }
    private void itemShop(JPanel shelf, String name, String price, String source, int x, int id){
        ImageIcon icon = new ImageIcon(GameWindow.class.getResource(source),"Brak ikony!");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBackground(new Color(255, 255, 255));
        iconLabel.setOpaque(true); //TODO REMOVE
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        iconLabel.setBounds(x, shelf.getHeight()/4, 64, 64);
        shelf.add(iconLabel);
        if (player.getLEVEL("money")>Integer.parseInt(price)){
            iconLabel.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    itemID.playerEq.put(idItemID, id);
                    idItemID++;
                    player.setLEVEL("money",player.getLEVEL("money")-Integer.parseInt(price));
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
        if (player.getLEVEL("money")>Integer.parseInt(price)){
            priceLabel.setForeground(new Color(255,255,255));
        }
        else{
            priceLabel.setForeground(new Color(255,0,0));
        }
        priceLabel.setBounds(x-18, (shelf.getHeight()/4)+75,100,30);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shelf.add(priceLabel);
    }

    private void setEquipmentShop(JPanel eqView, int id, int x, int y, boolean isEq) {
        JPanel border = new JPanel();
        border.setBounds(x, y, 64, 64);
        border.setBackground(new Color(143, 102, 61));
        border.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        border.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                border.setBackground(new Color(255, 102, 61));
            }

            public void mouseExited(MouseEvent e) {
                border.setBackground(new Color(143, 102, 61));
            }
        });
        if (itemID.playerEq.get(id) != null) {
            ImageIcon icon = new ImageIcon(GameWindow.class.getResource(itemID.id_list.get(id)[6]));
            JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
            iconLabel.setBackground(new Color(143, 102, 61));
            iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
            iconLabel.setBounds(0, 0, 64, 64);
            border.add(iconLabel);

            JLabel amount = new JLabel(itemID.id_list.get(id)[0], SwingConstants.CENTER);
            amount.setFont(new Font("Tahoma", Font.BOLD, 8));
            amount.setForeground(new Color(255, 255, 255));
            amount.setBounds(54, 20, 43, 30);
            amount.setHorizontalAlignment(SwingConstants.CENTER);
            //border.add(amount);
            if(isEq){
                iconLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("WORK");

                        JPanel infoPanel = new JPanel();
                        infoPanel.setBounds(0, 0, 64, 64);
                        infoPanel.setBackground(new Color(143, 102, 61));
                        infoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        //.add(infoPanel);

                        JLabel iconLabel = new JLabel(icon);
                        iconLabel.setBackground(new Color(143, 102, 61));
                        iconLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
                        iconLabel.setBounds(96, 515, 64, 64);
                        eqView.add(iconLabel);

                        JLabel amount = new JLabel(itemID.id_list.get(id)[0], SwingConstants.CENTER);
                        amount.setFont(new Font("Tahoma", Font.BOLD, 8));
                        amount.setForeground(new Color(255, 255, 255));
                        amount.setBounds(165, 485, 200, 30);
                        amount.setHorizontalAlignment(SwingConstants.CENTER);
                        //infoPanel.add(amount);

                        JLabel name = new JLabel();
                        name.setFont(new Font("Tahoma", Font.BOLD, 15));
                        name.setForeground(new Color(0,0,0));
                        name.setBounds(165, 500, 200, 30);
                        name.setText("Name: "+itemID.id_list.get(id)[0]);
                        eqView.add(name);

                        JLabel type = new JLabel("Type: "+itemID.id_list.get(id)[1]);
                        type.setFont(new Font("Tahoma", Font.BOLD, 15));
                        type.setForeground(new Color(0,0,0));
                        type.setBounds(165, 515, 200, 30);
                        type.setText("Type: "+itemID.id_list.get(id)[1]);
                        eqView.add(type);

                        JLabel attack = new JLabel();
                        attack.setFont(new Font("Tahoma", Font.BOLD, 15));
                        attack.setForeground(new Color(0,0,0));
                        attack.setBounds(165, 530, 200, 30);
                        attack.setText("Attack: "+itemID.id_list.get(id)[2]);
                        eqView.add(attack);

                        JLabel defense = new JLabel();
                        defense.setFont(new Font("Tahoma", Font.BOLD, 15));
                        defense.setForeground(new Color(0,0,0));
                        defense.setBounds(165, 545, 200, 30);
                        defense.setText("Defense: "+itemID.id_list.get(id)[3]);
                        eqView.add(defense);

                        JLabel lifeSteal = new JLabel();
                        lifeSteal.setFont(new Font("Tahoma", Font.BOLD, 15));
                        lifeSteal.setForeground(new Color(0,0,0));
                        lifeSteal.setBounds(165, 560, 200, 30);
                        lifeSteal.setText("Life steal: "+itemID.id_list.get(id)[4]);
                        eqView.add(lifeSteal);

                        JLabel price = new JLabel();
                        price.setFont(new Font("Tahoma", Font.BOLD, 15));
                        price.setForeground(new Color(0,0,0));
                        price.setBounds(165, 575, 200, 30);
                        price.setText("Price: "+itemID.id_list.get(id)[5]);
                        eqView.add(price);

                        //it works partially
                        //we need find some way to refresh that panel without fucking up alpha
                    }
                });
            }
        }
        else{

        }
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
        itemShop(shelf,  itemID.id_list.get(15)[0],itemID.id_list.get(15)[5], itemID.id_list.get(15)[6], 168, 15);
        itemShop(shelf, itemID.id_list.get(18)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 368, 18);
        itemShop(shelf, itemID.id_list.get(26)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 568, 26);
        itemShop(shelf, itemID.id_list.get(27)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 768, 27);
        itemShop(shelf, itemID.id_list.get(28)[0], itemID.id_list.get(18)[5], itemID.id_list.get(18)[6], 968, 28);

        //co 200
        // rgb(143, 102, 61)
        JPanel eqView = new JPanel();
        eqView.setBackground(new Color(143, 102, 61,192));
        eqView.setOpaque(true);
        eqView.setBounds(0,contentPanel.getHeight()*3/5,contentPanel.getWidth(),contentPanel.getHeight()*3/5);
        eqView.setLayout(null);
        int help = 1;
        for (int i = 30; i < 320; i=i+66) {
            for (int j = 30; j < 1500; j=j+66) {
                setEquipmentShop(eqView, help,  j,i, false );
                help++;
            }
        }
        contentPanel.add(shelf);
        contentPanel.add(eqView);
        contentPanel.add(shopMain);
    }

    private void combatcontent(JPanel contentPanel, String name, int size, int x, int start, String bg){
        JPanel combat = new JPanel();
        combat.setBorder(new LineBorder(new Color(0,0,0)));
        combat.setBackground(new Color(21, 29, 110,0));
        combat.setBounds(x,100, 350, 100);
        combat.setOpaque(false);
        combat.setLayout(null);
        contentPanel.add(combat);
        JButton dung = new JButton(name);
        dung.setFont(new Font("Tahoma", Font.BOLD, 28));
        dung.setBounds(0,0,350,100);
        dung.setOpaque(false);
        dung.setContentAreaFilled(false);
        dung.setFocusable(false);
        dung.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2,true));
        dung.setBorderPainted(true);
        dung.setForeground(new Color(0,0,0));

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

        combat.add(dung);
        JButton[] buttons = new JButton[size];
        for (int i = 0; i < size; i++) {
            buttons[i] = new JButton(itemID.monster_list.get(start+i)[0]);
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(new Font("Tahoma", Font.BOLD, 28));
            buttons[i].setBackground(new Color(21, 29, 110,0));
            buttons[i].setBounds(0, (i+1)*101, 350, 100);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setFocusable(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2,true));
            buttons[i].setBorderPainted(true);
            buttons[i].setForeground(new Color(0,0,0));
            combat.add(buttons[i]);
            int finalI = start+i;
            buttons[i].addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if(combatWindow!=null)
                    {
                        combatWindow.dispose();
                    }
                    combatWindow = new CombatWindow(itemID.monster_list.get(finalI),bg);
                    combatWindow.setVisible(true);
                }
            });
        }

    }
    private void setCombatContent(JPanel contentPanel){
        JPanel stats = new JPanel();
        stats.setOpaque(false);
        stats.setFocusable(false);
        stats.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2,true));
        stats.setBorder(new LineBorder(new Color(0,0,0)));
        stats.setBackground(new Color(0,0,0));
        stats.setBounds(0,contentPanel.getHeight()-50, contentPanel.getWidth(), 50);
        contentPanel.add(stats);

        JLabel nameLabel = new JLabel("Stats progress", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0,0,0));
        nameLabel.setBounds(0,contentPanel.getHeight()-50, contentPanel.getWidth(), 35);
        stats.add(nameLabel);

        // bars
        JLabel attackLabel = new JLabel("Attack experience", SwingConstants.CENTER);
        attackLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        attackLabel.setForeground(new Color(0,0,0));
        attackLabel.setBounds(0,25, contentPanel.getWidth(), 25);

        JProgressBar attack = new JProgressBar(exp1.get(player.getLEVEL("attack")), exp2.get(player.getLEVEL("attack")));
        attack.setValue(player.getEXP("attack"));
        attack.setForeground(new Color(255, 0, 0));
        attack.setBounds(50, 50, stats.getWidth()-100, 15);
        attack.setStringPainted(true);
        attack.setString(player.getEXP("attack") +"/"+ exp2.get(player.getLEVEL("attack")));

        JLabel strengthLabel = new JLabel("Strength experience", SwingConstants.CENTER);
        strengthLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        strengthLabel.setForeground(new Color(0,0,0));
        strengthLabel.setBounds(0,75, contentPanel.getWidth(), 25);

        JProgressBar strength = new JProgressBar(exp1.get(player.getLEVEL("strength")), exp2.get(player.getLEVEL("strength")));
        strength.setValue(player.getEXP("strength"));
        strength.setForeground(new Color(255, 0, 0));
        strength.setBounds(50, 100, stats.getWidth()-100, 15);
        strength.setStringPainted(true);
        strength.setString(player.getEXP("strength") +"/"+ exp2.get(player.getLEVEL("strength")));

        JLabel defenceLabel = new JLabel("Defence experience", SwingConstants.CENTER);
        defenceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        defenceLabel.setForeground(new Color(0,0,0));
        defenceLabel.setBounds(0,125, contentPanel.getWidth(), 25);

        JProgressBar defence = new JProgressBar(exp1.get(player.getLEVEL("defense")), exp2.get(player.getLEVEL("defense")));
        defence.setValue(player.getEXP("defense"));
        defence.setForeground(new Color(255, 0, 0));
        defence.setBounds(50, 150, stats.getWidth()-100, 15);
        defence.setStringPainted(true);
        defence.setString(player.getEXP("defense") +"/"+ exp2.get(player.getLEVEL("defense")));

        JLabel hitpointsLabel = new JLabel("Hitpoints experience", SwingConstants.CENTER);
        hitpointsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        hitpointsLabel.setForeground(new Color(0,0,0));
        hitpointsLabel.setBounds(0,175, contentPanel.getWidth(), 25);

        JProgressBar hitpoints = new JProgressBar(exp1.get(player.getLEVEL("hitpoints")), exp2.get(player.getLEVEL("hitpoints")));
        hitpoints.setValue(player.getEXP("hitpoints"));
        hitpoints.setForeground(new Color(255, 0, 0));
        hitpoints.setBounds(50, 200, stats.getWidth()-100, 15);
        hitpoints.setStringPainted(true);
        hitpoints.setString(player.getEXP("hitpoints") +"/"+ exp2.get(player.getLEVEL("hitpoints")));

        JLabel rangedLabel = new JLabel("Ranged experience", SwingConstants.CENTER);
        rangedLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        rangedLabel.setForeground(new Color(0,0,0));
        rangedLabel.setBounds(0,225, contentPanel.getWidth(), 25);

        JProgressBar ranged = new JProgressBar(exp1.get(player.getLEVEL("ranged")), exp2.get(player.getLEVEL("ranged")));
        ranged.setValue(player.getEXP("ranged"));
        ranged.setForeground(new Color(255, 0, 0));
        ranged.setBounds(50, 250, stats.getWidth()-100, 15);
        ranged.setStringPainted(true);
        ranged.setString(player.getEXP("ranged") +"/"+ exp2.get(player.getLEVEL("ranged")));

        JLabel magicLabel = new JLabel("Magic experience", SwingConstants.CENTER);
        magicLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        magicLabel.setForeground(new Color(0,0,0));
        magicLabel.setBounds(0,275, contentPanel.getWidth(), 25);

        JProgressBar magic = new JProgressBar(exp1.get(player.getLEVEL("magic")), exp2.get(player.getLEVEL("magic")));
        magic.setValue(player.getEXP("magic"));
        magic.setForeground(new Color(255, 0, 0));
        magic.setBounds(50, 300, stats.getWidth()-100, 15);
        magic.setStringPainted(true);
        magic.setString(player.getEXP("magic") +"/"+ exp2.get(player.getLEVEL("magic")));

        nameLabel.addMouseListener(new MouseAdapter()

        {
            public void mouseClicked(MouseEvent e)
            {
                if(stats.getHeight()> 100){
                    stats.setBounds(0,contentPanel.getHeight()-50, contentPanel.getWidth(), 50);
                    stats.remove(attack);
                    stats.remove(strength);
                    stats.remove(defence);
                    stats.remove(hitpoints);
                    stats.remove(ranged);
                    stats.remove(magic);
                    stats.remove(attackLabel);
                    stats.remove(strengthLabel);
                    stats.remove(defenceLabel);
                    stats.remove(hitpointsLabel);
                    stats.remove(rangedLabel);
                    stats.remove(magicLabel);
                }else{
                    stats.setBounds(0, contentPanel.getHeight()-400, contentPanel.getWidth(),400);
                    stats.add(attack);
                    stats.add(strength);
                    stats.add(defence);
                    stats.add(hitpoints);
                    stats.add(ranged);
                    stats.add(magic);
                    stats.add(attackLabel);
                    stats.add(strengthLabel);
                    stats.add(defenceLabel);
                    stats.add(hitpointsLabel);
                    stats.add(rangedLabel);
                    stats.add(magicLabel);
                }
            }
        });



        combatcontent(contentPanel, "Catacombs", 4, 40, 100, "/afafi/images/monsters/bg/cave.jpg");
        combatcontent(contentPanel, "Skidway's basement", 4, 430, 100, "/afafi/images/monsters/bg/cave.jpg");
        combatcontent(contentPanel, "Los Zielonas Goras", 3, 820, 5, "/afafi/images/monsters/bg/gta.jpg");
        combatcontent(contentPanel, "Dev Room", 4, 1210, 100, "/afafi/images/monsters/bg/cave.jpg");
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/monsters/bg/default_combat.jpg")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH)));
        contentPanel.add(bgImageMain);
    }

    private void skillcontent(JPanel contentPanel, String name, String icon, int level,int reqlevel, int x, int y, int exp, int tick )
    {
        //if we need, we can add parameters to change position of .setBounds
        ImageIcon iconMain = new ImageIcon(GameWindow.class.getResource(icon));
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
        JLabel iconLabel = new JLabel(iconMain, SwingConstants.CENTER);
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
            activityContent.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent e)
                {
                    activityContent.setBackground(new Color(0, 32, 64));
                }
                public void mouseExited(MouseEvent e)
                {
                    activityContent.setBackground(new Color(0, 32, 128));
                }
                public void mousePressed(MouseEvent e)
                {
                    if(activityThread != null)
                    {
                        activityThread.finish();
                        activityThread = null;
                    }
                    activityThread = new ActivityThread(activityContent, progressBar, tick);
                    activityThread.start();
                }
            });

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
        skillcontent(contentPanel,"Oak Tree", "/afafi/images/icons/Woodcutting/oak_tree.png", player.getLEVEL("woodcutting"), 1,50,25,10,100 );
        skillcontent(contentPanel,"Spruce Tree", "/afafi/images/icons/Woodcutting/spruce_tree.png",  player.getLEVEL("woodcutting"), 4,425,25,15,1200);
        skillcontent(contentPanel,"Birch Tree", "/afafi/images/icons/Woodcutting/birch_tree.png",  player.getLEVEL("woodcutting"), 7,800,25,25,1200);
        skillcontent(contentPanel,"Acocoa Tree", "/afafi/images/icons/Woodcutting/acocoa_tree.png",  player.getLEVEL("woodcutting"), 10,1175,25,40,900 );
        skillcontent(contentPanel,"Mangrove Tree", "/afafi/images/icons/Woodcutting/mangrove_tree.png",  player.getLEVEL("woodcutting"), 13,50,300,65,900);
        skillcontent(contentPanel,"Ash Tree", "/afafi/images/icons/Woodcutting/ash_tree.png",  player.getLEVEL("woodcutting"), 16,425,300,105,1200);
        skillcontent(contentPanel,"Maple Tree", "/afafi/images/icons/Woodcutting/maple_tree.png",  player.getLEVEL("woodcutting"), 19,800,300,170,1500);
        skillcontent(contentPanel,"Sycamore Tree", "/afafi/images/icons/Woodcutting/sycamore_tree.png",  player.getLEVEL("woodcutting"), 22,1175,300,275,188);
        skillcontent(contentPanel,"Adler Tree", "/afafi/images/icons/Woodcutting/adler_tree.png",  player.getLEVEL("woodcutting"), 25,50,575,445,2100);
        skillcontent(contentPanel,"Hornbeam Tree", "/afafi/images/icons/Woodcutting/hornbeam_tree.png", player.getLEVEL("woodcutting"), 28,425,575,720,2400);
        skillcontent(contentPanel,"Pine Tree", "/afafi/images/icons/Woodcutting/pine_tree.png",  player.getLEVEL("woodcutting"), 31,800,575,1165,2700);
        skillcontent(contentPanel,"Baobab Tree", "/afafi/images/icons/Woodcutting/baobab_tree.png", player.getLEVEL("woodcutting"), 34,1175,575,1885,3600);
        overallContent(contentPanel, player.getLEVEL("woodcutting"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }
    private void setCookingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Sandwich", "/afafi/images/icons/Cooking/sandwich.png", player.getLEVEL("cooking"), 1,50,25,10,1200 );
        skillcontent(contentPanel,"Cookies", "/afafi/images/icons/Cooking/cookies.png",  player.getLEVEL("cooking"), 3,425,25,15,1200);
        skillcontent(contentPanel,"Omlet", "/afafi/images/icons/Cooking/omlet.png",  player.getLEVEL("cooking"), 6,800,25,25,1200);
        skillcontent(contentPanel,"Donut", "/afafi/images/icons/Cooking/donut.png",  player.getLEVEL("cooking"), 10,1175,25,40,900 );
        skillcontent(contentPanel,"Pasta", "/afafi/images/icons/Cooking/pasta.png",  player.getLEVEL("cooking"), 14,50,300,65,900);
        skillcontent(contentPanel,"Waffle", "/afafi/images/icons/Cooking/waffle.png",  player.getLEVEL("cooking"), 18,425,300,105,1200);
        skillcontent(contentPanel,"Ramen", "/afafi/images/icons/Cooking/ramen.png",  player.getLEVEL("cooking"), 22,800,300,170,1500);
        skillcontent(contentPanel,"Grilled steak", "/afafi/images/icons/Cooking/steak.png",  player.getLEVEL("cooking"), 26,1175,300,275,188);
        skillcontent(contentPanel,"Roasted Chicken", "/afafi/images/icons/Cooking/roasted_chicken.png",  player.getLEVEL("cooking"), 30,50,575,445,2100);
        skillcontent(contentPanel,"Pizza", "/afafi/images/icons/Cooking/pizza.png", player.getLEVEL("cooking"), 34,425,575,720,2400);
        overallContent(contentPanel, player.getLEVEL("cooking"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }
    private void setFarmingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Apple", "/afafi/images/icons/Farming/apple.png", player.getLEVEL("farming"), 1,50,25,30,2400 );
        skillcontent(contentPanel,"Pear", "/afafi/images/icons/Farming/pear.png",  player.getLEVEL("farming"), 4,425,25,50,3600);
        skillcontent(contentPanel,"Carrot", "/afafi/images/icons/Farming/carrot.png",  player.getLEVEL("farming"), 7,800,25,80,4800);
        skillcontent(contentPanel,"Banana", "/afafi/images/icons/Farming/banana.png",  player.getLEVEL("farming"), 11,1175,25,200,6000 );
        skillcontent(contentPanel,"Corn", "/afafi/images/icons/Farming/corn.png",  player.getLEVEL("farming"), 15,50,300,420,7200);
        skillcontent(contentPanel,"Lemon", "/afafi/images/icons/Farming/lemon.png",  player.getLEVEL("farming"), 19,425,300,840,8400);
        skillcontent(contentPanel,"Tomato", "/afafi/images/icons/Farming/tomato.png",  player.getLEVEL("farming"), 23,800,300,1680,9600);
        skillcontent(contentPanel,"Strawberry", "/afafi/images/icons/Farming/strawberry.png",  player.getLEVEL("farming"), 27,1175,300,3360,10800);
        skillcontent(contentPanel,"Piripiri", "/afafi/images/icons/Farming/piripiri.png",  player.getLEVEL("farming"), 31,50,575,6720,1200);
        skillcontent(contentPanel,"Onion", "/afafi/images/icons/Farming/polack.png", player.getLEVEL("cooking"), 35,425,575,13340,13200);
        overallContent(contentPanel, player.getLEVEL("farming"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setFishingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Perch", "/afafi/images/icons/Fishing/Perch.png", player.getLEVEL("fishing"), 1,50,25,25,1800 );
        skillcontent(contentPanel,"Pike", "/afafi/images/icons/Fishing/Pike.png",  player.getLEVEL("fishing"), 5,425,25,50,2400);
        skillcontent(contentPanel,"Bream", "/afafi/images/icons/Fishing/Bream.png",  player.getLEVEL("fishing"), 9,800,25,100,3000);
        skillcontent(contentPanel,"Cod", "/afafi/images/icons/Fishing/Cod.png",  player.getLEVEL("fishing"), 13,1175,25,205,3600 );
        skillcontent(contentPanel,"Octopus", "/afafi/images/icons/Fishing/Octo.png",  player.getLEVEL("fishing"), 17,50,300,410,4200);
        skillcontent(contentPanel,"Turtle", "/afafi/images/icons/Fishing/Turtle.png",  player.getLEVEL("fishing"), 21,425,300,815,4800);
        skillcontent(contentPanel,"Powan", "/afafi/images/icons/Fishing/Powan.png",  player.getLEVEL("fishing"), 25,800,300,1625,5400);
        skillcontent(contentPanel,"Nemo", "/afafi/images/icons/Fishing/Nemo.png",  player.getLEVEL("fishing"), 29,1175,300,3250,6000);
        skillcontent(contentPanel,"Aqua Treasure", "/afafi/images/icons/Fishing/Aqua_treasure.png",  player.getLEVEL("fishing"), 33,50,575,6500,6600);
        overallContent(contentPanel, player.getLEVEL("fishing"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setMiningContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Coal", "/afafi/images/icons/Mining/coal.png", player.getLEVEL("mining"), 1,50,25,5,600);
        skillcontent(contentPanel,"Copper", "/afafi/images/icons/Mining/copper_ore.png",  player.getLEVEL("mining"), 2,425,25,10,600);
        skillcontent(contentPanel,"Silver", "/afafi/images/icons/Mining/silver_ore.png",  player.getLEVEL("mining"), 5,800,25,25,1200);
        skillcontent(contentPanel,"Iron", "/afafi/images/icons/Mining/iron_ore.png",  player.getLEVEL("mining"), 10,1175,25,75,1800 );
        skillcontent(contentPanel,"Gold", "/afafi/images/icons/Mining/gold_ore.png",  player.getLEVEL("mining"), 15,50,300,180,2400);
        skillcontent(contentPanel,"Allumium", "/afafi/images/icons/Mining/allumium_ore.png",  player.getLEVEL("mining"), 20,425,300,350,3000);
        skillcontent(contentPanel,"Platinium", "/afafi/images/icons/Mining/platinum_ore.png",  player.getLEVEL("mining"), 25,800,300,750,3600);
        skillcontent(contentPanel,"Cobalt", "/afafi/images/icons/Mining/cobalt_ore.png",  player.getLEVEL("mining"), 30,1175,300,1500,4200);
        skillcontent(contentPanel,"Titanium", "/afafi/images/icons/Mining/titanium_ore.png",  player.getLEVEL("mining"), 35,50,575,3500,4800);
        overallContent(contentPanel, player.getLEVEL("mining"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

    private void setSmithingContent(JPanel contentPanel)
    {
        skillcontent(contentPanel,"Stone", "/afafi/images/icons/Smithing/stone.png", player.getLEVEL("smithing"), 1,50,25,10,1200);
        skillcontent(contentPanel,"Copper", "/afafi/images/icons/Smithing/copper.png",  player.getLEVEL("smithing"), 3,425,25,20,1200);
        skillcontent(contentPanel,"Silver", "/afafi/images/icons/Smithing/silver.png",  player.getLEVEL("smithing"), 6,800,25,50,2400);
        skillcontent(contentPanel,"Iron", "/afafi/images/icons/Smithing/iron.png",  player.getLEVEL("smithing"), 11,1175,25,150,3600 );
        skillcontent(contentPanel,"Gold", "/afafi/images/icons/Smithing/gold.png",  player.getLEVEL("smithing"), 16,50,300,360,4800);
        skillcontent(contentPanel,"Allumium", "/afafi/images/icons/Smithing/Allumium.png",  player.getLEVEL("smithing"), 21,425,300,700,6000);
        skillcontent(contentPanel,"Platinium", "/afafi/images/icons/Smithing/platinum.png",  player.getLEVEL("smithing"), 26,800,300,1500,7200);
        skillcontent(contentPanel,"Cobalt", "/afafi/images/icons/Smithing/cobalt.png",  player.getLEVEL("smithing"), 31,1175,300,3000,8400);
        skillcontent(contentPanel,"Titanium", "/afafi/images/icons/Smithing/Titanium.png",  player.getLEVEL("smithing"), 36,50,575,7000,9600);
        overallContent(contentPanel, player.getLEVEL("smithing"));
        JLabel bgImageMain = new JLabel();//we can change pics more pics=better look
        bgImageMain.setBounds(0,0, contentPanel.getWidth(), contentPanel.getHeight());
        bgImageMain.setIcon(new ImageIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/mainbg.png")).getImage().getScaledInstance(bgImageMain.getWidth(), bgImageMain.getHeight(), Image.SCALE_SMOOTH), "Nie działa obrazek XD"));
        contentPanel.add(bgImageMain);
    }

}