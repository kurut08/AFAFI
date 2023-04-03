package afafi;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	private File dataDirectory = new File("data");
	private File accountsFile = new File(dataDirectory.getPath().toString().concat("/accounts.txt"));
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public LoginScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 217, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				accountsFileCheck();
			}
		});
		loginButton.setBounds(302, 240, 100, 25);
		contentPane.add(loginButton);
		
		loginField = new JTextField();
		loginField.setBounds(302, 180, 100, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
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
				accountsFileCheck();
			}
		});
		registerButton.setBounds(302, 270, 100, 25);
		contentPane.add(registerButton);
	}
	
	private void accountsFileCheck()
	{
		if(!accountsFile.isFile()) //Check if exists and is not a directory
		{
			System.out.println("Test2");
			dataDirectory.mkdir();
			try
			{
				accountsFile.createNewFile();
				
			}
			catch(IOException e)
			{
				e.setStackTrace(null);
			}
		}
	}
}
