package afafi;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LoginScreen extends JFrame 
{

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField passwordField;
	
	private JLabel errorLabel;
	
	private File dataDirectory = new File("data");
	private File accountsFile = new File(dataDirectory.getPath().concat("/accounts.txt"));
	
	
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
					LoginScreen frame = new LoginScreen();
					frame.setLocationRelativeTo(null);
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
	public LoginScreen() 
	{

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 217, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				login();
			}
		});
		loginButton.setBounds(302, 240, 100, 25);
		contentPane.add(loginButton);
		
		loginField = new JTextField();
		loginField.setBounds(302, 180, 100, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(302, 210, 100, 20);
		contentPane.add(passwordField);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(LoginScreen.class.getResource("/afafi/images/loginScreenLogo.png")));
		logo.setBounds(252, 52, 200, 117);
		contentPane.add(logo);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				register();
			}
		});
		registerButton.setBounds(302, 270, 100, 25);
		contentPane.add(registerButton);
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(227, 300, 250, 14);
		contentPane.add(errorLabel);
		fileExistsCheck(dataDirectory, accountsFile);
	}
	
	private void fileExistsCheck(File directory, File file)
	{
		if(!file.isFile()) //Check if exists and is not a directory
		{
			directory.mkdirs(); //makes all directories in specified path
			try
			{
				file.createNewFile();
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void login()
	{
		errorLabel.setText("");
		boolean credentialsHit = false;
		try		//check if accounts exists and password is correct
		{
			String line;
			String[] temp;
			Scanner scanner = new Scanner(accountsFile);
			while(!credentialsHit && scanner.hasNextLine())
			{
				line = scanner.nextLine();
				temp = line.split(";");
				temp[0]=temp[0].trim();
				temp[1]=temp[1].trim();
				if(temp[0].equals(loginField.getText()) && temp[1].equals(passwordField.getText()))
				{
					credentialsHit = true;
				}
			}
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		if(credentialsHit) // if login and password are correct, start character selection screen and dispose of login screen
		{
			CharacterSelectionScreen characterSelectionScreen = new CharacterSelectionScreen(loginField.getText());
			characterSelectionScreen.setVisible(true);
			this.dispose();	
		}
		else //if login and password are not correct, display error message
		{
			errorLabel.setForeground(new Color(255,0,0));
			errorLabel.setText("Incorrect login and/or password");
		}
	}
	
	private void register()
	{
		errorLabel.setText(null);
		if(!accountsFile.isFile()) //if there is no file associated with this account name, make it
		{
			try
			{
				accountsFile.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		//check for special characters and if login or password field are empty
		if(checkCredentials(loginField.getText()) && checkCredentials(passwordField.getText()) && !loginField.getText().isBlank() && !passwordField.getText().isBlank())
		{
			boolean alreadyExists = false;
			try
			{
				Scanner scanner = new Scanner(accountsFile);
				String[] temp;
				String line;
				while(scanner.hasNextLine()) //check if accounts already exists
				{
					line = scanner.nextLine();
					temp = line.split(";");
					temp[0] = temp[0].trim();
					if(temp[0].equals(loginField.getText()))
					{
						alreadyExists = true;
					}
				}
				scanner.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			
			if(!alreadyExists)
			{
				try
				{
					//Add login and password to file with list of accounts
					FileWriter fw = new FileWriter(accountsFile,true);
					fw.write(loginField.getText() + " ; " + passwordField.getText() + "\n");
					fw.close();
					errorLabel.setForeground(new Color(49,200,11));
					errorLabel.setText("Registered successfully");
					
					
					//Create account file, containing names of all characters made with this account
					File accountsDirectory = new File(dataDirectory.getPath().concat("/accounts"));
					File account = new File(accountsDirectory.getPath().concat("/" + loginField.getText() + ".txt"));
					if(account.isFile())
					{
						account.delete();
					}
					fileExistsCheck(accountsDirectory, account); //function creates specified directory and a file inside
					new File(accountsDirectory + "/" + loginField.getText()).mkdir(); //create a directory associated with created account
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				errorLabel.setForeground(new Color(255,0,0));
				errorLabel.setText("Account already exists");
			}
			
		}
		else
		{
			errorLabel.setForeground(new Color(255, 0, 0));
			errorLabel.setText("Incorrect characters in one of text fields");
		}
	}
	
	public static boolean checkCredentials(String text)
	{
		char[] chars = text.toCharArray();
		
		//check if all characters are letters of latin alphabet or digits
		for(char c:chars)
		{
			if(!Character.isLetterOrDigit(c))
				return false;
		}
		return true;
	}
}
