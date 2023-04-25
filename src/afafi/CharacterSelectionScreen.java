package afafi;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CharacterSelectionScreen extends JFrame 
{

	private JPanel contentPane;
	private JPanel[] charactersPanels;
	
	private JLabel[][] charactersLabels, charactersValuesLabels;
	
	private File charactersListFile;
	private File charactersDirectory;

	/**
	 * Create the frame.
	 */
	public CharacterSelectionScreen(String login) 
	{
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(153, 217, 234));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		charactersDirectory = new File("data/accounts/" + login + "/");
		charactersListFile = new File("data/accounts/" + login + ".txt");
		
		//Adding panels and labels to handle them more efficiently
		charactersPanels = new JPanel[5];
		charactersLabels = new JLabel[5][6];
		charactersValuesLabels = new JLabel[5][6];
		/*
		 * 0 - Name
		 * 1 - Activity
		 * 2 - Activity Time
		 * 3 - Total Level
		 * 4 - Money
		 * 5 - Save Date
		 */
		
		//Will probably add another 5 labels for icons, once we have them lmao
		
		try
		{
			Scanner charactersListFileScanner = new Scanner(charactersListFile);
			for(int i = 0; i < 5; i++) //Add labels to every panel and read stats from character files, if they exist
			{
				String characterName = "";
				Scanner characterScanner;
				String[] temp = new String[5]; // Labels 1-5
				if(charactersListFileScanner.hasNext())
				{
					characterName = charactersListFileScanner.next();
					characterScanner = new Scanner(new File(charactersDirectory + "/" + characterName + ".txt"));
					temp = characterScanner.nextLine().split(";");
					characterScanner.close();
				}
				
				charactersPanels[i] = new JPanel();
				charactersPanels[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				charactersPanels[i].setBackground(new Color(153, 217, 234));
				charactersPanels[i].setMaximumSize(new Dimension(getWidth(), getHeight()/5));
				charactersPanels[i].setAlignmentX(Component.LEFT_ALIGNMENT);
				charactersPanels[i].setAlignmentY(Component.TOP_ALIGNMENT);
				charactersPanels[i].setLayout(null);
				contentPane.add(charactersPanels[i]);
				
				
				
				charactersLabels[i][0] = new JLabel("Name:");
				charactersLabels[i][0].setBounds(0, 1, 40, 14);
				charactersValuesLabels[i][0] = new JLabel(characterName);
				charactersValuesLabels[i][0].setBounds(40, 1, 100, 14);
				
				charactersLabels[i][1] = new JLabel("Activity:");
				charactersLabels[i][1].setBounds(0, 72, 45, 14);
				charactersValuesLabels[i][1] = new JLabel(temp[0]);
				charactersValuesLabels[i][1].setBounds(45, 72, 50, 14);
				
				charactersLabels[i][2] = new JLabel("Activity Time:"); //TODO
				charactersLabels[i][2].setBounds(150, 72, 75, 14);
				charactersValuesLabels[i][2] = new JLabel(temp[1]);
				charactersValuesLabels[i][2].setBounds(225, 72, 100, 14);
				
				charactersLabels[i][3] = new JLabel("Total Level:");
				charactersLabels[i][3].setBounds(472, 1, 65, 14);
				charactersValuesLabels[i][3] = new JLabel(temp[2]);
				charactersValuesLabels[i][3].setBounds(537, 1, 100, 14);
				
				charactersLabels[i][4] = new JLabel("Money:");
				charactersLabels[i][4].setBounds(472, 15, 40, 14);
				charactersValuesLabels[i][4] = new JLabel(temp[3]);
				charactersValuesLabels[i][4].setBounds(512, 15, 100, 14);
				
				charactersLabels[i][5] = new JLabel("Save Date:");
				charactersLabels[i][5].setBounds(472, 72, 60, 14);
				charactersValuesLabels[i][5] = new JLabel(temp[4]);
				charactersValuesLabels[i][5].setBounds(532, 72, 100, 14);
				
				for(int j=0; j<6; j++)
				{
					charactersPanels[i].add(charactersLabels[i][j]);
					charactersPanels[i].add(charactersValuesLabels[i][j]);
										
				}
			}
			charactersListFileScanner.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		//Adds MouseListeners for every character panel, so we can actually load or create them by clicking at right panel
		charactersPanels[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!charactersValuesLabels[0][0].getText().isEmpty())
				{
					startGame(charactersValuesLabels[0][0].getText());
				}
				else
				{
					createCharacter();
				}
			}
		});
		charactersPanels[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!charactersValuesLabels[1][0].getText().isEmpty())
				{
					startGame(charactersValuesLabels[1][0].getText());
				}
				else
				{
					createCharacter();
				}
			}
		});
		charactersPanels[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!charactersValuesLabels[2][0].getText().isEmpty())
				{
					startGame(charactersValuesLabels[2][0].getText());
				}
				else
				{
					createCharacter();
				}
			}
		});
		charactersPanels[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!charactersValuesLabels[3][0].getText().isEmpty())
				{
					startGame(charactersValuesLabels[3][0].getText());
				}
				else
				{
					createCharacter();
				}
			}
		});
		charactersPanels[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!charactersValuesLabels[4][0].getText().isEmpty())
				{
					startGame(charactersValuesLabels[4][0].getText());
				}
				else
				{
					createCharacter();
				}
			}
		});
	}
	
	public void startGame(String characterName)
	{
		//open game screen and close character selection screen
		GameWindow gameWindow = new GameWindow(characterName);
		gameWindow.setVisible(true);
		this.dispose();
	}
	
	public void createCharacter()
	{
		//Input character's name
		String characterName = "";
		while(characterName.isEmpty() || !LoginScreen.checkCredentials(characterName) || alreadyExists(characterName))
		{
			characterName = JOptionPane.showInputDialog("What's your name?");
		}
		
		//Remove file with character's name if it already exists for some reason
		File characterFile = new File(charactersDirectory + "/" + characterName + ".txt");
		if(characterFile.isFile())
		{
			characterFile.delete();
		}
		
		//Make file with character's general info
		try
		{
			characterFile.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//Make character's save folder
		File characterSaveFolder = new File(charactersDirectory + "/" + characterName + "/");
		if(!characterSaveFolder.isDirectory())
		{
			characterSaveFolder.mkdir();
		}
		
		try
		{
			//Add character to file with character list 
			FileWriter fw = new FileWriter(charactersListFile, true);
			fw.write(characterName + "\n");
			fw.close();
			
			//Write starting statistics to character file
			fw = new FileWriter(characterFile);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date date = new Date();
			fw.write("Null;" + formatter.format(date) + ";13;0;" + formatter.format(date));
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		startGame(characterName);
	}
	
	
	private boolean alreadyExists(String characterName)
	{
		//Check if there already is a character with such name
		boolean hit = false;
		try 
		{
			Scanner scanner = new Scanner(charactersListFile);
			while(scanner.hasNextLine())
			{
				if(scanner.nextLine().equals(characterName))
				{
					hit = true;
				}
			}
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return hit;
	}
}
