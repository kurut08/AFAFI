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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		sidePanel = new JPanel();
		sidePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sidePanel.setBackground(Color.GREEN);
		sidePanel.setBounds(0, 0, this.getWidth()/6, this.getHeight());
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		logoPanel = new JPanel();
		logoPanel.setBounds(0, 0, sidePanel.getWidth(), sidePanel.getHeight()/8);
		logoPanel.setBackground(sidePanel.getBackground());
		sidePanel.add(logoPanel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(GameWindow.class.getResource("/afafi/images/logo.png")));
		logoLabel.setBounds(0, 0, logoPanel.getWidth(), logoPanel.getHeight());
		logoPanel.add(logoLabel);
		
		JPanel characterNamePanel = new JPanel();
		characterNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		characterNamePanel.setBounds(0, 135, sidePanel.getWidth(), 45);
		sidePanel.add(characterNamePanel);
		
		JLabel characterNameLabel = new JLabel("Nickname");
		characterNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		characterNamePanel.add(characterNameLabel);
		
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
		combatSelectionPanel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		combatSelectionPanel.setLayout(null);
		
		JPanel combatAttackPanel = new JPanel();
		combatAttackPanel.setBounds(0, 0, combatSelectionPanel.getWidth(), 32);
		combatAttackPanel.setLayout(null);
		combatAttackPanel.setBackground(new Color(255, 0, 0));
		combatSelectionPanel.add(combatAttackPanel);
		
		JLabel attackIconLabel = new JLabel("Icon");
		attackIconLabel.setBounds(0, 0, 32, 32);
		attackIconLabel.setBackground(new Color(255, 255, 255)); attackIconLabel.setOpaque(true); //TODO REMOVE
		combatAttackPanel.add(attackIconLabel);
		
		JLabel attackNameLabel = new JLabel("Attack");
		attackNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attackNameLabel.setBounds(attackIconLabel.getWidth() + 10, combatAttackPanel.getHeight()/4, 75, 16);
		combatAttackPanel.add(attackNameLabel);
		
		JProgressBar attackProgressBar = new JProgressBar();
		attackProgressBar.setBounds(attackNameLabel.getX() + attackNameLabel.getWidth(), combatAttackPanel.getHeight()/4
				, combatAttackPanel.getWidth() - attackNameLabel.getX() - attackNameLabel.getWidth() - 10, 16);
		combatAttackPanel.add(attackProgressBar);
		
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
		nonCombatSelectionPanel.setBounds(0, 45, nonCombatPanel.getWidth() - 1, 250);
		nonCombatPanel.add(nonCombatSelectionPanel);
		nonCombatSelectionPanel.setLayout(null);
		
		JPanel woodcuttingPanel = new JPanel();
		woodcuttingPanel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		woodcuttingPanel.setBackground(new Color(255, 0, 0));
		woodcuttingPanel.setBounds(0, 0, nonCombatSelectionPanel.getWidth(), 32);
		nonCombatSelectionPanel.add(woodcuttingPanel);
		woodcuttingPanel.setLayout(null);
		
		JLabel woodcuttingIconLabel = new JLabel("Icon");
		woodcuttingIconLabel.setBackground(new Color(255, 255, 255));
		woodcuttingIconLabel.setOpaque(true);
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
